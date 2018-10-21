package com.example.customview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener, SideView.Listener {
    private ListView listView;
    String[] dd = new String[]{"gsdfgsd", "dfsgdfs", "ertretre", "432423", "432423", "3233", "gsdfgsd", "dfsgdfs", "ertretre", "432423", "432423", "3233", "gsdfgsd", "dfsgdfs", "ertretre", "432423", "432423", "3233"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SideView sideView = findViewById(R.id.sideView);
        sideView.setListener(this);
//        CalendarView calendarView=findViewById(R.id.view);
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dd);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, dd[i], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSelect(String str) {
        Toast.makeText(this, "选中：" + str, Toast.LENGTH_SHORT).show();
    }
}
