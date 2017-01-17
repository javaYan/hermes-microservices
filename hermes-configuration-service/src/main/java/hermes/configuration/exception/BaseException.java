package hermes.configuration.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

/**
 * Created by yanyuyu on 2017/1/17.
 */
@Getter @Setter
public class BaseException extends  RuntimeException implements Serializable{

    private Integer httpStatus;

    private String message;

    private String debug;

    private Object error;

    public BaseException(Integer httpStatus, String message) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public BaseException BaseException(Integer httpStatus, String message, String debug) {
        this.message = message;
        this.debug = debug;
        this.httpStatus = httpStatus;
        return this;
    }

    public BaseException BaseException(Integer httpStatus, String message) {
        this.message = message;
        this.httpStatus = httpStatus;
        return this;
    }

    public BaseException debug(String debug) {
        this.debug = debug;
        return this;
    }

    public BaseException error(Object error) {
        this.error = error;
        return this;
    }

}
