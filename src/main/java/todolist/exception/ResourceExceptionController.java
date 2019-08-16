package todolist.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;

import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ResourceExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ResourceNotFoundException.class})
    public ApiError handleResourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest  request) {
        return new ApiError(HttpStatus.NOT_FOUND,"Entity not found",request.getRequestURI(), exception);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleDataIntegrityViolationException(DataIntegrityViolationException exception, HttpServletRequest request) {
        return new ApiError(HttpStatus.BAD_REQUEST,"Entity not found",request.getRequestURI(), exception);
    }

    @ExceptionHandler({JpaSystemException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleJpaSystemException(JpaSystemException exception, HttpServletRequest request) {
        return new ApiError(HttpStatus.BAD_REQUEST,"Entity not found",request.getRequestURI(), exception);
    }



}
