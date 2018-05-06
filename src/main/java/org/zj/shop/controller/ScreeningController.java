package org.zj.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zj.shop.bean.Key;
import org.zj.shop.bean.Product;
import org.zj.shop.bean.ProductParam;
import org.zj.shop.service.IKeyService;
import org.zj.shop.service.IProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class ScreeningController {

    @Autowired
    IKeyService keyService;

    @Autowired
    IProductService productService;

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/screening/{catId}")
    public String screeningPage(@PathVariable("catId")int catId){



        System.out.println("----------");
        for(Map.Entry<Key,List<ProductParam>> entry:keyService.getKeyValuesList(catId)){
            System.out.println(entry.getKey().getParamName());
            for(ProductParam p:entry.getValue()){
                System.out.println("    "+p.get_value());
            }
        }
        System.out.println("--------------");
        request.setAttribute("key_entry_list",keyService.getKeyValuesList(catId));

        System.out.println(productService.getProductByWhereMap(catId,  request.getParameterMap()).size()+"     777777");

        request.setAttribute("product_list",productService.getProductByWhereMap(catId,  request.getParameterMap()));

        for(Product p:productService.getProductByWhereMap(catId,  request.getParameterMap())){
            System.out.println(p.toString());
        }

        return "screening";
    }
}
