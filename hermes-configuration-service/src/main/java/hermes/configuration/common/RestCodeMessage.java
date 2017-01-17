package hermes.configuration.common;

/**
 * Created by yanyuyu on 2017/1/17.
 */
public class RestCodeMessage {

    public static final class Code {
        public static final int SUCCESS = 200;
        // 永久迁移
        public static final int MOVED_PERMANENTLY = 301;
        // 临时重定向
        public static final int TEMPORARY_REDIRECT = 302;
        // 请求格式错误
        public static final int BAD_REQUEST = 400;
        // 未授权
        public static final int UNAUTHORIZED = 401;
        // 禁止访问
        public static final int FORBIDDEN = 403;
        // 资源不存在
        public static final int RESOURCE_NOT_FOUND = 404;
        // 不允许该操作
        public static final int METHOD_NOT_ALLOWED = 405;
        // 通用冲突
        public static final int RESOURCE_CONFLICT = 409;
        // 资源已被逻辑删除
        public static final int RESOURCE_IS_DELETED = 410;
        // 无法处理的实体
        public static final int UNPROCESSABLE_ENTITY = 422;
        // 服务端内部错误
        public static final int INTERNAL_SERVER_ERROR = 500;
    }

    public static final class Message {
        public static final String SUCCESS = "成功";

        public static final String INTERNAL_SERVER_ERROR = "系统繁忙，请稍后再试";

        public static final String BAD_REQUEST = "请求格式错误";

        public static final String RESOURCE_NOT_FOUND = "资源不存在";

    }
}
