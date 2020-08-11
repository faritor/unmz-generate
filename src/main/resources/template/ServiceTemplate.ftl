package ${bussPackage}.service#if($!entityPackage).${entityPackage}#end#if($!category).${category}#end;

import com.baomidou.mybatisplus.extension.service.IService;
import ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end#if($!category).${category}#end.${className}Entity;

/**
 * Project Name: ${projectName}
 * Functional description：${funcDesc}
 *
 * @author ${author}
 * @version 1.0
 * @date ${datetime}
 * @since JDK ${version}
 */
public interface ${className}Service extends IService<${className}Entity>{

}
