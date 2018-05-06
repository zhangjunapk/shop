package org.zj.shop.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface IDeleteDao {

    @Delete("delete from menu where id=#{id}")
    boolean deleteMenuByID(@Param("id")int id);
}
