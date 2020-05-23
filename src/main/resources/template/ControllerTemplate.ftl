package ${bussPackage}.controller#if($!controllerEntityPackage).${controllerEntityPackage}#end;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* Project Name: ${projectName}  
* Functional description：${funcDesc} 
*
* @author ${author} 
* @version 1.0 
* @date ${datetime} 
* @since JDK ${version} 
*/
@RestController
@RequestMapping
public class ${className}Controller {

    private final static Logger log= LoggerFactory.getLogger(${className}ServiceImpl.class);


}
