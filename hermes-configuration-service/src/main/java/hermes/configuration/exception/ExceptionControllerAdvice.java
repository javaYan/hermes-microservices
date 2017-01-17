package hermes.configuration.exception;

import hermes.configuration.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Rest异常处理类：用于返回指定的httpStatus、 message、 debug
 */
@RestControllerAdvice(basePackages = "hermes")
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {
    private static final Map emptyMap = new HashMap();

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResponseModel<Object> handleControllerException(BaseException baseException, HttpServletResponse response) {
        HttpStatus status = getStatus(baseException.getHttpStatus());
        ResponseModel responseModel = new ResponseModel(emptyMap);
        responseModel.setMessage(baseException.getMessage());
        if(baseException.getDebug() != null) {
            responseModel.setDebug(baseException.getDebug());
        }
        if(baseException.getError() != null) {
            responseModel.setError(baseException.getError());
        }
        response.setStatus(baseException.getHttpStatus());
        return responseModel;
    }

    private HttpStatus getStatus(Integer httpStatus) {
        if (httpStatus == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(httpStatus);
    }
}