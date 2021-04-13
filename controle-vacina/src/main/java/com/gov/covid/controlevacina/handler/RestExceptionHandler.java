package com.gov.covid.controlevacina.handler;
import com.gov.covid.controlevacina.exception.ValidationExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler {

    private ValidationExceptionDetails validationExceptionDetails;

    public RestExceptionHandler(ValidationExceptionDetails validationExceptionDetails) {
        this.validationExceptionDetails = validationExceptionDetails;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidException
            (MethodArgumentNotValidException methodArgumentNotValidException){
        List<FieldError> fieldErrorList=  methodArgumentNotValidException
                                            .getBindingResult()
                                            .getFieldErrors();
        String fields = fieldErrorList.stream()
                                      .map(FieldError::getField)
                                      .collect(Collectors.joining(", "));
        String fieldsMessage = fieldErrorList.stream()
                                             .map(FieldError::getDefaultMessage)
                                             .collect(Collectors.joining(", "));

        return new ResponseEntity<>(
                new ValidationExceptionDetails(
                        "Campo Inválido",
                        HttpStatus.BAD_REQUEST.value(),
                        methodArgumentNotValidException.getMessage(),
                        methodArgumentNotValidException.getClass().getName(),
                        LocalDateTime.now(),
                        fields,
                        fieldsMessage), HttpStatus.BAD_REQUEST
                );}
}
