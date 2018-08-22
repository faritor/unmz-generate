package ${bussPackage}.service#if($!entityPackage).${entityPackage}#end.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ${bussPackage}.service#if($!entityPackage).${entityPackage}#end.${className}Service;


/**
* Project Name: ${projectName}  
* Functional description：${funcDesc} 
*
* @author ${author} 
* @version 1.0 
* @date ${datetime} 
* @since JDK ${version} 
*/
@Service
public class ${className}ServiceImpl implements ${className}Service {

    private final static Logger log= LoggerFactory.getLogger(${className}ServiceImpl.class);

}
