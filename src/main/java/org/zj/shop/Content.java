package org.zj.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.zj.shop.bean.Key;
import org.zj.shop.bean.KeyVo;
import org.zj.shop.bean.ProductParamVo;
import org.zj.shop.dao.IQueryDao;
import org.zj.shop.service.IKeyService;
import org.zj.shop.service.KeyServiceImpl;
import org.zj.shop.service.ProductServieImpl;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Content {

@Autowired
   static IQueryDao queryDao;


    public static void main(String[] args){
        KeyVo keyVo=new KeyVo();
        keyVo.setCatId(1);
        keyVo.setCatName("phone");
        Map<String,String[]> map=new HashMap<>();
        map.put("type",new String[]{"leixing"});
        map.put("ram",new String[]{"yunxingneicun"});
        keyVo.setKeyMap(map);
        new KeyServiceImpl().insertCategory(keyVo);

        new ProductServieImpl().getProductByWhereMap(1,map);


        System.out.println("------------");
        ProductParamVo productParamVo=new ProductParamVo();
        productParamVo.setCatId(1);
        productParamVo.setProductId(2);
        productParamVo.setFieldMap(map);
        new ProductServieImpl().insertProduct(productParamVo);



        for(Key key:queryDao.selectKeyByCatID(1)){
            System.out.println(">..."+key.getCatId());
        }

    }
}
