package com.example.qlyoto.model;

public class Oto {
    private int id;
    private String hang;
    private int gia;
    private String model;

    public Oto() {
    }

    public Oto(int id, String hang, int gia, String model) {
        this.id = id;
        this.hang = hang;
        this.gia = gia;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
