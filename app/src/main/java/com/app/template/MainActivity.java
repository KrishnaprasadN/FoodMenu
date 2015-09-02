package com.app.template;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.app.foodmenu.R;
import com.app.template.fragments.CategoryListFragment;
import com.app.template.fragments.ItemListFragment;
import com.app.template.fragments.OrderFragment;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragments();
    }

    private void initFragments() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        CategoryListFragment categoryListFragment = new CategoryListFragment();
        ItemListFragment itemListFragment = new ItemListFragment();
        OrderFragment orderFragment = new OrderFragment();

        fragmentTransaction.add(R.id.categorylistfragment, categoryListFragment);
        fragmentTransaction.add(R.id.itemlistfragment, itemListFragment);
        fragmentTransaction.add(R.id.orderfragment, orderFragment);

        fragmentTransaction.commit();
    }


}
