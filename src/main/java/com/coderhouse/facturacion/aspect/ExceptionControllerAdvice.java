package com.coderhouse.facturacion.aspect;

import com.coderhouse.facturacion.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDTO> handleRuntimeException(RuntimeException ex){
        ErrorDTO error = new ErrorDTO(ex.getMessage());
        return basicHandler(BAD_REQUEST, error, ex);
    }

    private ResponseEntity<ErrorDTO> basicHandler(HttpStatus statusErrorHttp, ErrorDTO apiError,
                                                             Exception exception) {

        return new ResponseEntity(apiError, statusErrorHttp);
    }
}
