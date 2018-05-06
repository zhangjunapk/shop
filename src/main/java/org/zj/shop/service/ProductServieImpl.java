package org.zj.shop.service;

import oracle.jrockit.jfr.ProducerDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zj.shop.bean.Product;
import org.zj.shop.bean.ProductParam;
import org.zj.shop.bean.ProductParamVo;
import org.zj.shop.dao.IDeleteDao;
import org.zj.shop.dao.IInsertDao;
import org.zj.shop.dao.IQueryDao;
import org.zj.shop.dao.IUpdateDao;
import org.zj.shop.util.DBUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServieImpl implements IProductService {

    @Autowired
    IDeleteDao deleteDao;

    @Autowired
    IQueryDao queryDao;

    @Autowired
    IUpdateDao updateDao;

    @Autowired
    IInsertDao insertDao;

    @Override
    public int getLastID() {
        int result=-1;
        for(Integer i:queryDao.selectAllCatIDFromKey()){
            if(i>result){
                result=i;
            }
        }
        return result;
    }

    @Override
    public List<Product> getProductByWhereMap(int catID, Map<String, String[]> map) {
        List<Product> result=new ArrayList<>();
        StringBuilder sb=new StringBuilder("select product_id id,\n" +
                "  max(case _key when'name'then _value else 0 end) name,\n" +
                "  max(case _key when'price'then _value else 0 end) price,\n" +
                "  max(case _key when'pic_link'then _value else 0 end) picLink\n" +
                "from product_param where cat_id="+catID+" and ");

        for(Map.Entry<String,String[]> entry:map.entrySet()){
            sb.append("(select count(1) from product_param where cat_id="+catID+" and _key='"+entry.getKey()+"' and _value='"+entry.getValue()[0]+"')>=1 and ");
        }
        sb=new StringBuilder(sb.substring(0,sb.length()-4));
        sb.append("group by product_id");



        System.out.println(sb);




        return result;
    }

    @Override
    public boolean insertProduct(ProductParamVo productParamVo) {

        for(Map.Entry<String,String[]> entry:productParamVo.getFieldMap().entrySet()){
            StringBuilder sb=new StringBuilder("insert into product_param(product_id,_key,_value,cat_id) values(");
            sb.append(productParamVo.getProductId()+","+entry.getKey()+","+entry.getValue()+","+productParamVo.getCatId()+")");
            System.out.println(sb);
        }

        return true;
    }

    @Override
    public List<Product> getProductByCatID(int catID) {

        StringBuilder sb=new StringBuilder("select product_id id,\n" +
                "  max(case _key when'name'then _value else 0 end) name,\n" +
                "  max(case _key when'price'then _value else 0 end) price,\n" +
                "  max(case _key when'pic_link'then _value else 0 end) picLink\n" +
                "from param where category_id="+catID+")");
        System.out.println(sb);
        return null;
    }


    @Override
    public ProductParamVo getProductParamVo(int productId) {
        ProductParamVo productParamVo=new ProductParamVo();
        Map<String,String[]> map=new HashMap<>(18);
        for(ProductParam productParam:getProductParam(productId)){
            map.put(productParam.get_key(),new String[]{productParam.get_value()});
            productParamVo.setCatId(productParam.getCatId());
            productParamVo.setProductId(productParam.getProductId());
        }
        productParamVo.setFieldMap(map);
        return productParamVo;
    }

    @Override
    public List<ProductParam> getProductParam(int id) {
        return queryDao.selectProductParam(id);
    }
}
