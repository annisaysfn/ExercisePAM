package com.example.exercisepam;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupMenu;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    private ListView list;
    private ListViewAdapter adapter;

    SearchView searchView;

    String[] listNama;

    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    Bundle bundle = new Bundle();

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listNama = new String[]{"Inayah", "Ilham", "Eris",
                "Fikri", "Maul", "Intan", "Vina", "Gita",
                "Vian", "Lutfi"};

        list = findViewById(R.id.listKontak);
        searchView = findViewById(R.id.pencarian);

        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i < listNama.length; i++)
        {
            ClassNama classNama = new ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);
        }

        adapter = new ListViewAdapter(this);

        list.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return true;
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nama = classNamaArrayList.get(position).getNama();

                bundle.putString("a",nama.trim());

                PopupMenu pm = new PopupMenu(getApplicationContext(), view);

                pm.setOnMenuItemClickListener(Home.this);

                pm.inflate(R.menu.popupmenu);

                pm.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnviewdata:
                intent = new Intent(getApplicationContext(),LihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnviewnumber:
                Toast.makeText (getApplicationContext(), LihatData.nohp, Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}