package org.zj.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zj.shop.bean.AlertMenu;
import org.zj.shop.bean.Key;
import org.zj.shop.bean.Menu;
import org.zj.shop.service.IKeyService;
import org.zj.shop.service.IMenuService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    IMenuService categoryService;

    @Autowired
    IKeyService keyService;

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/index")
    public String index(){
        Map<Integer, List<Menu>> topCategory = categoryService.getTopMenu();
        for(Map.Entry<Integer,List<Menu>> entry:topCategory.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue().size());
        }
        request.setAttribute("top_category_map",topCategory);
        List<AlertMenu> alertMenuList = categoryService.getAlertMenuList();
        System.out.println(alertMenuList.size()+";;;;;");
        for(AlertMenu alertMenu:alertMenuList){
            System.out.println(alertMenu.getId()+" : "+alertMenu.getIdWord());

            for(Menu menu :alertMenu.getTopMenu()){
                System.out.println(menu.toString());
            }

            for(Map.Entry<Menu,List<Menu>> entry:alertMenu.getBottomMenu()){
                System.out.println(entry.getKey().getName());
                for(Menu menu :entry.getValue()){
                    System.out.println(menu.getName());
                }
            }

        }

        for(Key key:keyService.selectAllKey(1)){
            System.out.println(key.getCatId()+" +++++++++++");
        }


        request.setAttribute("alert_menu_list",alertMenuList);
        return "index";
    }
}
