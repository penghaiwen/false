package com.config;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.utils.SubjectUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * @author hdj
 * @date 2018/5/16 15:06
 **/
@Log4j2
@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("保存"+ SubjectUtil.getId());
        myStrictInsertFill(metaObject, "createTime", LocalDateTime.now());
        myStrictInsertFill(metaObject, "createBy", SubjectUtil.getId());
        myStrictInsertFill(metaObject, "updateTime", LocalDateTime.now());
        myStrictInsertFill(metaObject, "updateBy", SubjectUtil.getId());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        myStrictUpdateFill(metaObject, "updateTime", LocalDateTime.now());
        myStrictUpdateFill(metaObject, "updateBy", SubjectUtil.getId());
    }


    /**
     * 严格填充,只针对非主键的字段,只有该表注解了fill 并且 字段名和字段属性 能匹配到才会进行填充(null 值不填充)
     *
     * @param metaObject
     * @param fieldName
     * @param fieldVal
     * @return
     */
    private MyMetaObjectHandler myStrictInsertFill(MetaObject metaObject, String fieldName, Object fieldVal) {
        if (null != fieldVal) {
            strictInsertFill(metaObject, fieldName, fieldVal.getClass(), fieldVal);
        }
        return this;
    }

    private MyMetaObjectHandler myStrictUpdateFill(MetaObject metaObject, String fieldName, Object fieldVal) {
        if (null != fieldVal) {
            strictUpdateFill(metaObject, fieldName, fieldVal.getClass(), fieldVal);
        }
        return this;
    }

}

