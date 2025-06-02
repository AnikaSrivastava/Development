package Service;

import exceptions.UserValidationException;

@Service
public interface AuthService {
    public String login(String username, String password) throws UserValidationException;
    public Boolean signup(String username, String password) throws UserValidationException;

}
