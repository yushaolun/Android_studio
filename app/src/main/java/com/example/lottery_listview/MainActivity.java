package com.example.lottery_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    public ListView listView;
    public String[]from={"title","num0","num1","num2","num3","num4","num5"};
    public int to[]={R.id.title,R.id.item_num0,R.id.item_num1,R.id.item_num2,R.id.item_num3,R.id.item_num4,R.id.item_num5};
    public LinkedList<HashMap<String,String>> data=new LinkedList<>();

    public SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);
        initview();

    }

    private void initview() {




        adapter=new SimpleAdapter(this,data,R.layout.item,from,to);
        listView.setAdapter(adapter);
    }

    public void lottery(View view) {
        int [] lottery=createnum();
        HashMap<String,String> row= new HashMap<>();
        row.put(from[0], "第"+(data.size()+1+"組"));
        row.put(from[1], String.valueOf(lottery[0]));
        row.put(from[2], String.valueOf(lottery[1]));
        row.put(from[3], String.valueOf(lottery[2]));
        row.put(from[4], String.valueOf(lottery[3]));
        row.put(from[5], String.valueOf(lottery[4]));
        row.put(from[6], String.valueOf(lottery[5]));

        data.add(row);
        adapter.notifyDataSetChanged();
        listView.smoothScrollToPosition(data.size()-1);

    }




    public int[] createnum(){
        HashSet<Integer> set=new HashSet<>();
        int random;
        while (set.size()<6){

            set.add((int)(Math.random()*49+1));
        }
        int i=0;
        int[]lottery=new int[6];
        for (Integer num:set ){
            lottery[i]=num;
            i++;
        }
        return lottery;
    }





}
