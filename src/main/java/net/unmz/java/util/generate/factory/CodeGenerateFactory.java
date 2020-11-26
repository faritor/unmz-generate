package net.unmz.java.util.generate.factory;

import net.unmz.java.util.generate.CommonPageParser;
import net.unmz.java.util.generate.CreateBean;
import net.unmz.java.util.generate.defined.DataModel;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.VelocityContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CodeGenerateFactory {
    private static final Log log = LogFactory.getLog(CodeGenerateFactory.class);
    private static final String url = DataModel.getUrl();
    private static final String username = DataModel.getUsername();
    private static final String passWord = DataModel.getPassword();
    private static final String projectName = DataModel.getProjectName();
    private static final String funcDesc = DataModel.getFuncDesc();
    private static final String basePackage = DataModel.getBasePackage();
    private static final String category = DataModel.getCategory();

    private static final String buss_package = DataModel.getBusinessPackage();
    private static final String projectPath = getProjectPath();

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
        String lowerName = className.substring(0, 1).toLowerCase() + className.substring(1);

        String srcPath = projectPath + DataModel.getSourceRootPackage() + "\\";

        String pckPath = srcPath + DataModel.getBusinessPackage() + "\\";

        String entityPath = (entityPackage == null || "".equals(entityPackage)) ? "" : entityPackage + "\\";
        String cPath = (controllerEntityPackage == null || "".equals(controllerEntityPackage)) ? "" : controllerEntityPackage + "\\";

        String beanPath = "entity\\" + cPath + className + "Entity.java";
        String mapperPath = "mapper\\" + cPath + className + "Mapper.java";
        String xmlPath = "mapper\\" + cPath + className + "Mapper.xml";
        String servicePath = "service\\" + cPath + className + "Service.java";
        String serviceImplPath = "service\\" + cPath + "impl\\" + className + "ServiceImpl.java";
        String controllerPath = "controller\\" + cPath + className + "Controller.java";
        String sqlPath = "sql\\" + cPath + className + "Build.java";
        String dtoPath = "dto\\" + cPath + className + "DTO.java";

        VelocityContext context = new VelocityContext();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        context.put("projectName", projectName);
        context.put("basePackage", basePackage);
        context.put("category", category);
        context.put("funcDesc", funcDesc);
        context.put("datetime", sf.format(new Date()));
        context.put("author", author);
        context.put("className", className);
        context.put("lowerName", lowerName);
        context.put("codeName", codeName);
        context.put("tableName", tableName);
        context.put("bussPackage", buss_package);
        context.put("entityPackage", StringUtils.isBlank(entityPackage) ? null : entityPackage);
        context.put("controllerEntityPackage", StringUtils.isBlank(controllerEntityPackage) ? null : controllerEntityPackage);
        context.put("keyType", keyType);
        context.put("version", System.getProperty("java.version"));
        context.put("randomLong", System.currentTimeMillis() + new Random(10).nextLong());
        try {
            context.put("feilds", createBean.getBeanFields(tableName));
            context.put("xmlFields", createBean.getFieldByXml(tableName));
        } catch (Exception e) {
            e.printStackTrace();
        }

        CommonPageParser.WriterPage(context, "EntityTemplate.ftl", pckPath, beanPath);
        CommonPageParser.WriterPage(context, "MapperTemplate.ftl", pckPath, mapperPath);
        CommonPageParser.WriterPage(context, "XmlTemplate.ftl", pckPath, xmlPath);
        CommonPageParser.WriterPage(context, "ServiceTemplate.ftl", pckPath, servicePath);
        CommonPageParser.WriterPage(context, "ServiceImplTemplate.ftl", pckPath, serviceImplPath);
        CommonPageParser.WriterPage(context, "ControllerTemplate.ftl", pckPath, controllerPath);
        CommonPageParser.WriterPage(context, "BuildTemplate.ftl", pckPath, sqlPath);
        CommonPageParser.WriterPage(context, "DtoTemplate.ftl", pckPath, dtoPath);
        log.info("----------------------------\u4EE3\u7801\u751F\u6210\u5B8C\u6BD5---------------------------");
    }

    public static String getProjectPath() {
        return System.getProperty("user.dir").replace("\\", "/") + "/";
    }
}