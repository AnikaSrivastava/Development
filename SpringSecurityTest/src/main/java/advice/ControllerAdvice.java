package advice;

import dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponseDto> handleRuntimeExceptions(RuntimeException e) {
        ErrorResponseDto errorResponse = new ErrorResponseDto("500", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RestClientException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponseDto> handleRestClientExceptions(RestClientException e) {
        ErrorResponseDto errorResponse = new ErrorResponseDto("502", "External API call failed: " + e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponseDto> handleHttpClientErrorExceptions(HttpClientErrorException e) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                String.valueOf(e.getStatusCode().value()), e.getResponseBodyAsString());
        return new ResponseEntity<>(errorResponse, e.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorResponseDto> handleAllExceptions(Exception e) {
        ErrorResponseDto errorResponse = new ErrorResponseDto("500", "Something went wrong: " + e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
