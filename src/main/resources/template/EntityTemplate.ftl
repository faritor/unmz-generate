package ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end#if($!category).${category}#end;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Project Name: #if($!projectName)${projectName}#end

 * Functional description：#if($!funcDesc)${funcDesc}#end

 *
 * @author #if($!author)${author}#end

 * @version 1.0
 * @date ${datetime}
 * @since JDK ${version}
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("${tableName}")
public class ${className}Entity implements Serializable {

    private static final long serialVersionUID = ${randomLong}L;
${feilds}

}

