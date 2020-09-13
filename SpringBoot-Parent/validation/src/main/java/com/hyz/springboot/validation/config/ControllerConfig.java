package com.hyz.springboot.validation.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Arrays;

/**
 * @author <a href="mailto:huangyuze@lvmama.com">hyz</a> <br>
 * @date 2020/9/12 - 16:55
 * @since
 */
@ControllerAdvice
@Slf4j
public class ControllerConfig {

    @ExceptionHandler
    @ResponseBody
    public HttpEntity<ErrorMessage> exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("exception:", e);
        ErrorMessage error = new ErrorMessage();
        error.setException(e.getClass().getName());
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        error.setTimestamp(System.currentTimeMillis());
        error.setPath(request.getRequestURI());
        error.setStackTrace(Arrays.toString(e.getStackTrace()));
        String message = e.getMessage() == null ? "系统内部错误" : e.getMessage();
        error.setMessage(message);
        return new HttpEntity<>(error);
    }

    public static class ErrorMessage implements Serializable {

        private static final long serialVersionUID = 1L;
        private long timestamp;
        private int status;
        private String error;
        private String exception;
        private String message;
        private String path;
        private String stackTrace;

        public long getTimestamp() {
            return timestamp;
        }
        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }
        public int getStatus() {
            return status;
        }
        public void setStatus(int status) {
            this.status = status;
        }
        public String getError() {
            return error;
        }
        public void setError(String error) {
            this.error = error;
        }
        public String getException() {
            return exception;
        }
        public void setException(String exception) {
            this.exception = exception;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }
        public String getPath() {
            return path;
        }
        public void setPath(String path) {
            this.path = path;
        }

        public String getStackTrace() {
            return stackTrace;
        }

        public void setStackTrace(String stackTrace) {
            this.stackTrace = stackTrace;
        }
    }
}
