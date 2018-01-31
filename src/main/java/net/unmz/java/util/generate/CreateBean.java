package net.unmz.java.util.generate;

import net.unmz.java.util.generate.defined.CommUtil;
import net.unmz.java.util.generate.defined.DataModel;
import net.unmz.java.util.generate.defined.TableConvert;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class CreateBean {
    static String url;
    static String username;
    static String password;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String SQLTables = "show tables";
    private Connection connection = null;
    private String method;
    private String argv;

    public void setMysqlInfo(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<String> getTables() throws SQLException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(SQLTables);
        ResultSet rs = ps.executeQuery();
        List list = new ArrayList();
        while (rs.next()) {
            String tableName = rs.getString(1);
            list.add(tableName);
        }
        rs.close();
        ps.close();
        con.close();
        return list;
    }

    public List<ColumnData> getColumnDatas(String tableName) throws SQLException {
//        String SQLColumns = "select column_name ,data_type,column_comment,0,0,character_maximum_length,is_nullable nullable from information_schema.columns where table_name =  '"
//                + tableName + "' " + "and table_schema =  '" + CodeResourceUtil.DATABASE_NAME + "'";
        String SQLColumns = "select column_name ,data_type,column_comment,0,0,character_maximum_length,is_nullable nullable from information_schema.columns where table_name =  '"
                + tableName + "' " + "and table_schema =  '" + DataModel.getDatabaseName() + "'";

        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(SQLColumns);
        List columnList = new ArrayList();
        ResultSet rs = ps.executeQuery();
        StringBuffer str = new StringBuffer();
        StringBuffer getset = new StringBuffer();
        while (rs.next()) {
            String name = rs.getString(1);
            String type = rs.getString(2);
            String comment = rs.getString(3);
            String precision = rs.getString(4);
            String scale = rs.getString(5);
            String charmaxLength = rs.getString(6) == null ? "" : rs.getString(6);
            String nullable = TableConvert.getNullAble(rs.getString(7));
            type = getType(type, precision, scale);

            ColumnData cd = new ColumnData();
            cd.setColumnName(name);
            cd.setDataType(type);
            cd.setColumnType(rs.getString(2));
            cd.setColumnComment(comment);
            cd.setPrecision(precision);
            cd.setScale(scale);
            cd.setCharMaxLength(charmaxLength);
            cd.setNullable(nullable);
            formatFieldClassType(cd);
            columnList.add(cd);
        }
        argv = str.toString();
        method = getset.toString();
        rs.close();
        ps.close();
        con.close();
        return columnList;
    }

    public String getBeanFeilds(String tableName) throws SQLException {
        List<ColumnData> dataList = getColumnDatas(tableName);
        StringBuffer str = new StringBuffer();
        StringBuffer getset = new StringBuffer();
        for (ColumnData d : dataList) {
            String name = CommUtil.formatName(d.getColumnName());
            String type = d.getDataType();
            String comment = d.getColumnComment();
            if(!"createTime".equals(name) && !"updateTime".equals(name) && !"createdBy".equals(name) && !"updatedBy".equals(name)&& !"id".equals(name)){
                String maxChar = name.substring(0, 1).toUpperCase();
                str.append("\r\t").append("/**\n\t * " + comment + "\n\t */").append("\n\tprivate ").append(type + " ").append(name).append(";");
                String method = maxChar + name.substring(1, name.length());
                getset.append("\n\t\r\t").append("public ").append(type + " ").append("get" + method + "() {\r\t");
                getset.append("    return this.").append(name).append(";\r\t}");
                getset.append("\n\t\r\t").append("public void ").append("set" + method + "(" + type + " " + name + ") {\r\t");
                getset.append("    this." + name + "=").append(name).append(";\r\t}");
            }
        }
        argv = str.append("\n\t\n\t").toString();
        this.method = getset.toString();
        return argv + this.method;
    }

    /**
     * 读取表名创建文件
     *
     * @param name
     * @return
     */
    private String formatTableName(String name) {
        String[] split = name.split("_");
        if (split.length > 1) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < split.length; i++) {//是否截取表名中的第一段单词
                String tempName = split[i].substring(0, 1).toUpperCase() + split[i].substring(1, split[i].length());
                sb.append(tempName);
            }

            return sb.toString();
        }
        String tempName = split[0].substring(0, 1).toUpperCase() + split[0].substring(1, split[0].length());
        return tempName;
    }

    private void formatFieldClassType(ColumnData columnt) {
        String fieldType = columnt.getColumnType();
        String scale = columnt.getScale();

        if ("N".equals(columnt.getNullable())) {
            columnt.setOptionType("required:true");
        }
        if (("datetime".equals(fieldType)) || ("time".equals(fieldType))) {
            columnt.setClassType("easyui-datetimebox");
        } else if ("date".equals(fieldType)) {
            columnt.setClassType("easyui-datebox");
        } else if ("int".equals(fieldType)) {
            columnt.setClassType("easyui-numberbox");
        } else if ("number".equals(fieldType)) {
            if ((StringUtils.isNotBlank(scale)) && (Integer.parseInt(scale) > 0)) {
                columnt.setClassType("easyui-numberbox");
                if (StringUtils.isNotBlank(columnt.getOptionType()))
                    columnt.setOptionType(columnt.getOptionType() + "," + "precision:2,groupSeparator:','");
                else
                    columnt.setOptionType("precision:2,groupSeparator:','");
            } else {
                columnt.setClassType("easyui-numberbox");
            }
        } else if (("float".equals(fieldType)) || ("double".equals(fieldType)) || ("decimal".equals(fieldType))) {
            columnt.setClassType("easyui-numberbox");
            if (StringUtils.isNotBlank(columnt.getOptionType()))
                columnt.setOptionType(columnt.getOptionType() + "," + "precision:2,groupSeparator:','");
            else
                columnt.setOptionType("precision:2,groupSeparator:','");
        } else {
            columnt.setClassType("easyui-validatebox");
        }
    }

    public String getType(String dataType, String precision, String scale) {
        dataType = dataType.toLowerCase();
        if (dataType.contains("char") || dataType.contains("text"))
            dataType = "String";
        else if (dataType.contains("bit"))
            dataType = "Boolean";
        else if (dataType.contains("bigint"))
            dataType = "Long";
        else if (dataType.contains("int"))
            dataType = "Integer";
        else if (dataType.contains("float"))
            dataType = "Float";
        else if (dataType.contains("double"))
            dataType = "Double";
        else if (dataType.contains("number")) {
            if ((StringUtils.isNotBlank(scale)) && (Integer.parseInt(scale) > 0)){
                dataType = "BigDecimal";
            }
            else if ((StringUtils.isNotBlank(precision)) && (Integer.parseInt(precision) > 6))
                dataType = "Long";
            else
                dataType = "Integer";
        } else if (dataType.contains("decimal"))
            dataType = "BigDecimal";
        else if (dataType.contains("date"))
            dataType = "Date";
        else if (dataType.contains("time"))
            dataType = "Timestamp";
        else if (dataType.contains("clob"))
            dataType = "Clob";
        else {
            dataType = "Object";
        }
        return dataType;
    }

    public void getPackage(int type, String createPath, String content, String packageName, String className, String extendsClassName, String[] importName) throws Exception {
        if (packageName == null) {
            packageName = "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("package ").append(packageName).append(";\r");
        sb.append("\r");
        for (int i = 0; i < importName.length; i++) {
            sb.append("import ").append(importName[i]).append(";\r");
        }
        sb.append("\r");
        sb.append("/**\r *  model. @author wolf Date:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\r */");
        sb.append("\r");
        sb.append("\rpublic class ").append(className);
        if (extendsClassName != null) {
            sb.append(" extends ").append(extendsClassName);
        }
        if (type == 1)
            sb.append(" ").append("implements java.io.Serializable {\r");
        else {
            sb.append(" {\r");
        }
        sb.append("\r\t");
        sb.append("private static final long serialVersionUID = 1L;\r\t");
        String temp = className.substring(0, 1).toLowerCase();
        temp = temp + className.substring(1, className.length());
        if (type == 1) {
            sb.append("private " + className + " " + temp + "; // model ");
        }
        sb.append(content);
        sb.append("\r}");
        System.out.println(sb.toString());
        createFile(createPath, "", sb.toString());
    }

    public String getTablesNameToClassName(String tableName) {
        String tempTables = formatTableName(tableName);
        return tempTables;
    }

    public void createFile(String path, String fileName, String str) throws IOException {
        FileWriter writer = new FileWriter(new File(path + fileName));
        writer.write(new String(str.getBytes("utf-8")));
        writer.flush();
        writer.close();
    }

    public Map<String, Object> getAutoCreateSql(String tableName) throws Exception {
        Map sqlMap = new HashMap();
        List columnDatas = getColumnDatas(tableName);
        String columns = getColumnSplit(columnDatas);
        String formatColumns = getFormatColumnSplit(columnDatas);
        String[] columnList = getColumnList(columns);
        String columnFields = getColumnFields(columns);
        String insert = "insert into " + tableName + "(" + columns.replaceAll("\\|", ",") + ")\n values(#{" + formatColumns.replaceAll("\\|", "},#{") + "})";
        String update = getUpdateSql(tableName, columnList);
        String updateSelective = getUpdateSelectiveSql(tableName, columnDatas);
        String selectById = getSelectByIdSql(tableName, columnList);
        String delete = getDeleteSql(tableName, columnList);
        sqlMap.put("columnList", columnList);
        sqlMap.put("columnFields", columnFields);
        sqlMap.put("insert", insert.replace("#{createTime}", "now()").replace("#{updateTime}", "now()"));
        sqlMap.put("update", update.replace("#{createTime}", "now()").replace("#{updateTime}", "now()"));
        sqlMap.put("delete", delete);
        sqlMap.put("updateSelective", updateSelective);
        sqlMap.put("selectById", selectById);
        return sqlMap;
    }

    public String getDeleteSql(String tableName, String[] columnsList) throws SQLException {
        StringBuffer sb = new StringBuffer();
        sb.append("delete ");
        sb.append("\t from ").append(tableName).append(" where ");
        sb.append(columnsList[0]).append(" = #{").append(CommUtil.formatName(columnsList[0])).append("}");
        return sb.toString();
    }

    public String getSelectByIdSql(String tableName, String[] columnsList) throws SQLException {
        StringBuffer sb = new StringBuffer();
        sb.append("select <include refid=\"Base_Column_List\" /> \n");
        sb.append("\t from ").append(tableName).append(" where ");
        sb.append(columnsList[0]).append(" = #{").append(CommUtil.formatName(columnsList[0])).append("}");
        return sb.toString();
    }

    public String getColumnFields(String columns) throws SQLException {
        String fields = columns;
        if ((fields != null) && (!"".equals(fields))) {
            fields = fields.replaceAll("[|]", ",");
        }
        return fields;
    }

    public String[] getColumnList(String columns) throws SQLException {
        String[] columnList = columns.split("[|]");
        return columnList;
    }

    public String getUpdateSql(String tableName, String[] columnsList) throws SQLException {
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i < columnsList.length; i++) {
            String column = columnsList[i];
            if (!"CREATETIME".equals(column.toUpperCase())) {
                if ("UPDATETIME".equals(column.toUpperCase()))
                    sb.append(column + "=now()");
                else {
                    sb.append(column + "=#{" + CommUtil.formatName(column) + "}");
                }
                if (i + 1 < columnsList.length)
                    sb.append(",");
            }
        }
        String update = "update " + tableName + " set " + sb.toString() + " where " + columnsList[0] + "=#{" + CommUtil.formatName(columnsList[0]) + "}";
        return update;
    }

    public String getUpdateSelectiveSql(String tableName, List<ColumnData> columnList) throws SQLException {
        StringBuffer sb = new StringBuffer();
        ColumnData cd = (ColumnData) columnList.get(0);
        sb.append("\t<trim  suffixOverrides=\",\" >\n");
        for (int i = 1; i < columnList.size(); i++) {
            ColumnData data = (ColumnData) columnList.get(i);
            String columnName = data.getColumnName();
            sb.append("\t<if test=\"").append(CommUtil.formatName(columnName)).append(" != null ");

            if ("String" == data.getDataType()) {
                sb.append(" and ").append(CommUtil.formatName(columnName)).append(" != ''");
            }
            sb.append(" \">\n\t\t");
            sb.append(columnName + "=#{" + CommUtil.formatName(columnName) + "},\n");
            sb.append("\t</if>\n");
        }
        sb.append("\t</trim>");
        String update = "update " + tableName + " set \n" + sb.toString() + " where " + cd.getColumnName() + "=#{" + CommUtil.formatName(cd.getColumnName()) + "}";
        return update;
    }

    public String getColumnSplit(List<ColumnData> columnList) throws SQLException {
        StringBuffer commonColumns = new StringBuffer();
        for (ColumnData data : columnList) {
            commonColumns.append(data.getColumnName() + "|");
        }
        return commonColumns.delete(commonColumns.length() - 1, commonColumns.length()).toString();
    }

    public String getFormatColumnSplit(List<ColumnData> columnList) throws SQLException {
        StringBuffer commonColumns = new StringBuffer();
        for (ColumnData data : columnList) {
            commonColumns.append(data.getFormatColumnName() + "|");
        }
        return commonColumns.delete(commonColumns.length() - 1, commonColumns.length()).toString();
    }
}