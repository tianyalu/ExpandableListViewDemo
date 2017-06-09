package com.sty.learn.listview.expandablelistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView listView;
    private List<String> group;
    private List<List<String>> child;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ExpandableListView) findViewById(R.id.expandableListView);
        //初始化数据
        initData();
        adapter = new MyAdapter(this, group, child);
        listView.setAdapter(adapter);
    }

    private void initData(){
        group = new ArrayList<String>();
        child = new ArrayList<List<String>>();
        addInfo("BeiJing", new String[]{"ChaoYang", "HaiDian", "DongCheng", "XiCheng"});
        addInfo("HeBei", new String[]{"HanDan", "ShiJiaZhuang", "XingTai"});
        addInfo("GuangDong", new String[]{"GuangZhou", "ShenZhen", "ZhuHai"});
    }

    private void addInfo(String g, String[] c){
        group.add(g);
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < c.length; i++){
            list.add(c[i]);
        }
        child.add(list);
    }
}
