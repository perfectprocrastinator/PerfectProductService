package com.procrastinator.perfectproductservice.advices;

import com.procrastinator.perfectproductservice.dtos.ExceptionDTO;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(RuntimeException.class)
    public ExceptionDTO handleRuntimeException(RuntimeException e){
        ExceptionDTO exceptionDTO=new ExceptionDTO();
        exceptionDTO.setError("Error Occured");
        exceptionDTO.setMessage(e.getMessage());
        return exceptionDTO;
    }

}
