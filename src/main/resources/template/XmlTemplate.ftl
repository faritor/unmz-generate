<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${bussPackage}.mapper#if($!category).${category}#end.${className}Mapper">

    <resultMap id="BaseResultMap" type="${bussPackage}.entity#if($!category).${category}#end.${className}Entity">
        ${xmlFields}
    </resultMap>

</mapper>
