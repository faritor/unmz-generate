package net.unmz.java.util.generate.defined;

/**
 * Project Name: 批量生成项目
 * 功能描述：动态数据模型
 *
 * @author Faritor
 * @version 1.0
 * @date 2017-11-14 13:54
 * @since JDK 1.8
 */
public class DataModel {

    private static String basePackage;
    private static String businessPackage;
    private static String category;
    private static String url;
    private static String username;
    private static String password;
    private static String databaseName;
    private static String sourceRootPackage = "out";
    private static String projectName;
    private static String funcDesc;
    private static boolean ignoreHead = false;

    public static String getBusinessPackage() {
        return businessPackage;
    }

    public static void setBusinessPackage(String businessPackage) {
        DataModel.businessPackage = businessPackage;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        DataModel.url = url;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        DataModel.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DataModel.password = password;
    }

    public static String getDatabaseName() {
        return databaseName;
    }

    public static void setDatabaseName(String databaseName) {
        DataModel.databaseName = databaseName;
    }

    public static String getSourceRootPackage() {
        return sourceRootPackage;
    }

    public static void setSourceRootPackage(String sourceRootPackage) {
        DataModel.sourceRootPackage = sourceRootPackage;
    }

    public static String getProjectName() {
        return projectName;
    }

    public static void setProjectName(String projectName) {
        DataModel.projectName = projectName;
    }

    public static String getFuncDesc() {
        return funcDesc;
    }

    public static void setFuncDesc(String funcDesc) {
        DataModel.funcDesc = funcDesc;
    }

    public static String getBasePackage() {
        return basePackage;
    }

    public static void setBasePackage(String basePackage) {
        DataModel.basePackage = basePackage;
    }

    public static String getCategory() {
        return category;
    }

    public static void setCategory(String category) {
        DataModel.category = category;
    }

    public static boolean isIgnoreHead() {
        return ignoreHead;
    }

    public static void setIgnoreHead(boolean ignoreHead) {
        DataModel.ignoreHead = ignoreHead;
    }
}
