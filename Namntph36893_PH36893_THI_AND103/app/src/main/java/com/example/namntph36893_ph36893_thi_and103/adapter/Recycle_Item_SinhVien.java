package com.example.namntph36893_ph36893_thi_and103.adapter;


import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.namntph36893_ph36893_thi_and103.Model.SinhVien;
import com.example.namntph36893_ph36893_thi_and103.R;
import com.example.namntph36893_ph36893_thi_and103.handle.Item_SinhVien_Handle;
import com.example.namntph36893_ph36893_thi_and103.services.HttpRequest;

import java.util.ArrayList;

public class Recycle_Item_SinhVien extends RecyclerView.Adapter<Recycle_Item_SinhVien.viewHolep>{
    private Context context;
    private ArrayList<SinhVien> list;
    private Item_SinhVien_Handle handle;
    private HttpRequest httpRequest;

    public Recycle_Item_SinhVien(Context context, ArrayList<SinhVien> list, Item_SinhVien_Handle handle) {
        this.context = context;
        this.list = list;
        this.handle = handle;
    }

    @NonNull
    @Override
    public viewHolep onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle, parent, false);
        return new viewHolep(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolep holder, int position) {
        httpRequest = new HttpRequest();
        SinhVien sinhVien = list.get(position);
        holder.txtHoten.setText(sinhVien.getHoten());
        holder.txtDiem.setText(String.valueOf(sinhVien.getDiem()));
        holder.txtQueQuan.setText(sinhVien.getQuequan());

        holder.img_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Bạn có muốn xoá không")
                        .setCancelable(false)
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                handle.Delete(sinhVien.getId());
                                Toast.makeText(context, "Xoá Thành Công", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                builder.create().show();
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                handle.Update(sinhVien.getId(), sinhVien);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolep extends RecyclerView.ViewHolder {
        TextView txtHoten, txtQueQuan, txtDiem;
        ImageView imgHinhAnh,img_Delete;

        public viewHolep(@NonNull View itemView) {
            super(itemView);
            txtHoten = itemView.findViewById(R.id.txtHoten);
            txtQueQuan= itemView.findViewById(R.id.txtQueQuan);
            txtDiem = itemView.findViewById(R.id.txtDiem);
            img_Delete = itemView.findViewById(R.id.img_delete);
            imgHinhAnh = itemView.findViewById(R.id.imgHinhAnh);
        }
    }
}
