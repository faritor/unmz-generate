package ${bussPackage}.controller#if($!category).${category}#end;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;

/**
 * Project Name: #if($!projectName)${projectName}#end

 * Functional description：#if($!funcDesc)${funcDesc}#end

 *
 * @author #if($!author)${author}#end

 * @version 1.0
 * @date ${datetime}
 * @since JDK ${version}
 */
@Slf4j
@Validated
@RestController
@RequestMapping
public class ${className}Controller {



}
