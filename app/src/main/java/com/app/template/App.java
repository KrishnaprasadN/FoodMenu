package com.app.template;

import android.app.Application;

import com.app.template.dto.CategoryProvider;

/**
 * Created by Krishnaprasad.n on 9/2/2015.
 */
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        //Init the CategoryProvider singleton class
        CategoryProvider.getInstance(this).addCategoryListRequest();
    }
}
