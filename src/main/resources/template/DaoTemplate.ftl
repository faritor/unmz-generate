package ${bussPackage}.dao#if($!entityPackage).${entityPackage}#end;

import ${basePackage}.utils.dao.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end.${className}Entity;

/**
* Project Name: ${projectName}  
* Functional description：${funcDesc} 
*
* @author ${author} 
* @version 1.0 
* @date ${datetime} 
* @since JDK ${version} 
*/
@Mapper
public interface ${className}Dao extends MyMapper<${className}Entity> {


}
