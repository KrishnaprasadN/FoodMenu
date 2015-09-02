package com.app.template.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.foodmenu.R;
import com.app.template.Constants;
import com.app.template.dto.CategoryProvider;
import com.app.template.dto.ItemList;

/**
 * Created by Krishnaprasad.n on 9/2/2015.
 */
public class ItemListFragment extends Fragment {
    private String mCategoryId = "0";
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_items, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.item_recycleviewer);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new CategoryItemListAdapter());

        readArguments();

        return view;
    }

    private void readArguments() {
        if (getArguments().containsKey(Constants.KEY_CATEGORY_ID)) {
            mCategoryId = (String) getArguments().get(Constants.KEY_CATEGORY_ID);
        }
    }

    public class CategoryItemListAdapter extends RecyclerView.Adapter<CategoryItemListAdapter.ViewHolder> {
        private ItemList[] mItemList;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView mCategoryItemTitle;

            public ViewHolder(View v) {
                super(v);
                mCategoryItemTitle = (TextView) v.findViewById(R.id.item_title);
            }
        }

        public CategoryItemListAdapter() {
            mItemList = CategoryProvider.getInstance(getActivity()).getCategoryItemsList(mCategoryId);
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
            return mItemList.length;
        }

        public void updateItem(String categoryId) {
            mCategoryId = categoryId;
            mItemList = CategoryProvider.getInstance(getActivity()).getCategoryItemsList(mCategoryId);
            mRecyclerView.invalidate();
        }
    }

}

