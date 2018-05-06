package org.zj.shop.bean;

import java.util.Map;

public class ProductParamVo {
    private int productId;
    private Map<String,String[]> fieldMap;
    private int catId;

    public ProductParamVo() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Map<String, String[]> getFieldMap() {
        return fieldMap;
    }

    public void setFieldMap(Map<String, String[]> fieldMap) {
        this.fieldMap = fieldMap;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public ProductParamVo(int productId, Map<String, String[]> fieldMap, int catId) {
        this.productId = productId;
        this.fieldMap = fieldMap;
        this.catId = catId;
    }
}
