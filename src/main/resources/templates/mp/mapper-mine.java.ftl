package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};
import org.springframework.stereotype.Repository;


/**
 * Copyright (C), 2015-${.now?string("yyyy")}, https://www.liuwenxu.com/
 * FileName: ${table.mapperName}
 * Author: ${author}
 * Date: ${.now}
 * Description: ${table.comment!} Mapper 接口
 */
@Repository
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

}
</#if>
