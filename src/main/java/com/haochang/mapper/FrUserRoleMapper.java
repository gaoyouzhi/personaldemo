package com.haochang.mapper;

import java.util.List;

import com.haochang.model.FrUserRole;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface FrUserRoleMapper {
    @Delete({
        "delete from fr_user_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into fr_user_role (id, user_id, ",
        "role_id)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{roleId,jdbcType=INTEGER})"
    })
    int insert(FrUserRole record);

    @Select({
        "select",
        "id, user_id, role_id",
        "from fr_user_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER)
    })
    FrUserRole selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, user_id, role_id",
        "from fr_user_role"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER)
    })
    List<FrUserRole> selectAll();

    @Update({
        "update fr_user_role",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "role_id = #{roleId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FrUserRole record);
}