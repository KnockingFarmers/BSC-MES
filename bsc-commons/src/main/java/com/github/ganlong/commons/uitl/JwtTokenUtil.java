package com.github.ganlong.commons.uitl;

import com.github.ganlong.commons.config.JwtInfo;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/14 18:50
 * @PackageName:com.github.ganlong.commons.uitl
 * @ClassName: JwtTokenUtil
 * @Description: TODO
 * @Version 1.0
 */
public class JwtTokenUtil {

    public static final Long EXTIRPATION = 1000L * 10L * 60L * 24L;

    private static final String SIGNATURE = "ganlong";

    public String generateToken(JwtInfo jwtInfo) {
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                //header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                //payload
                .claim(jwtInfo.getTokenDataKey(), jwtInfo.getTokenData())
                .setExpiration(new Date(System.currentTimeMillis() + EXTIRPATION))
                //signature
                .signWith(SignatureAlgorithm.HS256, SIGNATURE)
                .compact();
        return jwtToken;
    }

    public Map<String, Object> checkToken(String token) {

        Map<String, Object> resultMap = new HashMap<>(2);
        boolean pass = true;
        String msg;
        Jws<Claims> claimsJws = Jwts.parser().parseClaimsJws(token);
        String signature = claimsJws.getSignature();
        Date expiration = claimsJws.getBody().getExpiration();
        //验证签名
        if (!signature.equals(SIGNATURE)) {
            msg="签名无效";
            pass=false;
            //查看过期时间
        }else if (expiration.getTime()<= EXTIRPATION){
            msg="token已过期";
            pass=false;
        }

        //通过验证
        msg="OK";
        resultMap.put("pass",pass);
        resultMap.put("msg",msg);

        return resultMap;
    }

    public Map<String, Object> analyzeTokenData(String token, String key) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SIGNATURE).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        Map<String, Object> map = (Map<String, Object>) body.get(key);
        return map;
    }
}
