package org.zj.shop.service;

import org.zj.shop.bean.AlertMenu;
import org.zj.shop.bean.Menu;

import java.util.List;
import java.util.Map;

public interface IMenuService {

    List<Menu> getTopMenuByParentID(int id);

    List<Menu> getTopMenuList();

    int getTopMenuCount();

    boolean addMenu(Menu menu);

    boolean deleteMenuByID(int id);

    boolean updateMenu(Menu menu);

    List<Menu> getChildMenu(int parentID);

    Map<Integer,List<Menu>> getTopMenu();

    List<Menu> getAlertMenuChildTop(int id);

    List<AlertMenu> getAlertMenuList();
}
