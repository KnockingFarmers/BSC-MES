package com.github.ganlong.commons.uitl;

import com.github.ganlong.commons.config.JwtInfo;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
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
@Slf4j
public class JwtTokenUtil {

    /**
     * JWT过期时间
     */
    public static final Long EXTIRPATION = 1000L * 10L * 60L * 24L;

    /**
     * JWT签名
     */
    private static final String SIGNATURE = "ganlong";

    /**
     * 私钥
     */
    private static String SECRET_KEY = "NiJoSecret";

    public static String generateToken(String subject) {


        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                //header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                //subject
                .setSubject(subject)
                //签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXTIRPATION))
                //signature
                .signWith(SignatureAlgorithm.HS256, SIGNATURE)
                .compact();
        return jwtToken;
    }

    public static Map<String, Object> checkToken(String token) {

        Map<String, Object> resultMap = new HashMap<>(2);
        boolean pass = true;
        String msg;
        Jws<Claims> claimsJws = Jwts.parser().parseClaimsJws(token);
        String signature = claimsJws.getSignature();
        Date expiration = claimsJws.getBody().getExpiration();
        //验证签名
        if (!signature.equals(SIGNATURE)) {
            msg = "签名无效";
            pass = false;
            //查看过期时间
        } else if (expiration.getTime() <= EXTIRPATION) {
            msg = "token已过期";
            pass = false;
        }

        //通过验证
        msg = "OK";
        resultMap.put("pass", pass);
        resultMap.put("msg", msg);

        return resultMap;
    }

    public static Claims analyzeTokenData(String token) {

        Jws<Claims> claimsJws = null;
        try {
            claimsJws = Jwts.parser()
                    .setSigningKey(SIGNATURE)
                    .parseClaimsJws(token);
        } catch (ExpiredJwtException expiredJwtException) {
            log.info("token过期");
            expiredJwtException.printStackTrace();
        } catch (RuntimeException e) {
            log.info("非法token");
            e.printStackTrace();
        } finally {

            return claimsJws.getBody();
        }


    }

    /**
     * 生成加密后的秘钥 secretKey
     *
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(SECRET_KEY);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
}
