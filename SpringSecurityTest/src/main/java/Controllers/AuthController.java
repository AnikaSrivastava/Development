package Controllers;

import Service.AuthService;
import dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto response = new LoginResponseDto();

        String token = authService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("AUTH_TOKEN", "Bearer " + token);
        /*
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        */

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto) {

        SignupResponseDto response = new SignupResponseDto();
        try {
            if(authService.signup(signupRequestDto.getEmail(), signupRequestDto.getPassword())) {
                response.setResponseStatus(String.valueOf(RequestStatus.SUCCESS));
            }
            else {
                response.setResponseStatus(String.valueOf(RequestStatus.FAILURE));
            }

            return new ResponseEntity<>(response, HttpStatus.OK);

        }
        catch(Exception e) {
            response.setResponseStatus(String.valueOf(RequestStatus.FAILURE));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
