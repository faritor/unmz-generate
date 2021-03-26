package ${bussPackage}.entity#if($!category).${category}#end;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.comm.entity.BaseEntity;

/**

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
public class ${className}Entity extends BaseEntity  {

    private static final long serialVersionUID = ${randomLong}L;
${feilds}

}

