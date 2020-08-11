package ${bussPackage}.service#if($!entityPackage).${entityPackage}#end#if($!category).${category}#end.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${bussPackage}.service#if($!entityPackage).${entityPackage}#end#if($!category).${category}#end.${className}Service;
import ${bussPackage}.entity#if($!entityPackage).${entityPackage}#end#if($!category).${category}#end.${className}Entity;
import ${bussPackage}.mapper#if($!entityPackage).${entityPackage}#end#if($!category).${category}#end.${className}Mapper;


/**
 * Project Name: ${projectName}
 * Functional description：${funcDesc}
 *
 * @author ${author}
 * @version 1.0
 * @date ${datetime}
 * @since JDK ${version}
 */
@Slf4j
@Service
public class ${className}ServiceImpl extends ServiceImpl<${className}Mapper, ${className}Entity> implements ${className}Service {


}
