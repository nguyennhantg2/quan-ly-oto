package com.example.qlyoto.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.qlyoto.R;
import com.example.qlyoto.dao.OtoDao;
import com.example.qlyoto.model.Oto;
import com.example.qlyoto.ui.adapter.OtoAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OtoAdapter.Callback {
    private ListView listview;
    private Button them;
    private List<Oto> data;
    private OtoAdapter otoAdapter;
    private OtoDao otoDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);
        them = (Button) findViewById(R.id.them);
        data = new ArrayList<>();

        them.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ThemOtoActivity.class));
        });

        showData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showData();
    }

    private void showData(){
        otoDao = new OtoDao(this);
        data = otoDao.getListAllOto();
        otoAdapter = new OtoAdapter(data, this);
        listview.setAdapter(otoAdapter);
    }

    @Override
    public void delete(Oto oto) {
        otoDao.deleteOto(oto.getId());
        showData();
    }

    @Override
    public void edit(Oto oto) {

    }
}