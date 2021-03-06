package com.app.foodmenu;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.app.foodmenu.fragments.CategoryListFragment;
import com.app.foodmenu.fragments.ItemListFragment2;
import com.app.foodmenu.fragments.OrderFragment;

public class MainActivity extends Activity implements CategoryListFragment.CategoryItemClickListener {

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
        //ItemListFragment itemListFragment = new ItemListFragment();
        ItemListFragment2 itemListFragment = new ItemListFragment2();
        OrderFragment orderFragment = new OrderFragment();

        fragmentTransaction.add(R.id.categorylistfragment, categoryListFragment, Constants.FRAGMENT_TAG_CATEGORY);
        fragmentTransaction.add(R.id.itemlistfragment, itemListFragment, Constants.FRAGMENT_TAG_ITEMlIST);
        fragmentTransaction.add(R.id.orderfragment, orderFragment, Constants.FRAGMENT_TAG_ORDER);

        fragmentTransaction.commit();
    }


    @Override
    public void onItemClick(final String categoryId) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
               /* ((ItemListFragment2) getFragmentManager()
                        .findFragmentByTag(Constants.FRAGMENT_TAG_ITEMlIST))
                        .updateItem(categoryId);*/
            }
        });

    }
}
