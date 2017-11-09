package ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end;

import com.kp.base.entity.BaseEntity;
import javax.persistence.Table;

/**
* Project Name:
* Functional description：
*
* @author ${author}
* @version 1.0
* @date ${datetime}
* @since JDK 1.8
*/
@Table(name = "${tableName}")
public class ${className}Entity extends BaseEntity {
${feilds}

}

