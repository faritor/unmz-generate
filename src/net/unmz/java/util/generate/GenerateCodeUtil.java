package net.unmz.java.util.generate;

import net.unmz.java.util.generate.defined.FtlDef;
import net.unmz.java.util.generate.factory.CodeGenerateFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name: 代码生成工具类
 * 功能描述：输入表名和作者,生成对应的表所对应的所有基础结构
 *
 * @author faritor@unmz.net
 * @version 1.2
 * @date 2017-11-08 19:36
 * @since JDK 1.8
 */
public class GenerateCodeUtil {

    public static void generateCode(String tableName, String author) {
        String codeName = "";
        String entityPackage = "";
        generateCode(tableName, codeName, entityPackage, author);
    }

    public static void generateCode(String tableName, String codeName, String entityPackage, String author) {
        String keyType = FtlDef.KEY_TYPE_02;//主键生成方式 01:UUID  02:自增
        CodeGenerateFactory.codeGenerate(tableName, codeName, entityPackage, keyType, author);
    }

    public static void generateCodeList(List<String> tableList, String author) {
        String codeName = "";
        String entityPackage = "";
        generateCodeList(tableList, codeName, entityPackage, author);
    }

    public static void generateCodeList(List<String> tableList, String codeName, String entityPackage, String author) {
        String keyType = FtlDef.KEY_TYPE_02;//主键生成方式 01:UUID  02:自增
        CodeGenerateFactory.codeGenerateList(tableList, codeName, entityPackage, keyType, author);
    }

    @Test
    public void testGenerate() {
        String tableName = "account_point_detail"; //表名
        generateCode(tableName, "faritor");
    }

    @Test
    public void testGenerateList() {
        List<String> tableList = new ArrayList<>();
        tableList.add("order_commission");
        tableList.add("order_complement");
        generateCodeList(tableList,"faritor@unmz.net");
    }
}
