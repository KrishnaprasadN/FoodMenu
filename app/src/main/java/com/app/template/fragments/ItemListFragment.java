package com.app.template.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.foodmenu.R;

/**
 * Created by Monil mittal on 9/2/2015.
 */
public class ItemListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    public void updateItem(String selectedCategoryId) {
        Log.i("selectedCategoryId", selectedCategoryId);
    }
}

