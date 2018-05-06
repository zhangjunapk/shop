package org.zj.shop.dao;

import org.apache.ibatis.annotations.Update;
import org.zj.shop.bean.Menu;

public interface IUpdateDao {

    @Update("update menu set name=#{name},link=#{link},parentID=#{parentID} where id =#{id}")
    boolean updateMenuByPrimaryKey(Menu menu);
}
