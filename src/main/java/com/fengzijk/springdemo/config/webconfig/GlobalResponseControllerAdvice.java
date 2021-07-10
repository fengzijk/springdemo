package com.fengzijk.springdemo.config.webconfig;

import com.fengzijk.springdemo.config.model.ResponseEntity;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 */
@RestControllerAdvice
public class GlobalResponseControllerAdvice {


    /**
     * 拦截MethodArgumentNotValidException异常，针对body参数的表单注解（如：@NotEmpty）校验拦截
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        LogManager.getLogger().warn("MethodArgumentNotValidException,message={},Exception={}", e.getMessage(),
                ExceptionUtils.getStackTrace(e));
        List<ObjectError> objectErrors = e.getBindingResult().getAllErrors();
        if (!CollectionUtils.isEmpty(objectErrors) && objectErrors.size() > 0) {
            return new ResponseEntity<>().badRequest(objectErrors.get(0).getDefaultMessage());
        }

        return new ResponseEntity<>().badRequest();
    }



}

