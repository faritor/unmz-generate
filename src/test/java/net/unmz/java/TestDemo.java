package net.unmz.java;

import net.unmz.java.util.generate.GenerateCodeUtil;
import net.unmz.java.util.generate.defined.DataModel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name:
 * 功能描述：
 *
 * @author faritor@unmz.net
 * @version 1.0
 * @date 2018/2/5 17:37
 * @since JDK 1.8
 */
public class TestDemo {


    static {
        DataModel.setBasePackage("net.unmz.java.base");
        DataModel.setBusinessPackage("net.unmz.java.statistics.service");
        DataModel.setUrl("jdbc:mysql://192.168.1.14:3306/gchbpm?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true");
        DataModel.setUsername("gch");
        DataModel.setPassword("asd12345");
        DataModel.setDatabaseName("gchbpm");
        DataModel.setProjectName("  ");
        DataModel.setFuncDesc("  ");
    }

    @Test
    public void testGenerate() {
        String tableName = "t_s_category"; //表名
        GenerateCodeUtil.generateCode(tableName, "faritor@unmz.net");
    }

    @Test
    public void testGenerateList() {
        List<String> tableList = new ArrayList<>();
        tableList.add("statistics_city");
        tableList.add("statistics_city");
        GenerateCodeUtil.generateCodeList(tableList,"faritor@unmz.net");
    }
}
