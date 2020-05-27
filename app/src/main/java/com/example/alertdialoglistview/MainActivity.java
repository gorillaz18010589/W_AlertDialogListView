package com.example.alertdialoglistview;
//1.style/準備陣列裡面要放置的東西
//2.準備Item頁面裡面配置listView
//3.在準備coutom_item去配置內容
//4.準備Model

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);
                View view_row = LayoutInflater.from(MainActivity.this).inflate(R.layout.row_item, null);
                ListView a = view_row.findViewById(R.id.listView);
                a.setAdapter(new CustomAdapter(MainActivity.this));

                alertdialog.setView(view_row);
                AlertDialog dialog = alertdialog.create();
                dialog.show();
            }
        });
    }
}
