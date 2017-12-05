package ${bussPackage}.service#if($!entityPackage).${entityPackage}#end.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ${bussPackage}.service#if($!entityPackage).${entityPackage}#end.${className}Service;


/**
* Project Name: ${projectName}  <br/>
* Functional description：${funcDesc} <br/>
*
* @author ${author} <br/>
* @version 1.0 <br/>
* @date ${datetime} <br/>
* @since JDK ${version} <br/>
*/
@Service
public class ${className}ServiceImpl implements ${className}Service {

    private final static Logger log= Logger.getLogger(${className}ServiceImpl.class);


}
