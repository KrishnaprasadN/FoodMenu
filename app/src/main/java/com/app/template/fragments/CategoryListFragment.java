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

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Monil mittal on 9/2/2015.
 */
public class CategoryListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.category_recycleviewer);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        CategoryListAdapter categoryListAdapter = new CategoryListAdapter();
        recyclerView.setAdapter(categoryListAdapter);

        return view;
    }


    public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {
        private ArrayList<HashMap> mCategoryList;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mCategoryTitle;

            public ViewHolder(View v) {
                super(v);
                mCategoryTitle = (TextView) v.findViewById(R.id.category_title);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public CategoryListAdapter() {
            mCategoryList = CategoryProvider.getInstance(getActivity()).getCategoryNames();
        }

        // Create new views (invoked by the layout manager)
        @Override
        public CategoryListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardrowlayout, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            final HashMap<String, String> category = mCategoryList.get(position);
            holder.mCategoryTitle.setText(category.get(Constants.KEY_CATEGORY_NAME));
            holder.mCategoryTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CategoryItemClickListener listener = (CategoryItemClickListener) getActivity();
                    if (listener != null)
                        listener.onItemClick(category.get(Constants.KEY_CATEGORY_ID));
                }
            });
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mCategoryList.size();
        }

    }

    public interface CategoryItemClickListener {
        void onItemClick(String categoryId);
    }
}
