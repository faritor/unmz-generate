package ${bussPackage}.dao#if($!entityPackage).${entityPackage}#end;

import com.kp.base.utils.dao.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end.${className}Entity;

/**
* Project Name: ${projectName}  <br/>
* Functional description：${funcDesc} <br/>
*
* @author ${author} <br/>
* @version 1.0 <br/>
* @date ${datetime} <br/>
* @since JDK ${version} <br/>
*/
@Mapper
public interface ${className}Dao extends MyMapper<${className}Entity> {


}
