package hermes.configuration.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by yanyuyu on 2017/1/17.
 */
public class ResponseModel<T> {

    private T data;

    private String message = "";

    private T error;

    private String debug;

    public ResponseModel() {
    }

    public ResponseModel(T data) {
        this.data = data;
    }

    public ResponseModel(String message) {
        if (null != message)
            this.message = message;
    }

    public void setMessage(String message) {
        if (null != message)
            this.message = message;
    }

    public void setData(T data) {
        if (null != data)
            this.data = data;
    }

    public void setError(T error) {
        if (null != error)
            this.error = error;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public T getError() {
        return this.error;
    }

    public String getDebug() {
        return this.debug;
    }

    public void setDebug(String debug) {
        this.debug = debug;
    }


    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ResponseModel)) return false;
        ResponseModel other = (ResponseModel) o;
        if (!other.canEqual(this)) return false;
        Object this$message = getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
        Object this$data = getData();
        Object other$data = other.getData();
        if (this$data == null ? other$data != null : !this$data.equals(other$data)) return false;
        Object this$error = getError();
        Object other$error = other.getError();
        if (this$error == null ? other$error != null : !this$error.equals(other$error)) return false;
        Object this$debug = getDebug();
        Object other$debug = other.getDebug();
        return this$debug == null ? other$debug == null : this$debug.equals(other$debug);
    }

    public boolean canEqual(Object other) {
        return other instanceof ResponseModel;
    }

    public int hashCode() {
        int result = 1;
        Object $message = getMessage();
        result = result * 31 + ($message == null ? 0 : $message.hashCode());
        Object $data = getData();
        result = result * 31 + ($data == null ? 0 : $data.hashCode());
        Object $error = getError();
        result = result * 31 + ($error == null ? 0 : $error.hashCode());
        Object $debug = getDebug();
        result = result * 31 + ($debug == null ? 0 : $debug.hashCode());
        return result;
    }

    public String toString() {
        return "ResponseModel(message=" + getMessage() + ", data=" + getData() + ", error=" + getError() + ", debug=" + getDebug() + ")";
    }

}
