package org.zj.shop.bean;

import java.util.List;
import java.util.Map;

public class AlertMenu {
    int id;
    String idWord;
    //上面的菜单
    List<Menu> topMenu;
    //下面的菜单
    List<Map.Entry<Menu,List<Menu>>> bottomMenu;

    @Override
    public String toString() {
        return "AlertMenu{" +
                "id=" + id +
                ", idWord='" + idWord + '\'' +
                ", topMenu=" + topMenu +
                ", bottomMenu=" + bottomMenu +
                '}';
    }

    public AlertMenu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdWord() {
        return idWord;
    }

    public void setIdWord(String idWord) {
        this.idWord = idWord;
    }

    public List<Menu> getTopMenu() {
        return topMenu;
    }

    public void setTopMenu(List<Menu> topMenu) {
        this.topMenu = topMenu;
    }

    public List<Map.Entry<Menu, List<Menu>>> getBottomMenu() {
        return bottomMenu;
    }

    public void setBottomMenu(List<Map.Entry<Menu, List<Menu>>> bottomMenu) {
        this.bottomMenu = bottomMenu;
    }

    public AlertMenu(int id, String idWord, List<Menu> topMenu, List<Map.Entry<Menu, List<Menu>>> bottomMenu) {
        this.id = id;
        this.idWord = idWord;
        this.topMenu = topMenu;
        this.bottomMenu = bottomMenu;
    }
}
