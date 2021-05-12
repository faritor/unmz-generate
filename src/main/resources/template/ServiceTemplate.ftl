package ${bussPackage}.service#if($!category).${category}#end;

import com.baomidou.mybatisplus.extension.service.IService;
import ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end#if($!category).${category}#end.${className}Entity;

/**
 * Functional description：#if($!funcDesc)${funcDesc}#end

 *
 * @author #if($!author)${author}#end

 * @version 1.0
 * @date ${datetime}
 * @since JDK ${version}
 */
public interface ${className}Service extends IService<${className}Entity> {

}
