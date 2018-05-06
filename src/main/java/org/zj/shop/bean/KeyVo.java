package org.zj.shop.bean;

import java.util.Map;

public class KeyVo {
    private int catId;
    private String catName;
    /**
     * key name,alias chinese
     */
    private Map<String,String[]> keyMap;

    public KeyVo() {
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Map<String, String[]> getKeyMap() {
        return keyMap;
    }

    public void setKeyMap(Map<String, String[]> keyMap) {
        this.keyMap = keyMap;
    }

    public KeyVo(int catId, String catName, Map<String, String[]> keyMap) {
        this.catId = catId;
        this.catName = catName;
        this.keyMap = keyMap;
    }
}
