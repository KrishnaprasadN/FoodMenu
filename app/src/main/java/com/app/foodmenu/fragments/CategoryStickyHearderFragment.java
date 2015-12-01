package com.app.foodmenu.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.foodmenu.R;

/**
 * Created by Monil mittal on 9/8/2015.
 */
public class CategoryStickyHearderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.categorystickyheader,container,false);
        //HeaderListView list = new HeaderListView(getActivity());
        //StickyListHeadersListView stickyList = (StickyListHeadersListView) view.findViewById(R.id.list);
     /*   MyAdapter adapter = new MyAdapter(this);
        stickyList.setAdapter(adapter);*/
        return view;
    }

   /* public class MyAdapter extends BaseAdapter implements StickyListHeadersAdapter {

        private ArrayList<HashMap> mCategoryList;
        private ItemList[] mItemList;
        private LayoutInflater inflater;

        public MyAdapter() {
            mCategoryList = CategoryProvider.getInstance(getActivity()).getCategoryNames();

        }

        @Override
        public int getCount() {
            return mCategoryList.size();
        }

        @Override
        public Object getItem(int position) {
            return mCategoryList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.category_item_row, parent, false);
                holder.item_title = (TextView) convertView.findViewById(R.id.item_title);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

           // holder.text.setText(CategoryProvider.getInstance(getActivity()).getCategoryItemsList(position));

            return convertView;
        }

        @Override
        public View getHeaderView(int position, View convertView, ViewGroup parent) {
            HeaderViewHolder holder;
            if (convertView == null) {
                holder = new HeaderViewHolder();
                convertView = inflater.inflate(R.layout.header, parent, false);
                holder.text = (TextView) convertView.findViewById(R.id.text);
                convertView.setTag(holder);
            } else {
                holder = (HeaderViewHolder) convertView.getTag();
            }
            //set header text as first char in name
            String headerText = "" + countries[position].subSequence(0, 1).charAt(0);
            holder.text.setText(headerText);
            return convertView;
        }

        @Override
        public long getHeaderId(int position) {
            //return the first character of the country as ID because this is what headers are based upon
            return countries[position].subSequence(0, 1).charAt(0);
        }

        class HeaderViewHolder {
            TextView text;
        }

        class ViewHolder {
            TextView text;
        }

    }*/
}
