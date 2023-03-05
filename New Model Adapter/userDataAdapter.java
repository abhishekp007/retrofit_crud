package com.example.retrofit_crud.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofit_crud.Model.userDataModel;
import com.example.retrofit_crud.R;

import java.util.List;

public class userDataAdapter extends RecyclerView.Adapter<userDataAdapter.myviewholder> {

    List<userDataModel.User> data;
    Context context;

    public userDataAdapter(List<userDataModel.User> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_data_design,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.job.setText(data.get (position).getJob());
        Glide.with(holder.image.getContext()).load(data.get(position).getImglink()).error(R.drawable.noimagefound).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView image;

        TextView name,job;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.show_data_imgLink);
            name = itemView.findViewById(R.id.show_data_txtName);
            job = itemView.findViewById(R.id.show_data_txtJob);
        }
    }
}
