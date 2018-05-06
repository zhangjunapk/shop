package org.zj.shop.bean;

public class ProductParam {
    private int productId;
    private String _key;
    private String _value;
    private int catId;

    public ProductParam() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String get_key() {
        return _key;
    }

    public void set_key(String _key) {
        this._key = _key;
    }

    public String get_value() {
        return _value;
    }

    public void set_value(String _value) {
        this._value = _value;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public ProductParam(int productId, String _key, String _value, int catId) {
        this.productId = productId;
        this._key = _key;
        this._value = _value;
        this.catId = catId;
    }
}
