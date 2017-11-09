package ${bussPackage}.dao#if($!entityPackage).${entityPackage}#end;

import com.kp.base.utils.dao.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end.${className}Entity;

/**
* Project Name:
* Functional description：
*
* @author ${author}
* @version 1.0
* @date ${datetime}
* @since JDK 1.8
*/
@Mapper
public interface ${className}Dao extends MyMapper<${className}Entity> {


}
