package vn.primary.store.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import java.security.KeyPair;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;
import org.springframework.stereotype.Service;
import vn.primary.common.config.security.JwtProperties;
import vn.primary.common.config.security.SecurityProperties;
import vn.primary.common.storage.StorageService;
import vn.primary.store.dao.model.UserEntity;
import vn.primary.store.dao.repository.UserRepository;

@Service
public class TokenServiceImpl implements TokenService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private StorageService storageService;

  @Autowired
  private SecurityProperties securityProperties;

  @Override
  public UserEntity getUserFromToken(HttpServletRequest httpServletRequest) {
    String token = httpServletRequest.getHeader("Authorization").replace("Bearer ","");
    return getUserFromToken(token);
  }

  private UserEntity getUserFromToken(String token){
    JwtProperties jwtProperties = securityProperties.getJwt();

    Jws<Claims> claimsJws = Jwts.parser()
        .setSigningKey(keyPair(jwtProperties, keyStoreKeyFactory(jwtProperties)).getPrivate())
        .parseClaimsJws(token);

    Claims body = claimsJws.getBody();
    String username = body.get("user_name",String.class);
    return userRepository.findByUsername(username).get();
  }

  private KeyPair keyPair(JwtProperties jwtProperties, KeyStoreKeyFactory keyStoreKeyFactory) {
    return keyStoreKeyFactory.getKeyPair(jwtProperties.getKeyPairAlias(),
        jwtProperties.getKeyPairPassword().toCharArray());
  }

  private KeyStoreKeyFactory keyStoreKeyFactory(JwtProperties jwtProperties) {
    return new KeyStoreKeyFactory(
        storageService.loadAsResource(securityProperties.getJwt().getPrivateKeyStore(), null),
        jwtProperties.getKeyStorePassword().toCharArray());
  }
}
