package com.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成类
 *
 * @author hdj
 * @since 2019/1/25 16:40
 **/
public class CodeGenerator {

    private static final String URL = JdbcConst.URL;
    private static final String USERNAME = JdbcConst.USERNAME;
    private static final String PASSWORD = JdbcConst.PASSWORD;



    private static StrategyConfig getStrategyConfig(String model, String tableName) {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService");
        strategy.setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        if (model.equals("1")) {
            strategy.setInclude(tableName);
        }
        if (model.equals("2")) {
            List<String> preTableName = PreparedStatement.getPreTableName(tableName);
            String[] strings = new String[preTableName.size()];
            strategy.setInclude(preTableName.toArray(strings));
        }
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("t_", "bbt_","", "mg_");
        List<TableFill> fillList = new ArrayList<>();
        fillList.add(new TableFill("create_time", FieldFill.INSERT));
        fillList.add(new TableFill("created_dt", FieldFill.INSERT));
        fillList.add(new TableFill("create_by", FieldFill.INSERT));
        fillList.add(new TableFill("update_by", FieldFill.INSERT_UPDATE));
        fillList.add(new TableFill("update_time", FieldFill.INSERT_UPDATE));
        strategy.setVersionFieldName("version");
        strategy.setTableFillList(fillList);// 字段自定义填充
        strategy.setLogicDeleteFieldName("delete_flag");// 设置逻辑删除字段属性名
        return strategy;
    }

    public static void generator(String packagePath, String moduleName, String model, String tableName) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        if (!StringUtils.containsLowerCase("/")) {
            packagePath = "/" + packagePath;
        }
        String projectPath = System.getProperty("user.dir") + packagePath;
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("老默");
        gc.setOpen(false);
        gc.setSwagger2(true);
        gc.setIdType(IdType.AUTO);
        gc.setActiveRecord(true);
        gc.setBaseResultMap(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent("com.example.demo");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = getStrategyConfig(model, tableName);

        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        // strategy.setTablePrefix("sys_", "app_");
        List<TableFill> fillList = new ArrayList<>();
        fillList.add(new TableFill("create_time", FieldFill.INSERT));
        fillList.add(new TableFill("create_by", FieldFill.INSERT));
        fillList.add(new TableFill("update_by", FieldFill.INSERT_UPDATE));
        fillList.add(new TableFill("update_time", FieldFill.INSERT_UPDATE));
        strategy.setTableFillList(fillList);
        strategy.setLogicDeleteFieldName("delete_flag");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
