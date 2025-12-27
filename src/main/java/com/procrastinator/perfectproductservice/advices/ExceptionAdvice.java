package com.procrastinator.perfectproductservice.advices;

import com.procrastinator.perfectproductservice.dtos.ExceptionDTO;
import com.procrastinator.perfectproductservice.exceptions.ProductNotFoundException;
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
    @ExceptionHandler(ProductNotFoundException.class)
    public ExceptionDTO handleProductNotFoundException(ProductNotFoundException e){
        ExceptionDTO exceptionDTO=new ExceptionDTO();
        exceptionDTO.setError("Error Occured to Fetch Product from Database");
        exceptionDTO.setMessage(e.getMessage());
        return exceptionDTO;

    }

}
