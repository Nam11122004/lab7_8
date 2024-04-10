package com.example.namntph36893_ph36893_thi_and103.Model;
import com.google.gson.annotations.SerializedName;
public class SinhVien {
    @SerializedName("_id")
    private String id;
    private String hoten,quequan,hinhanh;
    private int diem;
    private String  createAt, updateAt;

    public SinhVien() {
    }

    public SinhVien(String id, String hoten, String quequan, String hinhanh, int diem, String createAt, String updateAt) {
        this.id = id;
        this.hoten = hoten;
        this.quequan = quequan;
        this.hinhanh = hinhanh;
        this.diem = diem;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
