package org.zj.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zj.shop.bean.AlertMenu;
import org.zj.shop.bean.Menu;
import org.zj.shop.dao.IDeleteDao;
import org.zj.shop.dao.IInsertDao;
import org.zj.shop.dao.IQueryDao;
import org.zj.shop.dao.IUpdateDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    IDeleteDao deleteDao;

    @Autowired
    IInsertDao insertDao;

    @Autowired
    IUpdateDao updateDao;

    @Autowired
    IQueryDao queryDao;

    @Override
    public List<Menu> getTopMenuByParentID(int id) {
        return queryDao.selectAlertMenuTop(id);
    }

    @Override
    public List<Menu> getTopMenuList() {
        return queryDao.selectTopCategory();
    }

    @Override
    public int getTopMenuCount() {
        return queryDao.getTopMenuCount();
    }

    @Override
    public boolean addMenu(Menu menu) {
        return insertDao.insertMenu(menu);
    }

    @Override
    public boolean deleteMenuByID(int id) {
        return deleteDao.deleteMenuByID(id);
    }

    @Override
    public boolean updateMenu(Menu menu) {
        return updateDao.updateMenuByPrimaryKey(menu);
    }

    @Override
    public List<Menu> getChildMenu(int parentID) {
        return queryDao.selectCategoryByParentID(parentID);
    }

    @Override
    public Map<Integer,List<Menu>> getTopMenu() {
        Map<Integer,List<Menu>> result=new HashMap<>(18);
        List<Menu> categories = queryDao.selectTopCategory();
        for(Menu menu :categories){
            List<Menu> cs=getChildMenu(menu.getId());
            result.put(menu.getId(),cs);
        }
        return result;
    }

    @Override
    public List<Menu> getAlertMenuChildTop(int id) {
        return queryDao.selectAlertMenuTop(id);
    }

    @Override
    public List<AlertMenu> getAlertMenuList() {
        List<AlertMenu> result=new ArrayList<>();
        for(Menu menu :getTopMenuList()){
            AlertMenu alertMenu=new AlertMenu();
            alertMenu.setId(menu.getId());
            alertMenu.setIdWord((char)('a'+ menu.getId()-1)+"");
            alertMenu.setTopMenu(getTopMenuByParentID(menu.getId()));

            List<Map.Entry<Menu,List<Menu>>> childCategory=new ArrayList<>();
            for(Menu c:getChildMenu(menu.getId())){
                childCategory.add(new Map.Entry<Menu, List<Menu>>() {
                    @Override
                    public Menu getKey() {
                        return c;
                    }

                    @Override
                    public List<Menu> getValue() {
                        return getChildMenu(c.getId());
                    }

                    @Override
                    public List<Menu> setValue(List<Menu> value) {
                        return getChildMenu(c.getId());
                    }
                });
            }
            alertMenu.setBottomMenu(childCategory);
            result.add(alertMenu);
        }

        return result;
    }


}
