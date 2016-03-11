package com.dddp.optionmunudemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Context menu part: START
        * 1# Dynamically add items into context menu
        * 2# xml import
        * - new a xml (menu resource file)
        * - inflate it to MenuInflate
        * DON'T forget to register context menu in this activity with binding the View specified*/
        ListView listView = (ListView) findViewById(R.id.lv_context_menu);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData());
        listView.setAdapter(adapter);
        /*register context menu for the ListView*/
        this.registerForContextMenu(listView);
        /*Context menu part: END*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*Method 1# xml import menu*/
        //getMenuInflater().inflate(R.menu.main, menu);
        /*Method 2# Dynamically add menu*/
        MenuItem item = menu.add(1, 3, 103, "Option menu 3(D)");
        menu.add(1, 4, 104, "Option menu 4(D)");
        menu.add(1, 5, 105, "Option menu 5(D)");
        item.setTitle("Option menu");
        /*Will show when API < 11*/
        item.setIcon(R.mipmap.ic_google_earth);

        /*SubMenu part
        * 1# Dynamically add items into context menu
        * 2# Inflate xml (Statically)*/
        SubMenu file = menu.addSubMenu("File");
        SubMenu edit = menu.addSubMenu("Edit");
        file.add(3, 1, 1, "New");
        file.add(3, 2, 1, "Save");
        edit.add(4, 1, 1, "Search");
        edit.add(4, 2, 1, "Delete");
        file.setHeaderIcon(R.mipmap.ic_google_earth);
        file.setHeaderTitle("File");
        edit.setHeaderIcon(R.mipmap.ic_google_earth);
        edit.setHeaderTitle("Edit");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch ( item.getItemId() ) {
            case R.id.action_menu_item_1:
                Toast.makeText(this, "Click menu 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_menu_item_2:
                Toast.makeText(this, "Click menu 2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Second activity", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            case 4:
                Toast.makeText(this, "Click menu 4", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(this, "Click menu 5", Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(this, "Click menu 6", Toast.LENGTH_SHORT).show();
                break;
        }
        /*Sub menu part START*/
        if ( 3 == item.getGroupId() ) {
            switch ( item.getItemId() ) {
                case 1:
                    Toast.makeText(this, "Click \"File->New\"", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(this, "Click \"File->Save\"", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else if ( 4 == item.getGroupId() ) {
            switch ( item.getItemId() ) {
                case 1:
                    Toast.makeText(this, "Click \"Edit->Search\"", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(this, "Click \"Edit->Delete\"", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        /*Sub menu part END*/


        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        /*Context menu: 1# Inflate xml file(Statically)*/
        //getMenuInflater().inflate(R.menu.cm, menu);
        menu.setHeaderTitle("Context Menu");
        menu.setHeaderIcon(R.mipmap.ic_google_earth);
        /* 2# Dynamically add items into context menu*/
        /*menu.add(1, 100, 100, "Dynamically added item name 1");
        menu.add(1,101, 100, "Dynamically added item name 2");
        menu.add(1,102, 100, "Dynamically added item name 3");*/

        /*SubMenu part
        * 1# Dynamically add items into context menu
        * 2# Inflate xml (Statically)*/
       /* SubMenu file = menu.addSubMenu("File(D)");
        SubMenu edit = menu.addSubMenu("Edit(D)");
        file.add(3, 1, 1, "New");
        file.add(3, 2, 1, "Save");
        edit.add(4, 1, 1, "Search");
        edit.add(4, 2, 1, "Delete");
        file.setHeaderIcon(R.mipmap.ic_google_earth);
        file.setHeaderTitle("File");
        edit.setHeaderIcon(R.mipmap.ic_google_earth);
        edit.setHeaderTitle("File");*/
        /*2# Inflate xml (Statically) */
        getMenuInflater().inflate(R.menu.sm, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId() ) {
            case 100:
                Toast.makeText(this, "Click item 1", Toast.LENGTH_SHORT).show();
                break;
            case 101:
                Toast.makeText(this, "Click item 2", Toast.LENGTH_SHORT).show();
                break;
            case 102:
                Toast.makeText(this, "Click item 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_menu_item_1:
                Toast.makeText(this, "Click item 4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_menu_item_2:
                Toast.makeText(this, "Click item 5", Toast.LENGTH_SHORT).show();
                break;
            /*For sub menu "2#" part*/
            case R.id.sm_new:
                Toast.makeText(this, "File->New", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sm_save:
                Toast.makeText(this, "File->Save", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sm_search:
                Toast.makeText(this, "Edit->Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sm_delete:
                Toast.makeText(this, "Edit->Delete", Toast.LENGTH_SHORT).show();
                break;
        }
        /*For sub menu part*/
        if ( 3 == item.getGroupId() ) {
            switch ( item.getItemId() ) {
                case 1:
                    Toast.makeText(this, "Click \"File->New\"", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(this, "Click \"File->Save\"", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else if ( 4 == item.getGroupId() ) {
            switch ( item.getItemId() ) {
                case 1:
                    Toast.makeText(this, "Click \"Edit->Search\"", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(this, "Click \"Edit->Delete\"", Toast.LENGTH_SHORT).show();
                    break;
            }
        }


        return true;
    }

    /**
     * @param NULL
     * @return List<String>
     */
    private List<String> getData() {
        List<String> dataList = new ArrayList<>();
        for ( int i = 0; i < 5; i++) {
            dataList.add("File");
        }

        return dataList;
    }
}
