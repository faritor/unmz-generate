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
 * @author Faritor
 * @version 1.0
 * @date 2018/2/5 17:37
 * @since JDK 1.8
 */
public class TestDemo {


    static {
        DataModel.setBasePackage("net.unmz.java.base");
        DataModel.setBusinessPackage("net.unmz.java.demo");
        DataModel.setCategory(" 子分类 ");
        DataModel.setUrl("jdbc:mysql://127.0.0.1:3306/unmz?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true");
        DataModel.setUsername("root");
        DataModel.setPassword("root");
        DataModel.setDatabaseName("unmz");
        DataModel.setProjectName(" 项目名称 ");
        DataModel.setFuncDesc(" 功能描述 ");
        DataModel.setIgnoreHead(true);//忽略"t_"部分
    }

    @Test
    public void testGenerate() {
        String tableName = "category"; //表名
        GenerateCodeUtil.generateCode(tableName, "Faritor");
    }

    @Test
    public void testGenerateList() {
        List<String> tableList = new ArrayList<>();
        tableList.add("statistics_city");
        tableList.add("statistics_city");
        GenerateCodeUtil.generateCodeList(tableList,"Faritor");
    }
}
