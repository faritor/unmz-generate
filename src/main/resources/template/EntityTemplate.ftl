package ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end#if($!category).${category}#end;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * Project Name: ${projectName}
 * Functional description：${funcDesc}
 *
 * @author ${author}
 * @version 1.0
 * @date ${datetime}
 * @since JDK ${version}
 */
@Data
@TableName("${tableName}")
public class ${className}Entity implements Serializable {

    private static final long serialVersionUID = ${randomLong}L;
${feilds}

}

