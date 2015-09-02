package com.app.template.dto;

/**
 * Created by Krishnaprasad.n on 9/2/2015.
 */
public class Category {
    private String DateTimeStamp;

    private String smallImageURL;

    private ItemList[] ItemList;

    private String bigImageURL;

    private String CategoryName;

    private String CategoryId;

    private String Note;

    public String getDateTimeStamp() {
        return DateTimeStamp;
    }

    public void setDateTimeStamp(String DateTimeStamp) {
        this.DateTimeStamp = DateTimeStamp;
    }

    public String getSmallImageURL() {
        return smallImageURL;
    }

    public void setSmallImageURL(String smallImageURL) {
        this.smallImageURL = smallImageURL;
    }

    public ItemList[] getItemList() {
        return ItemList;
    }

    public void setItemList(ItemList[] ItemList) {
        this.ItemList = ItemList;
    }

    public String getBigImageURL() {
        return bigImageURL;
    }

    public void setBigImageURL(String bigImageURL) {
        this.bigImageURL = bigImageURL;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String CategoryId) {
        this.CategoryId = CategoryId;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    @Override
    public String toString() {
        return "[DateTimeStamp = " + DateTimeStamp + ", smallImageURL = " + smallImageURL + ", ItemList = " + ItemList + ", bigImageURL = " + bigImageURL + ", CategoryName = " + CategoryName + ", CategoryId = " + CategoryId + ", Note = " + Note + "]";
    }
}