package com.example.retrofit_crud.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofit_crud.Model.userModel;
import com.example.retrofit_crud.R;
import com.example.retrofit_crud.SelectListener;

import java.util.List;

import retrofit2.Callback;

public class userAdapter extends RecyclerView.Adapter<userAdapter.userviewholder>{

    List<userModel> data;
    Context context;

    public userAdapter(List<userModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public userviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_data_design,parent,false);
        return new userviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userviewholder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.job.setText(data.get (position).getJob());
        Glide.with(holder.image.getContext()).load(data.get(position).getImglink()).error(R.drawable.noimagefound).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class userviewholder extends RecyclerView.ViewHolder
    {
        ImageView image;

        TextView name,job;
        CardView CardView;

        public userviewholder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.show_data_imgLink);
            name = itemView.findViewById(R.id.show_data_txtName);
            job = itemView.findViewById(R.id.show_data_txtJob);
            CardView = itemView.findViewById(R.id.CardView);
        }
    }


}
