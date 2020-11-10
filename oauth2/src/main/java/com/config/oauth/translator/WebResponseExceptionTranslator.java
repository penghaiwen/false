package com.config.oauth.translator;

import com.exception.RestBean;
import com.exception.RestException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.UnsupportedGrantTypeException;
import org.springframework.stereotype.Component;


/**
 * 异常翻译
 *
 * @author hdj
 */
@Slf4j
@Component
public class WebResponseExceptionTranslator implements org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator {

    @Override
    public ResponseEntity translate(Exception e) {
        log.error( e.getMessage());
        ResponseEntity.BodyBuilder status = ResponseEntity.status(HttpStatus.OK);
        String message = e.getMessage();
        if (e instanceof RestException) {
            message = e.getMessage();
            return status.body(RestBean.error(message));
        }
        if (e instanceof UnsupportedGrantTypeException) {
            message = "不支持该认证类型";
            return status.body(RestBean.error(message));
        }
        if (e instanceof InvalidGrantException) {
            if (StringUtils.containsIgnoreCase(e.getMessage(), "Invalid refresh token")) {

                message = "登录已过期，请重新登录";
                return status.body(RestBean.error(401, message));
            }
            if (StringUtils.containsIgnoreCase(e.getMessage(), "locked")) {
                message = "用户已被锁定，请联系管理员";
                return status.body(RestBean.error(message));
            }
            if (StringUtils.containsIgnoreCase(e.getMessage(), "Wrong client")) {
                message = "错误的客户端";
                return status.body(RestBean.error(message));
            }
            log.error(message, e.getMessage());
            message = "用户名或密码错误";
            return status.body(RestBean.error(message));
        }

        // springSecurity异常
        if (e instanceof InternalAuthenticationServiceException) {
            message = e.getMessage();
        }
        return status.body(RestBean.error(message));
    }
}
