package com.github.ganlong.commons.uitl;

import com.github.ganlong.commons.config.JwtInfo;
import io.jsonwebtoken.*;

import java.util.Date;
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

    public String generateToken(JwtInfo jwtInfo){
        JwtBuilder jwtBuilder= Jwts.builder();
        String jwtToken=jwtBuilder
                //header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                //payload
                .claim("user",jwtInfo)
                .setExpiration(new Date(System.currentTimeMillis()))
                //signature
                .signWith(SignatureAlgorithm.HS256,"admin")
                .compact();
        return jwtToken;
    }

    public Integer checkToken(String token){

        try {
            Jwts.parser().setSigningKey("admin").parseClaimsJws(token);
        }catch (JwtException e){
            return 0;
        }
        return 1;
    }

    public Map<String,Object> analyzeToken(String token,String key){
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey("admin").parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        Map<String,Object> map = (Map<String, Object>) body.get(key);
        return map;
    }
}
