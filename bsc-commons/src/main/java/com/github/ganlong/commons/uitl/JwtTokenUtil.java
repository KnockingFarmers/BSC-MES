package com.github.ganlong.commons.uitl;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

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
}
