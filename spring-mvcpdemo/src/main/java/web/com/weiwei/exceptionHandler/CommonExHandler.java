package web.com.weiwei.exceptionHandler;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundHandler() {
        return "error/404";
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String httpRequestMethodNotSupportedHandler() {
        return "error/405";
    }
}
