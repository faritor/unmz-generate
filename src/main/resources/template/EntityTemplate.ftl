package ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("${tableName}")
public class ${className}Entity implements Serializable {
${feilds}

}

