package org.zj.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zj.shop.bean.Key;
import org.zj.shop.bean.KeyVo;
import org.zj.shop.bean.ProductParam;
import org.zj.shop.dao.IDeleteDao;
import org.zj.shop.dao.IInsertDao;
import org.zj.shop.dao.IQueryDao;
import org.zj.shop.dao.IUpdateDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KeyServiceImpl implements IKeyService {

    @Autowired
    IDeleteDao deleteDao;

    @Autowired
    IQueryDao queryDao;

    @Autowired
    IUpdateDao updateDao;

    @Autowired
    IInsertDao insertDao;

    @Override
    public List<Integer> selectAllKeyID() {
        return queryDao.selectAllCatIDFromKey();
    }

    @Override
    public List<Key> selectAllKey(int catId) {
        return queryDao.selectKeys(catId);
    }

    @Override
    public boolean insertCategory(KeyVo keyVo) {
        for(Map.Entry<String,String[]> entry:keyVo.getKeyMap().entrySet()){
            StringBuilder sb=new StringBuilder("insert into key_table(cat_id,_key,param_pname,cat_name) values("+keyVo.getCatId()+","+entry.getKey()+","+entry.getValue()+","+keyVo.getCatName()+")");
            System.out.println(sb.toString());
        }
        return true;
    }

    @Override
    public List<KeyVo> selectAllKeyVo() {
        List<KeyVo> result = new ArrayList<>();
        List<Integer> keyIds = selectAllKeyID();
        for (Integer i : keyIds) {
            String catName = queryDao.selectCatNameByID(i);
            Map<String, String[]> nameMap = new HashMap<>();
            for (Key key : queryDao.selectKeyByCatID(i)) {
                nameMap.put(key.get_key(), new String[]{key.getParamName()});
            }

            result.add(new KeyVo(i,catName,nameMap));
        }
        return result;
    }

    @Override
    public List<KeyVo> selectKeyVoByName(String name) {
        List<KeyVo> result=new ArrayList<>();
        for(KeyVo keyVo:selectAllKeyVo()){
            if(keyVo.getCatName().contains(name)){
                result.add(keyVo);
            }
        }
        return result;
    }

    @Override
    public List<Map.Entry<Key, List<ProductParam>>> getKeyValuesList(int catId) {
        List<Map.Entry<Key, List<ProductParam>>> result=new ArrayList<>();
        for(Key key:selectAllKey(catId)){

            System.out.println("cat id "+key.getCatId()+"   _key  "+key.get_key());
            result.add(new Map.Entry<Key, List<ProductParam>>() {
                @Override
                public Key getKey() {
                    return key;
                }

                @Override
                public List<ProductParam> getValue() {
                    return queryDao.selectProductParamByKey(key.get_key());
                }

                @Override
                public List<ProductParam> setValue(List<ProductParam> value) {
                    return null;
                }
            });
        }
        return result;
    }
}

