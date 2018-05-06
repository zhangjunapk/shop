package org.zj.shop.bean;

public class Key {
    /**
     * 
     */
    //分类ID
    private int catId;

    //参数名 cpu核心数/屏幕尺寸/ram/rom/硬盘容量/洗衣机容量/电脑规模
    private String paramName;

    //具体的参数名 例如 cpu core/scream size/ram/rom/disk size
    private String _key;

    //分类名 例如 手机/空调/洗衣机/硬盘/电脑
    private String catName;


    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String get_key() {
        return _key;
    }

    public void set_key(String _key) {
        this._key = _key;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Key() {
    }


    public Key(int catId, String paramName, String _key, String catName) {
        this.catId = catId;
        this.paramName = paramName;
        this._key = _key;
        this.catName = catName;
    }
}
