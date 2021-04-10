package com.example.addproducttocart;

public class product {
    int hinhanh;
    String ten;
    String mota;
    boolean isAddtoCard;

    public boolean isAddtoCard() {
        return isAddtoCard;
    }

    public void setAddtoCard(boolean addtoCard) {
        isAddtoCard = addtoCard;
    }

    public product(int hinhanh, String ten, String mota) {
        this.hinhanh = hinhanh;
        this.ten = ten;
        this.mota = mota;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
