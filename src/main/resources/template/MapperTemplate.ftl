package ${bussPackage}.mapping#if($!category).${category}#end;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end#if($!category).${category}#end.${className}Entity;
import org.springframework.stereotype.Component;

/**
 * Project Name: #if($!projectName)${projectName}#end

 * Functional description：#if($!funcDesc)${funcDesc}#end

 *
 * @author #if($!author)${author}#end

 * @version 1.0
 * @date ${datetime}
 * @since JDK ${version}
 */
@Component
public interface ${className}Mapper extends BaseMapper<${className}Entity> {


}
