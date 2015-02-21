package com.ift215.tp3.ma_famille;

public class NavigationModel{

    private int icon;
    private String title;

    private boolean isGroupHeader = false;

    public NavigationModel(String title) {
        this(-1,title);
        isGroupHeader = true;
    }
    public NavigationModel(int icon, String title) {
        super();
        this.icon = icon;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public boolean isGroupHeader() {
        return isGroupHeader;
    }

}