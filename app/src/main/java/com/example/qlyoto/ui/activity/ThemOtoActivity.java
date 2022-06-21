package com.example.qlyoto.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlyoto.R;
import com.example.qlyoto.dao.OtoDao;
import com.example.qlyoto.model.Oto;

public class ThemOtoActivity extends AppCompatActivity {
    private OtoDao otoDao;
    private EditText hang;
    private EditText gia;
    private EditText model;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_oto);

        otoDao = new OtoDao(this);
        hang = (EditText) findViewById(R.id.hang);
        gia = (EditText) findViewById(R.id.gia);
        model = (EditText) findViewById(R.id.model);
        add = (Button) findViewById(R.id.add);

        add.setOnClickListener(v -> {
            String h = hang.getText().toString();
            int g = Integer.valueOf(gia.getText().toString());
            String m = model.getText().toString();

            Oto oto = new Oto();
            oto.setHang(h);
            oto.setGia(g);
            oto.setModel(m);

            if(otoDao.addOto(oto)) {
                Toast.makeText(this, "Them thanh cong", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Them that bai", Toast.LENGTH_SHORT).show();
            }

        });

    }
}