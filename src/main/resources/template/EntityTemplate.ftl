package ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end;

import ${basePackage}.entity.BaseEntity;
import javax.persistence.Table;

/**
* Project Name: ${projectName}  <br/>
* Functional description：${funcDesc} <br/>
*
* @author ${author} <br/>
* @version 1.0 <br/>
* @date ${datetime} <br/>
* @since JDK ${version} <br/>
*/
@Table(name = "${tableName}")
public class ${className}Entity extends BaseEntity {
${feilds}

}

