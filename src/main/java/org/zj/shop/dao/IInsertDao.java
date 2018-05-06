package org.zj.shop.dao;

import org.apache.ibatis.annotations.Insert;
import org.zj.shop.bean.Menu;

public interface IInsertDao {

    @Insert("insert into menu(name,parentID,link) values(#{name},#{parentID},#{link})")
    boolean insertMenu(Menu menu);

}
