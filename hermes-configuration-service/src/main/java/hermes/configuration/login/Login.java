package hermes.configuration.login;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * 登录权限校验
 * Created by yanyuyu on 2017/1/3.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Login {
}
