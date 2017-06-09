package com.sty.learn.listview.expandablelistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shity on 2017/6/6/0006.
 */

public class MyAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> group;
    private List<List<String>> child;

    public MyAdapter(Context context, List<String> group,
                     List<List<String>> child){
        this.context = context;
        this.group = group;
        this.child = child;
    }
    @Override
    public int getGroupCount() {
        return group.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return group.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * 显示: group
     * @param groupPosition
     * @param isExpanded
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.list_item, null);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder); //使用setTag把查找的view缓存起来方便多次重用
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(group.get(groupPosition));
        holder.textView.setTextSize(25);
        holder.textView.setPadding(35, 10, 0, 10);
        return convertView;
    }

    /**
     * 显示： child
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.list_item, null);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder); //使用setTag把查找的view缓存起来方便多次重用
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(child.get(groupPosition).get(childPosition));
        holder.textView.setTextSize(20);
        holder.textView.setPadding(72, 10, 0, 10);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    class ViewHolder{
        TextView textView;
    }
}
