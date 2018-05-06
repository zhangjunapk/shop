package org.zj.shop.bean;

public class Menu {
    private int id;
    private String name;
    private int parentID;
    private String link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Menu() {
    }

    public Menu(int id, String name, int parentID, String link) {
        this.id = id;
        this.name = name;
        this.parentID = parentID;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentID=" + parentID +
                ", link='" + link + '\'' +
                '}';
    }
}
