package com.utils;


import com.security.JwtUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class SubjectUtil {

    /**
     * 获取当前用户
     *
     * @return
     */
    public static JwtUser getSubject() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if(principal instanceof JwtUser){
                return (JwtUser) principal;
            }
        }
        return new JwtUser();
    }

    /**
     * 获取用户id
     *
     * @return
     */
    public static Long getId() {
        return getSubject().getId();
    }

    /**
     * 获取用户昵称
     *
     * @return
     */
    public static String getName() {
        return getSubject().getNickname();
    }

    /**
     * 获取用户账号
     *
     * @return
     */
    public static String getUsername() {
        return getSubject().getUsername();
    }

    /**
     * 获取用户账号类型
     *
     * @return
     */
    public static  Integer getUserType(){
        return getSubject().getUserType();
    }

    

}
