package net.unmz.java.util.generate.defined;

import java.util.ResourceBundle;

public class CodeResourceUtil {
    private static final ResourceBundle bundle = ResourceBundle.getBundle("faritor/unmz_database");
    private static final ResourceBundle bundlePath = ResourceBundle.getBundle("faritor/unmz_config");

    public static String DIVER_NAME = "com.mysql.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false&zeroDateTimeBehavior=convertToNull";
    public static String USERNAME = "root";
    public static String PASSWORD = "mysql";
    public static String DATABASE_NAME = "sys";
    public static String DATABASE_TYPE = "mysql";
    public static String DATABASE_TYPE_MYSQL = "mysql";
    public static String DATABASE_TYPE_ORACLE = "oracle";
    public static String FARITOR_UI_FIELD_SEARCH_NUM = "3";
    public static String source_root_package = "src";
    public static String businessPackage = "sun";
    public static String businessPackageUrl = "sun";
    public static String TEMPLATE_PATH;
    public static String FARITOR_GENERATE_TABLE_ID;
    public static String SYSTEM_ENCODING;

    static {
        DIVER_NAME = getDIVER_NAME();
        URL = getURL();
        USERNAME = getUSERNAME();
        PASSWORD = getPASSWORD();
        DATABASE_NAME = getDATABASE_NAME();
        SYSTEM_ENCODING = getSYSTEM_ENCODING();
        TEMPLATE_PATH = getTemplatePath();
        source_root_package = getSourceRootPackage();
        businessPackage = getBusinessPackage();
        businessPackageUrl = businessPackage.replace(".", "/");
        FARITOR_GENERATE_TABLE_ID = getUnmz_generate_table_id();
        FARITOR_UI_FIELD_SEARCH_NUM = getUnmz_ui_search_filed_num();
        if ((URL.indexOf("mysql") >= 0) || (URL.indexOf("MYSQL") >= 0))
            DATABASE_TYPE = DATABASE_TYPE_MYSQL;
        else if ((URL.indexOf("oracle") >= 0) || (URL.indexOf("ORACLE") >= 0)) {
            DATABASE_TYPE = DATABASE_TYPE_ORACLE;
        }
        source_root_package = source_root_package.replace(".", "/");
    }

    public static final String getDIVER_NAME() {
        return bundle.getString("diver_name");
    }

    public static final String getURL() {
        return bundle.getString("url");
    }

    public static final String getUSERNAME() {
        return bundle.getString("username");
    }

    public static final String getPASSWORD() {
        return bundle.getString("password");
    }

    public static final String getDATABASE_NAME() {
        return bundle.getString("database_name");
    }

    private static String getBusinessPackage() {
        return bundlePath.getString("business_package");
    }

    public static final String getTemplatePath() {
        return bundlePath.getString("template_path");
    }

    public static final String getSourceRootPackage() {
        return bundlePath.getString("source_root_package");
    }

    public static final String getSYSTEM_ENCODING() {
        return bundlePath.getString("system_encoding");
    }

    public static final String getUnmz_generate_table_id() {
        return bundlePath.getString("unmz_generate_table_id");
    }

    public static final String getUnmz_ui_search_filed_num() {
        return bundlePath.getString("unmz_ui_search_filed_num");
    }

}