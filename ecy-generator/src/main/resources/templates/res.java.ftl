package ${package.Controller}.vo.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
<#list table.importPackages as pkg>
import ${pkg};
</#list>

import java.time.LocalDateTime;

/**
 * ${moduleName}
 *
 * @author ${author}
 * @since ${createTime}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ${entity}Res {

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    /**
     * ${field.comment}
     */
    private ${field.propertyType} ${field.propertyName};
</#list>
<#------------  END 字段循环遍历  ---------->
}