package com.example.namntph36893_ph36893_thi_and103.services;



import com.example.namntph36893_ph36893_thi_and103.Model.Response_Model;
import com.example.namntph36893_ph36893_thi_and103.Model.SinhVien;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiServices {


    public static String BASE_URL = "http://10.0.2.2:3000/api/";

    //Annotations @GET cho method GET và url phương gọi

    @GET("get-list-sinhvien")
    Call<Response_Model<ArrayList<SinhVien>>> getListSinhViens();
    //Call giá trị trả về của api

    @POST("add-sinhvien")
    Call<Response_Model<SinhVien>> addSinhViens(@Body SinhVien sinhVien);

    //Param url sẽ bỏ vào {}
    @DELETE("delete-sinhvien-by-id/{id}")
    Call<Response_Model<SinhVien>> deleteSinhViensById(@Path("id") String id);

    @PUT("update-sinhvien-by-id/{id}")
    Call<Response_Model<SinhVien>> updateSinhViensById(@Path("id") String id, @Body SinhVien sinhVien);



}
