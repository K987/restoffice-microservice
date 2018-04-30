package hu.restoffice.transaction.error;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 */
@RestControllerAdvice
public class ServiceExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<?> handleServiceException(final ServiceException ex, final WebRequest request) {
        HttpStatus status;
        switch(ex.getType()) {
            case ALREADY_EXISTS:
                status = HttpStatus.BAD_REQUEST;
                break;
            case NOT_EXISTS:
                status = HttpStatus.NOT_FOUND;
                break;
            case UNKNOWN:
            default:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
        }
        return handleExceptionInternal(ex, new ErrorBody(ex, status), new HttpHeaders(), status, request);
    }

    public static class ErrorBody {

        private LocalDateTime timeStamp;
        private URI self;
        private HttpStatus status;
        private String message;
        private Optional<Object> errorObject;

        private ErrorBody(final ServiceException ex, final HttpStatus status) {
            timeStamp = LocalDateTime.now();
            this.status = status;
            message = ex.getMessage();
            errorObject = ex.getErrorObject();
        }

        /**
         * @return the timeStamp
         */
        public LocalDateTime getTimeStamp() {
            return timeStamp;
        }

        /**
         * @return the status
         */
        public HttpStatus getStatus() {
            return status;
        }

        /**
         * @return the message
         */
        public String getMessage() {
            return message;
        }

        /**
         * @return the errorObject
         */
        public Optional<Object> getErrorObject() {
            return errorObject;
        }

    }

}
