package ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end;

import ${basePackage}.entity.BaseEntity;
import javax.persistence.Table;
import java.io.Serializable;


/**
* Project Name: ${projectName}  
* Functional description：${funcDesc} 
*
* @author ${author} 
* @version 1.0 
* @date ${datetime} 
* @since JDK ${version} 
*/
@Table(name = "${tableName}")
public class ${className}Entity implements Serializable {
${feilds}

}

