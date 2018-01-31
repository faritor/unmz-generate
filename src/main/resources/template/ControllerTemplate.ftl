package ${bussPackage}.controller#if($!controllerEntityPackage).${controllerEntityPackage}#end;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* Project Name: ${projectName}  <br/>
* Functional description：${funcDesc} <br/>
*
* @author ${author} <br/>
* @version 1.0 <br/>
* @date ${datetime} <br/>
* @since JDK ${version} <br/>
*/
@RestController
@RequestMapping
public class ${className}Controller {

    private final static Logger log= Logger.getLogger(${className}Controller.class);


}
