package ${bussPackage}.dto#if($!category).${category}#end;

#if($!basePackage)import ${basePackage}.BaseDTO;#end

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description：#if($!funcDesc)${funcDesc}#end

 *
 * @author #if($!author)${author}#end

 * @version 1.0
 * @date ${datetime}
 * @since JDK ${version}
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ${className}DTO#if($!basePackage) extends BaseDTO#end {

    private static final long serialVersionUID = ${randomLong}L;

}
