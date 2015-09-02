package com.app.foodmenu.dto;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.app.foodmenu.Constants;
import com.app.foodmenu.utils.CommonUtils;
import com.app.foodmenu.volleyutils.JsonRequestVolley;
import com.app.foodmenu.volleyutils.VolleyRequestManager;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Krishnaprasad.n on 9/2/2015.
 */
public class CategoryProvider {

    private static CategoryProvider mInstance;
    private Context mContext;
    private CategoryList mCategoryList;

    public static CategoryProvider getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new CategoryProvider(context);
        }
        return mInstance;
    }

    private CategoryProvider(Context context) {
        if (mContext == null) {
            mContext = context;
        }
    }

    public void addCategoryListRequest() {
        VolleyRequestManager.getInstance(mContext).getRequestQueue().add(getJsonRequest(null));
    }

    public void addCategoryListRequest(DataDownloadNotifier notifier) {
        VolleyRequestManager.getInstance(mContext).getRequestQueue().add(getJsonRequest(notifier));
    }

    private JsonRequestVolley getJsonRequest(final DataDownloadNotifier notifier) {
        JsonRequestVolley request = new JsonRequestVolley(
                Request.Method.GET,
                Constants.URL_CATEGORYLIST, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                mCategoryList = new Gson().fromJson(response.toString(), CategoryList.class);
                updateNotifierState(notifier, true);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //CommonUtils.showToast(mContext, "Error", Toast.LENGTH_SHORT);
                mCategoryList = null;
                updateNotifierState(notifier, false);
            }
        });

        return request;
    }

    public Category[] getCategoryList() {
        return mCategoryList.getCategories();
    }

    public ArrayList<HashMap> getCategoryNames() {
        ArrayList<HashMap> categoryArrayList = new ArrayList<>();

        if (mCategoryList != null) {
            for (Category category : mCategoryList.getCategories()) {
                HashMap<String, String> categoryHashMap = new HashMap<>();
                categoryHashMap.put(Constants.KEY_CATEGORY_NAME, category.getCategoryName());
                categoryHashMap.put(Constants.KEY_CATEGORY_ID, category.getCategoryId());
                categoryArrayList.add(categoryHashMap);
            }
        }
        return categoryArrayList;
    }

    public ItemList[] getCategoryItemsList(String categoryId) {
        if (mCategoryList != null) {
            for (Category category: mCategoryList.getCategories()) {
                if (category.getCategoryId().equalsIgnoreCase(categoryId)) return category.getItemList();
            }
        }

        return null;
    }

    public boolean isDataDownloaded() {
        return (mCategoryList != null && mCategoryList.getCategories() != null);
    }

    public interface DataDownloadNotifier {
        void onCompleted(boolean state);
    }

    private void updateNotifierState(DataDownloadNotifier notifier, boolean state) {
       if (notifier != null) notifier.onCompleted(state);
    }
}
