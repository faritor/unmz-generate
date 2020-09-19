package ${bussPackage}.mapping#if($!entityPackage).${entityPackage}#end#if($!category).${category}#end;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end#if($!category).${category}#end.${className}Entity;
import org.springframework.stereotype.Component;

/**
 * Project Name: ${projectName}
 * Functional description：${funcDesc}
 *
 * @author ${author}
 * @version 1.0
 * @date ${datetime}
 * @since JDK ${version}
 */
@Component
public interface ${className}Mapper extends BaseMapper<${className}Entity> {


}
