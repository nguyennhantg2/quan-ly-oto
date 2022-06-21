package com.example.qlyoto.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.qlyoto.R;

import com.example.qlyoto.model.Oto;

import java.util.List;

public class OtoAdapter extends BaseAdapter {
    private List<Oto> data;
    private TextView idOto;
    private TextView modelOto;
    private TextView hangOto;
    private TextView giaOto;
    private TextView edit;
    private TextView delete;
    Callback callback;

    public OtoAdapter(List<Oto> data, Callback callback) {
        this.data = data;
        this.callback = callback;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return data.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewOto;
        if(view == null){
            viewOto = View.inflate(viewGroup.getContext(), R.layout.oto_layout, null);
        }else{
            viewOto = view;
        }
        idOto = (TextView) viewOto.findViewById(R.id.idOto);
        modelOto = (TextView) viewOto.findViewById(R.id.modelOto);
        hangOto = (TextView) viewOto.findViewById(R.id.hangOto);
        giaOto = (TextView) viewOto.findViewById(R.id.giaOto);
        edit = (TextView) viewOto.findViewById(R.id.edit);
        delete = (TextView) viewOto.findViewById(R.id.delete);

        Oto oto = (Oto) getItem(i);
        idOto.setText(String.valueOf(i));
        modelOto.setText(oto.getModel());
        hangOto.setText(oto.getHang());
        giaOto.setText(String.valueOf(oto.getGia()));

        edit.setOnClickListener(v -> {
            callback.edit(oto);
        });

        delete.setOnClickListener(v -> {
            callback.delete(oto);
        });

        return viewOto;
    }

    public interface Callback {
        void delete(Oto oto);

        void edit(Oto oto);
    }
}
