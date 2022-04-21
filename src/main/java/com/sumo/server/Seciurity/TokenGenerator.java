package com.sumo.server.Seciurity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sumo.server.userData.Role.Role;
import com.sumo.server.userData.User.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;

public class TokenGenerator {
    // narazie do naszych celów sekret ustawiony na sekret wystarczy potem zmieni się to na coś lepszego
    @Getter
    private static final Algorithm algorithm = Algorithm.HMAC256("secret".getBytes(StandardCharsets.UTF_8));
    @Getter
    private static final long accessTokenTimeToLive = 10 * 60 * 1000;
    @Getter
    private static final long refreshTokenTimeToLive = 60 * 60 * 1000;

    public static String generateAccessToken(User user, HttpServletRequest request) {
        return JWT.create()
            .withSubject(user.getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + accessTokenTimeToLive))
            .withIssuer(request.getRequestURL().toString())
            .withClaim("roles", user.getRoles().stream().map(Role::getRoleName).collect(Collectors.toList()))
            .sign(algorithm);
    }

    public static String generateAccessToken(org.springframework.security.core.userdetails.User user, HttpServletRequest request) {
        return JWT.create()
            .withSubject(user.getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + accessTokenTimeToLive))
            .withIssuer(request.getRequestURL().toString())
            .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
            .sign(algorithm);
    }

    public static String generateRefreshToken(User user, HttpServletRequest request) {
        return JWT.create()
            .withSubject(user.getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + refreshTokenTimeToLive))
            .withIssuer(request.getRequestURL().toString())
            .sign(algorithm);
    }

    public static String generateRefreshToken(org.springframework.security.core.userdetails.User user, HttpServletRequest request) {
        return JWT.create()
            .withSubject(user.getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + refreshTokenTimeToLive))
            .withIssuer(request.getRequestURL().toString())
            .sign(algorithm);
    }

}
