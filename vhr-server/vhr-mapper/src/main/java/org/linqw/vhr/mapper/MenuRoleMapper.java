package org.linqw.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.linqw.vhr.model.MenuRole;

public interface MenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);

    void deleteByRid(Integer rid);

    //当传入mybatis的参数有多个的时候需要加入@Param注解；
    Integer insertRecords(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}