package ${bussPackage}.dto#if($!entityPackage).${entityPackage}#end#if($!category).${category}#end;

#if($!basePackage)import ${basePackage}.entity.BaseEntity;#end


/**
* Project Name: #if($!projectName)${projectName}#end

* Functional description：#if($!funcDesc)${funcDesc}#end

*
* @author #if($!author)${author}#end

* @version 1.0
* @date ${datetime}
* @since JDK ${version}
*/
public class ${className}Dto#if($!basePackage) extends BaseEntity#end {


}
