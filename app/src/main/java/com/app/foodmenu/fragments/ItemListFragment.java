package com.app.foodmenu.fragments;

import android.app.Fragment;
import android.os.Bundle;
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
       /* mAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override public void onChanged() {
                super.onChanged();
               // decoration.invalidateHeaders();
                mAdapter.notifyDataSetChanged();
                mRecyclerView.invalidate();
            }
        });
*/
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    public void updateItem(String categoryId) {
        mCategoryId = categoryId;
       // mRecyclerView.removeAllViews();
       // mAdapter = new CategoryItemListAdapter();
        //new ArrayList( Arrays.asList(mItemList)).clear();
       /* (Arrays.asList(mItemList)).remove(1);
        mRecyclerView.removeViewAt(1);
        mAdapter.notifyItemRemoved(1);
        mAdapter.notifyItemRangeChanged(1, mItemList.size());*/
       // mItemList=CategoryProvider.getInstance(getActivity()).getCategoryItemsList(categoryId);

        //mItemList = CategoryProvider.getInstance(getActivity()).getCategoryItemsList(categoryId);
        //mRecyclerView.setAdapter(mAdapter);
        //mAdapter.updateList(mItemList);
/*        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ArrayList<ItemList> itemList = new ArrayList<ItemList>(Arrays.asList(mItemList))
                mItemList = .toArray(new Integer[((Arrays.asList(mItemList)).remove(1)).size()]);
                (Arrays.asList(mItemList)).remove(1);
                mRecyclerView.removeViewAt(1);
                mAdapter.notifyItemRemoved(1);
                mAdapter.notifyItemRangeChanged(1, mItemList.length);
            }
        });*/
/*       new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                mAdapter = new CategoryItemListAdapter();
                mRecyclerView.setAdapter(mAdapter);
            }
        });*/
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

      /*  mAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override public void onChanged() {
                super.onChanged();
                decoration.invalidateHeaders();
            }
        });*/
        @Override
        public int getItemCount() {
            //Log.i("ItemListCount"," "+ mItemList.length);
            return (mItemList == null)? 0: mItemList.length;
        }
        public void updateList(ItemList[] itemList) {

            mItemList = itemList;
            mAdapter.notifyDataSetChanged();
        }
    }

}

