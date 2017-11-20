package ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end;

import com.kp.base.entity.BaseEntity;
import javax.persistence.Table;

/**
* Project Name: ${projectName}  <br/>
* Functional description：${funcDesc} <br/>
*
* @author ${author} <br/>
* @version 1.0 <br/>
* @date ${datetime} <br/>
* @since JDK 1.8 <br/>
*/
@Table(name = "${tableName}")
public class ${className}Entity extends BaseEntity {
${feilds}

}

