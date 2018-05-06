package org.zj.shop.service;

import org.zj.shop.bean.Key;
import org.zj.shop.bean.KeyVo;
import org.zj.shop.bean.ProductParam;


import java.util.List;
import java.util.Map;

public interface IKeyService {

    List<Integer> selectAllKeyID();

    /**
     * 获得所有分类
     */
    List<Key> selectAllKey(int catId);


    /**
     * 插入分类
     */
    boolean insertCategory(KeyVo keyVo);



    /**
     * 根据分类id来获得分类List
     */
    List<KeyVo> selectAllKeyVo();

    List<KeyVo> selectKeyVoByName(String name);


    List<Map.Entry<Key,List<ProductParam>>> getKeyValuesList(int catId);
}
