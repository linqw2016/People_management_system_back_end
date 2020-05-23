package org.linqw.vhr.exception;

import org.linqw.vhr.model.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e){
        if(e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("外键关联异常，操作失败");
        }
        return RespBean.error("数据库异常，操作失败！");

    }

}
