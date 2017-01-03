package hermes.configuration.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.annotation.Annotation;

/**
 * Created by yanyuyu on 2017/1/3.
 */
@Component("loginResolver")
public class LoginResolver implements HandlerMethodArgumentResolver {

    private static Logger log = LoggerFactory.getLogger(LoginResolver.class);

    public LoginResolver() {
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Annotation[] methodAnnotations = parameter.getMethodAnnotations();
        log.debug("supportsParameter execute ." );
        for(Annotation annotation : methodAnnotations) {
            if(Login.class.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return null;
    }
}
