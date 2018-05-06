package org.zj.shop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zj.shop.bean.Menu;
import org.zj.shop.service.IMenuService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopApplicationTests {

    @Autowired
    IMenuService categoryService;

    @Test
    public void insertCategory(){
        Menu menu =new Menu();
        menu.setName("board");
        categoryService.addMenu(menu);

        Menu menu1 =new Menu();
        menu.setName("single board");
        menu.setParentID(1);
        categoryService.addMenu(menu1);

        Menu menu2 =new Menu();
        menu.setName("latte panda");
        menu.setParentID(2);
        categoryService.addMenu(menu2);

        Menu menu3 =new Menu();
        menu.setName("up board");
        menu.setParentID(2);
        categoryService.addMenu(menu3);

        Menu menu4 =new Menu();
        menu.setName("computer board");
        menu.setParentID(1);
        categoryService.addMenu(menu4);

        Menu menu5 =new Menu();
        menu.setName("asus board");
        menu.setParentID(5);
        categoryService.addMenu(menu5);

        Menu menu6 =new Menu();
        menu.setName("msi board");
        menu.setParentID(5);
        categoryService.addMenu(menu6);


        Menu menu7 =new Menu();
        menu.setName("module");
        categoryService.addMenu(menu7);

        Menu menu8 =new Menu();
        menu.setName("gravity module");
        menu.setParentID(8);
        categoryService.addMenu(menu8);

        Menu menu9 =new Menu();
        menu.setName("dimension module");
        menu.setParentID(8);
        categoryService.addMenu(menu9);


    }

}
