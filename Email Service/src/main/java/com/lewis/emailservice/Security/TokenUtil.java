// package com.lewis.critics.Security;
//
// import com.lewis.critics.Utils.ConstantUtils;
// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;
//
// import java.io.Serializable;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.function.Function;
//
// /**
//  * Created by Lewis.Aguh on 08/08/2019
//  */
//
// @Component
// public class TokenUtil implements Serializable {
//
//     private static final long serialVersionUID = -2550185165626007488L;
//
//     //TODO: Research time for token to expire
//     private static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
//
//     //retrieve username from jwt token
//     public String getUsernameFromToken(String token) {
//         return getClaimFromToken(token, Claims::getSubject);
//     }
//
//     //retrieve expiration date from jwt token
//     public Date getExpirationDateFromToken(String token) {
//         return getClaimFromToken(token, Claims::getExpiration);
//     }
//
//     public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//         final Claims claims = getAllClaimsFromToken(token);
//         return claimsResolver.apply(claims);
//     }
//
//     //for retrieving any information from token we will need the secret key
//     private Claims getAllClaimsFromToken(String token) {
//         return Jwts.parser().setSigningKey(ConstantUtils.JWT_SECRET).parseClaimsJws(token).getBody();
//     }
//
//     //check if the token has expired
//     private Boolean isTokenExpired(String token) {
//         final Date expiration = getExpirationDateFromToken(token);
//         return expiration.before(new Date());
//     }
//
//     //generate token for user
//     public String generateToken(UserDetails userDetails){
//         Map<String, Object> claims = new HashMap<>();
//         return doGenerateToken(claims, userDetails.getUsername());
//     }
//
//     //while createing the token -
//     //1. Define claims of the token, like issuer, Expiration, Subject and ID
//     //2. Sign the JWT using the HS512 algorithm and secret key
//     //3. Accrding to the JWS Compact Serialization - Compaction of the JWS to a URL-safe string
//     private String doGenerateToken(Map<String, Object> claims, String subject) {
//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(subject)
//                 .setIssuedAt(new Date(System.currentTimeMillis()))
//                 .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
//                 .signWith(SignatureAlgorithm.HS512, ConstantUtils.JWT_SECRET)
//                 .compact();
//     }
//
//     //validate token
//     public boolean validateToken(String token, UserDetails userDetails) {
//         final String username = getUsernameFromToken(token);
//         return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
//     }
//
// }
