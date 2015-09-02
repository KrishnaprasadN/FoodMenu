package com.app.foodmenu.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.foodmenu.R;
import com.app.foodmenu.dto.CategoryProvider;
import com.app.foodmenu.dto.ItemList;


/**
 * Created by Krishnaprasad.n on 9/2/2015.
 */
public class ItemListFragment extends Fragment {
    private String mCategoryId = "C0001";
    private RecyclerView mRecyclerView;
    private CategoryItemListAdapter mAdapter;
    private ItemList[] mItemList;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_items, container, false);

        mItemList = CategoryProvider.getInstance(getActivity()).getCategoryItemsList(mCategoryId);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.item_recycleviewer);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new CategoryItemListAdapter();
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    public void updateItem(String categoryId) {
        mCategoryId = categoryId;
        mItemList = CategoryProvider.getInstance(getActivity()).getCategoryItemsList(categoryId);

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                mAdapter.notifyDataSetChanged();
                mRecyclerView.setAdapter(mAdapter);
                mRecyclerView.invalidate();
            }
        });
    }


    public class CategoryItemListAdapter extends RecyclerView.Adapter<CategoryItemListAdapter.ViewHolder> {

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView mCategoryItemTitle;

            public ViewHolder(View v) {
                super(v);
                mCategoryItemTitle = (TextView) v.findViewById(R.id.item_title);
            }
        }

        public CategoryItemListAdapter() {
        }

        @Override
        public CategoryItemListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                     int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_row, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            if (mItemList != null && mItemList[position] != null) {
                holder.mCategoryItemTitle.setText(mItemList[position].getItemName());
            } else {
                holder.mCategoryItemTitle.setText("");
            }

        }

        @Override
        public int getItemCount() {
            return (mItemList == null)? 0: mItemList.length;
        }
    }
}

