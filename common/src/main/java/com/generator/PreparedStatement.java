package com.generator;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PreparedStatement {

    private static final String url = JdbcConst.URL;
    private static final String username = JdbcConst.USERNAME;
    private static final String password = JdbcConst.PASSWORD;
    private static final String TABLE_SQL = "show table status";

    public static void main(String[] args) throws SQLException {
//        System.out.println(getAllTableName());
        java.sql.PreparedStatement preparedStatement;
        ResultSet results;
        Connection connection = getDb().getConn();
        try {
            preparedStatement = connection.prepareStatement(TABLE_SQL+" like '%admin%'");
            results = preparedStatement.executeQuery();
            while (results.next()) {
                String tableName = results.getString("NAME");
                String comment = results.getString("COMMENT");

                printPermsConst(tableName, comment);
//                printSwaggerTag(tableName, comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    private static void printPermsConst(String tableName, String comment) {
        String lowerCase = tableName.toUpperCase();
        String admin = lowerCase.replace("ADMIN_", "");
//        tableName = tableName.replace("admin_", "");
//        tableName = underline2Camel(tableName);
//        tableName = underline2Camel(tableName);
        System.out.println("// " + comment);
        System.out.println("public final String " + admin + "_READ = \"" + lowerCase + "_READ\";");
        System.out.println("public final String " + admin + "_WRITE = \"" + lowerCase + "_WRITE\";");
        System.out.println("public final String " + admin + "_DEL = \"" + lowerCase + "_DEL\";");
//        System.out.println("public final String " + tableName + "_CREATE = \"" + camel2Underline(tableName) + "_CREATE\";");
        System.out.println("");

    }

    /**
     * 下划线转驼峰
     *
     * @param underline
     * @return
     */
    public static String underline2Camel(String underline) {
        Pattern pattern = Pattern.compile("[_]\\w");
        String camel = underline.toLowerCase();
        Matcher matcher = pattern.matcher(camel);
        while (matcher.find()) {
            String w = matcher.group().trim();
            camel = camel.replace(w, w.toUpperCase().replace("_", ""));
        }
        return camel;
    }

    /**
     * 驼峰转下划线
     *
     * @param camel
     * @return
     */
    public static String camel2Underline(String camel) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(camel);
        while (matcher.find()) {
            String w = matcher.group().trim();
            camel = camel.replace(w, "_" + w);
        }
        return camel.toUpperCase();
    }

    private static void printSwaggerTag(String tableName, String comment) {
        tableName = tableName.replace("bbt_", "");
        comment = comment.replace("表", "");
        //        String ADMIN_USER ="用户管理";
        String x = "String " + tableName.toUpperCase() + " = \"" + tableName.charAt(0) + "_" + comment + "\";";
        System.out.println(x);
    }

    public static DataSourceConfig getDb() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(username);
        dsc.setPassword(password);
        return dsc;
    }

    public static List<String> getPreTableName(String prefix) {
        List<String> result = new ArrayList<>();
        List<String> allTableName = getAllTableName();
        for (String tableName : allTableName) {
            if (tableName.startsWith(prefix)) {
                result.add(tableName);
            }
        }
        return result;
    }

    public static List<String> getAllTableName() {
        ArrayList<String> list = new ArrayList<>();
        Connection conn = getDb().getConn();
        try {
            java.sql.PreparedStatement preparedStatement = conn.prepareStatement(TABLE_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                list.add(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
