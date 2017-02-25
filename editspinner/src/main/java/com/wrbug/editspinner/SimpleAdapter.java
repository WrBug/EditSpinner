package com.wrbug.editspinner;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * SimpleAdapter
 *
 * @author WrBug
 * @since 2017/2/25
 */
public class SimpleAdapter extends BaseEditSpinnerAdapter implements EditSpinnerFilter {
    private Context mContext;
    private List<String> mSpinnerData;
    private List<String> mCacheData;
    private int[] indexs;

    public SimpleAdapter(Context context, List<String> spinnerData) {
        this.mContext = context;
        this.mSpinnerData = spinnerData;
        mCacheData = new ArrayList<>(spinnerData);
        indexs = new int[mSpinnerData.size()];
    }

    @Override
    public EditSpinnerFilter getEditSpinnerFilter() {
        return this;
    }

    @Override
    public String getItemString(int position) {
        return mSpinnerData.get(indexs[position]);
    }

    @Override
    public int getCount() {
        return mCacheData == null ? 0 : mCacheData.size();
    }

    @Override
    public String getItem(int position) {
        return mCacheData == null ? "" : mCacheData.get(position) == null ? "" : mCacheData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = null;
        if (convertView == null) {
            textView = (TextView) LayoutInflater.from(mContext).inflate(android.R.layout.simple_spinner_item, null);
        } else {
            textView = (TextView) convertView;
        }
        textView.setText(Html.fromHtml(getItem(position)));
        return textView;
    }

    @Override
    public boolean onFilter(String keyword) {
        mCacheData.clear();
        if (TextUtils.isEmpty(keyword)) {
            mCacheData.addAll(mSpinnerData);
            for (int i = 0; i < indexs.length; i++) {
                indexs[i] = i;
            }
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append("[^\\s]*").append(keyword).append("[^\\s]*");
            for (int i = 0; i < mSpinnerData.size(); i++) {
                if (mSpinnerData.get(i).replaceAll("\\s+", "|").matches(builder.toString())) {
                    indexs[mCacheData.size()] = i;
                    mCacheData.add(mSpinnerData.get(i).replaceFirst(keyword, "<font color=\"#aa0000\">" + keyword + "</font>"));
                }
            }
        }
        notifyDataSetChanged();
        return mCacheData.size() <= 0;
    }
}
