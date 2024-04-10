package com.example.namntph36893_ph36893_thi_and103;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.namntph36893_ph36893_thi_and103.Model.Response_Model;
import com.example.namntph36893_ph36893_thi_and103.Model.SinhVien;
import com.example.namntph36893_ph36893_thi_and103.adapter.Recycle_Item_SinhVien;
import com.example.namntph36893_ph36893_thi_and103.handle.Item_SinhVien_Handle;
import com.example.namntph36893_ph36893_thi_and103.services.HttpRequest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Item_SinhVien_Handle {
    private HttpRequest httpRequest;
    private Recycle_Item_SinhVien adapterSinhVien;
    private RecyclerView rcvStudents;
    private ArrayList<SinhVien> originList;
    private ArrayList<SinhVien> displayList;
    FloatingActionButton btn_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvStudents = findViewById(R.id.rcv_sinhvien);
        btn_add = findViewById(R.id.btn_add);
        httpRequest = new HttpRequest();
        httpRequest.callApi().getListSinhViens().enqueue(getSinhVienAPI);
    }
    private void getData(ArrayList<SinhVien> list) {
        adapterSinhVien = new Recycle_Item_SinhVien(this, list, this);
        rcvStudents.setLayoutManager(new LinearLayoutManager(this));
        rcvStudents.setAdapter(adapterSinhVien);
    }
    Callback<Response_Model<ArrayList<SinhVien>>> getSinhVienAPI = new Callback<Response_Model<ArrayList<SinhVien>>>() {
        @Override
        public void onResponse(Call<Response_Model<ArrayList<SinhVien>>> call, Response<Response_Model<ArrayList<SinhVien>>> response) {
            if (response.isSuccessful()) {

                if (response.body().getStatus() == 200) {
                    ArrayList<SinhVien> list = response.body().getData();
                    Log.d("List", "onResponse: " + list);
                    getData(list);

                }
            }
        }

        @Override
        public void onFailure(Call<Response_Model<ArrayList<SinhVien>>> call, Throwable t) {
            Log.d(">>>GETLIST", "onFailure: " + t.getMessage());
        }
    };
    Callback<Response_Model<SinhVien>> responseSingVienAPI = new Callback<Response_Model<SinhVien>>() {
        @Override
        public void onResponse(Call<Response_Model<SinhVien>> call, Response<Response_Model<SinhVien>> response) {
            if (response.isSuccessful()) {
                if (response.body().getStatus() == 200) {
                    httpRequest.callApi().getListSinhViens().enqueue(getSinhVienAPI);
                }
            }
        }

        @Override
        public void onFailure(Call<Response_Model<SinhVien>> call, Throwable t) {
            Log.d(">>>GESTLIST", "onFailure: " + t.getMessage());
        }
    };
    @Override
    public void Delete(String id) {

    }

    @Override
    public void Update(String id, SinhVien sinhVien) {

    }
}