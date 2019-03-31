package com.maoqin.movie.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

public class JWTUtil {

    // 过期时间5分钟
    private static final long EXPIRE_TIME = 5000000*60*1000;
    private static final String secret = "suyou";
    /**
     * 校验token是否正确
     * @param request 密钥
     * @return 是否正确
     */
    public static boolean verify(HttpServletRequest request) {
        try {
            String token=request.getHeader("token");
            String username = JWT.decode(token).getClaim("username").asString();
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static String getCurrentUsername(HttpServletRequest request) {
        try {
            String token=request.getHeader("token");
            if (StringTools.isNullOrEmpty(token)){
                return null;
            }
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
    public static String getCurrentUsernameByToken(String token) {
        try {
            //String token=request.getHeader("token");
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
    /**
     * @param username 用户名
     * @return 加密的token
     */
    public static String sign(String username) {
        try {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(System.currentTimeMillis());
            calendar.setTime(date);
//        calendar.add(Calendar.WEEK_OF_YEAR, -1);
            calendar.add(Calendar.YEAR, 10);
//            calendar.add(Calendar.DATE, 1);
            date = calendar.getTime();
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带username信息
            return JWT.create()
                    .withClaim("username", username)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }


    public static void main(String[] args) {
        String username = "leo";
        String token = JWTUtil.sign(username);
        System.out.println(token);
    }
}
