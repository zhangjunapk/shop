package org.zj.shop.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.web.bind.annotation.PathVariable;
import org.zj.shop.bean.Menu;
import org.zj.shop.bean.Key;
import org.zj.shop.bean.Product;
import org.zj.shop.bean.ProductParam;

import java.util.List;
import java.util.Map;

public interface IQueryDao {

    @Select("select distinct * from product_param where _key=#{key}")
    /**
     *  private int productId;
     *     private String _key;
     *     private String _value;
     *     private int catId;
     */
    @Results({
            @Result(property = "productId",column = "product_id"),
            @Result(property = "_key",column = "_key"),
            @Result(property = "_value",column = "_value"),
            @Result(property = "catId",column = "cat_id"),
    })
    List<ProductParam> selectProductParamByKey(@Param("key") String key);


    @Select("select distinct * from key_table where cat_id=#{catId} and _key=#{key}")
    @Results({
            @Result(property = "catId",column = "cat_id"),
            @Result(property = "paramName",column = "param_name"),
            @Result(property = "_key",column = "_key"),
            @Result(property = "catName",column = "cat_name")
    })
    List<Key> selectKeyByCatIdAndKey(@Param("catId")int id,@Param("key")String key);

    @Select("select * from key where cat_id=#{catId}")
    List<Key> selectAllKeyByCatId(@Param("catId")int catId);


    @Select("select * from menu where parentID=${parentID} and type='menu_alert_top'")
    List<Menu> selectTopMenuByParentID(@Param("id")int id);

    @Select("select count(1) from menu where parentID is null")
    int getTopMenuCount();

    @Select("select * from menu where parentID is null")
    List<Menu> selectTopCategory();

    @Select("select * from menu where parentID=#{id}")
    List<Menu> selectCategoryByParentID(@Param("id") int id);

    @Select("select * from menu where parentID=#{id} and type='menu_alert_top'")
    List<Menu> selectAlertMenuTop(@Param("id")int id);


    /**
     * select product_id,
     *   max(case _key when'name'then _value else 0 end) 名称,
     *   max(case _key when'price'then _value else 0 end) 价格,
     *   max(case _key when'info'then _value else 0 end) 信息
     * from param where category_id=5 and (select count(*) from param where category_id=5 and _key='color' and _value='绿色')=1 and (select count(*) from param where category_id=5 and _key='price' and _value='9999')=1
     * group by product_id
     * @return
     */
    List<Product> selectProductByWhereMap(int catID, Map<String,String> map);


    /**
     * select product_id,
     *   max(case _key when'name'then _value else 0 end) 名称,
     *   max(case _key when'price'then _value else 0 end) 价格,
     *   max(case _key when'info'then _value else 0 end) 信息
     *  from param where category_id=5
     * group by product_id
     * @return
     */
    List<Product> selectProductByCatID(int catID);

    @Select("select * from key_table where cat_id=#{catId}")
    /**
     *  //分类ID
     *     private int catId;
     *
     *     //参数名 cpu核心数/屏幕尺寸/ram/rom/硬盘容量/洗衣机容量/电脑规模
     *     private String paramName;
     *
     *     //具体的参数名 例如 cpu core/scream size/ram/rom/disk size
     *     private String _key;
     *
     *     //分类名 例如 手机/空调/洗衣机/硬盘/电脑
     *     private String catName;
     */
    @Results({
            @Result(property = "catId",column = "cat_id"),
            @Result(property = "paramName",column = "param_name"),
            @Result(property = "_key",column = "_key"),
            @Result(property = "catName",column = "cat_name")
    })
    List<Key> selectKeys(@Param("catId")int catId);

    @Select("select * from key where cat_id=#{catID}")
    List<Key> selectKeyByCatID(int catID);



    @Select("select distinct cat_id from key")
    List<Integer> selectAllCatIDFromKey();

    @Select("select cat_name from key where cat_id=#{id}")
    String selectCatNameByID(int id);

    @Select("Select * from product_param where product_id=#{id}")
    List<ProductParam> selectProductParam(int id);



}
