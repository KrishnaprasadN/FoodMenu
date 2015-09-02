package com.app.foodmenu.dto;

/**
 * Created by Krishnaprasad.n on 9/2/2015.
 */

public class ItemList {
    private String DateTimeStamp;

    private String Active;

    private String smallImageURL;

    private String ItemId;

    private String bigImageURL;

    private String CategoryId;

    private String ItemType;

    private String Seasonal;

    private String ItemName;

    private String Note;

    private String ItemPrice;

    private String ItemDescription;

    public String getDateTimeStamp() {
        return DateTimeStamp;
    }

    public void setDateTimeStamp(String DateTimeStamp) {
        this.DateTimeStamp = DateTimeStamp;
    }

    public String getActive() {
        return Active;
    }

    public void setActive(String Active) {
        this.Active = Active;
    }

    public String getSmallImageURL() {
        return smallImageURL;
    }

    public void setSmallImageURL(String smallImageURL) {
        this.smallImageURL = smallImageURL;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String ItemId) {
        this.ItemId = ItemId;
    }

    public String getBigImageURL() {
        return bigImageURL;
    }

    public void setBigImageURL(String bigImageURL) {
        this.bigImageURL = bigImageURL;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String CategoryId) {
        this.CategoryId = CategoryId;
    }

    public String getItemType() {
        return ItemType;
    }

    public void setItemType(String ItemType) {
        this.ItemType = ItemType;
    }

    public String getSeasonal() {
        return Seasonal;
    }

    public void setSeasonal(String Seasonal) {
        this.Seasonal = Seasonal;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(String ItemPrice) {
        this.ItemPrice = ItemPrice;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String ItemDescription) {
        this.ItemDescription = ItemDescription;
    }

    @Override
    public String toString() {
        return "[DateTimeStamp = " + DateTimeStamp + ", Active = " + Active + ", smallImageURL = " + smallImageURL + ", ItemId = " + ItemId + ", bigImageURL = " + bigImageURL + ", CategoryId = " + CategoryId + ", ItemType = " + ItemType + ", Seasonal = " + Seasonal + ", ItemName = " + ItemName + ", Note = " + Note + ", ItemPrice = " + ItemPrice + ", ItemDescription = " + ItemDescription + "]";
    }
}
