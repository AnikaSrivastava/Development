package Service;

import Repositories.SessionRepo;
import Repositories.UserRepo;
import exceptions.UserValidationException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import models.Role;
import models.Session;
import models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.*;

@Service
public class AuthServiceImpl implements AuthService {

    private UserRepo userRepo;
    private SessionRepo sessionRepo;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    //private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private SecretKey secretKey = Keys.hmacShaKeyFor("My Secret Key is really good".getBytes());


    public AuthServiceImpl(UserRepo userRepo, SessionRepo sessionRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.sessionRepo = sessionRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public String login(String email, String password) throws UserValidationException {
      Optional<User> userOptional = userRepo.findByEmail(email);
      if (userOptional.isEmpty()) {
          throw new UserValidationException("User with email " + email + " not found");
      }

      String token = createJwtToken(userOptional.get().getId(),userOptional.get().getRoles() , email);

      boolean matches = bCryptPasswordEncoder.matches(password, userOptional.get().getPassword());
      if (matches) {

      }
        return "";
    }

    public String createJwtToken(int userId, List<Role> roles, String email) {
        Map<String, Object> dataInJwt = new HashMap<>();
        dataInJwt.put("user_id", userId);
        dataInJwt.put("roles", roles);
        dataInJwt.put("email", email);

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date endDate = calendar.getTime();

        return Jwts.builder()
                .setClaims(dataInJwt)
                .setExpiration(endDate)
                .setIssuedAt(new Date())
                .signWith(secretKey)
                .compact();

    }

    @Override
    public Boolean signup(String email, String password) throws UserValidationException {
        if(userRepo.findByEmail(email) != null) {
            throw new UserValidationException("User with email id " + email + " already exists.");

        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        userRepo.save(user);
        return true;
    }
}
