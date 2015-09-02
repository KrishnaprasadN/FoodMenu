package com.app.template.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Krishnaprasad.n on 9/2/2015.
 */
public class CategoryList {
/*    private Result[] Result;

    public Result[] getResult() {
        return Result;
    }

    public void setResult(Result[] Result) {
        this.Result = Result;
    }*/

    @SerializedName("Result")
    private Category[] mCategories;

    public Category[] getCategories() {
        return mCategories;
    }

    @Override
    public String toString() {
        return "[mCategories = " + mCategories + "]";
    }
}



