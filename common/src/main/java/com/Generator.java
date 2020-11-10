package com;


import com.generator.CodeGenerator;

/**
 * 自动生成代码工具
 *
 * @since 2019/1/25 17:28
 **/
public class Generator {
    public static void main(String[] args) {
        CodeGenerator.generator("/admin","order","1","goods_info");
    }
}
