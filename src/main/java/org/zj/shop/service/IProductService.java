package org.zj.shop.service;

import org.zj.shop.bean.Product;
import org.zj.shop.bean.ProductParam;
import org.zj.shop.bean.ProductParamVo;

import java.util.List;
import java.util.Map;

public interface IProductService {

    /**
     * 获得最后一个ID
     * @return
     */
    int getLastID();

    /**
     * 通过catID 和 where Map 来获得Product
     * @param catID
     * @param map
     * @return
     */
    List<Product> getProductByWhereMap(int catID, Map<String,String[]> map);

    /**
     * 遍历map 拼装sql执行插入
     * @param productParamVo
     * @return
     */
    boolean insertProduct(ProductParamVo productParamVo);

    /**
     * 根据分类ID来获得产品
     * @param catID
     * @return
     */
    List<Product> getProductByCatID(int catID);

    /**
     *
     * @param productId
     * @return
     */
    ProductParamVo getProductParamVo(int productId);

    List<ProductParam> getProductParam(int id);

}
