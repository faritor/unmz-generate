package net.unmz.java.util.generate.factory;

import net.unmz.java.util.generate.CommonPageParser;
import net.unmz.java.util.generate.CreateBean;
import net.unmz.java.util.generate.defined.DataModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.VelocityContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CodeGenerateFactory {
    private static final Log log = LogFactory.getLog(CodeGenerateFactory.class);
    private static String url = DataModel.getUrl();
    private static String username = DataModel.getUsername();
    private static String passWord = DataModel.getPassword();
    private static String projectName = DataModel.getProjectName();
    private static String funcDesc = DataModel.getFuncDesc();

    private static String buss_package = DataModel.getBusinessPackage();
    private static String projectPath = getProjectPath();

    public static void codeGenerateList(List<String> tableList, String codeName, String controllerEntityPackage, String keyType, String author) {
        if (tableList != null)
            for (String tableName : tableList) {
                codeGenerate(tableName, codeName, controllerEntityPackage, controllerEntityPackage, keyType, author);
            }
    }

    public static void codeGenerate(String tableName, String codeName, String controllerEntityPackage, String keyType, String author) {
        codeGenerate(tableName, codeName, "", controllerEntityPackage, keyType, author);
    }

    public static void codeGenerate(String tableName, String codeName, String entityPackage, String controllerEntityPackage, String keyType, String author) {
        CreateBean createBean = new CreateBean();
        createBean.setMysqlInfo(url, username, passWord);

        String className = createBean.getTablesNameToClassName(tableName);
        String lowerName = className.substring(0, 1).toLowerCase() + className.substring(1, className.length());

        String srcPath = projectPath + DataModel.getSourceRootPackage() + "\\";

        String pckPath = srcPath + DataModel.getBusinessPackage() + "\\";

        String entityPath = (entityPackage == null || "".equals(entityPackage)) ? "" : entityPackage + "\\";
        String cPath = (controllerEntityPackage == null || "".equals(controllerEntityPackage)) ? "" : controllerEntityPackage + "\\";

        String beanPath = "entity\\" + entityPath + className + "Entity.java";
        String daoPath = "dao\\" + entityPath + className + "Dao.java";
        String servicePath = "service\\" + entityPath + className + "Service.java";
        String serviceImplPath = "service\\" + entityPath + "impl\\" + className + "ServiceImpl.java";
        String controllerPath = "controller\\" + cPath + className + "Controller.java";

        VelocityContext context = new VelocityContext();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        context.put("projectName", projectName);
        context.put("funcDesc",funcDesc);
        context.put("datetime", sf.format(new Date()));
        context.put("author", author);
        context.put("className", className);
        context.put("lowerName", lowerName);
        context.put("codeName", codeName);
        context.put("tableName", tableName);
        context.put("bussPackage", buss_package);
        context.put("entityPackage", entityPackage == "" ? null : entityPackage);
        context.put("controllerEntityPackage", controllerEntityPackage == "" ? null : controllerEntityPackage);
        context.put("keyType", keyType);
        try {
            context.put("feilds", createBean.getBeanFeilds(tableName));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Map sqlMap = createBean.getAutoCreateSql(tableName);
            context.put("columnDatas", createBean.getColumnDatas(tableName));
            context.put("SQL", sqlMap);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        CommonPageParser.WriterPage(context, "EntityTemplate.ftl", pckPath, beanPath);
        CommonPageParser.WriterPage(context, "DaoTemplate.ftl", pckPath, daoPath);
        CommonPageParser.WriterPage(context, "ServiceTemplate.ftl", pckPath, servicePath);
        CommonPageParser.WriterPage(context, "ServiceImplTemplate.ftl", pckPath, serviceImplPath);
        CommonPageParser.WriterPage(context, "ControllerTemplate.ftl", pckPath, controllerPath);
        log.info("----------------------------\u4EE3\u7801\u751F\u6210\u5B8C\u6BD5---------------------------");
    }

    public static String getProjectPath() {
        String path = System.getProperty("user.dir").replace("\\", "/") + "/";
        return path;
    }
}