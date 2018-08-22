package ${bussPackage}.dao#if($!entityPackage).${entityPackage}#end;

import com.baomidou.mybatisplus.mapper.BaseMapper;
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
public interface ${className}Mapper extends BaseMapper<${className}Entity> {


}
