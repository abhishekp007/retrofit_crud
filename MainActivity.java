package com.example.retrofit_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.retrofit_crud.Adapter.userAdapter;
import com.example.retrofit_crud.Model.userModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText txt_name, txt_job, txt_imglink;
    Button btn_save;
    RecyclerView rvList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {


            txt_name = findViewById(R.id.txt_name);
            txt_job = findViewById(R.id.txt_job);
            txt_imglink = findViewById(R.id.txt_imglink);
            btn_save = findViewById(R.id.btn_save);
            rvList = findViewById(R.id.rvList);
            rvList.setLayoutManager(new LinearLayoutManager(this));


            getAllUsers();


            btn_save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String name = txt_name.getText().toString();
                    String job = txt_job.getText().toString();
                    String imglink = txt_imglink.getText().toString();

                    if (name.isEmpty() || job.isEmpty() || imglink.isEmpty()) {
                        Toast.makeText(MainActivity.this, "All Are Filed Requied", Toast.LENGTH_SHORT).show();
                    } else {
//                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        AddUser(name, job, imglink);
                    }
                }
            });
        } catch (Exception ex) {
            Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show();
        }

    }

    private void AddUser(String name, String job, String imglink) {

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BaseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        userApiService userApiService = retrofit.create(com.example.retrofit_crud.userApiService.class);

//        Call<userModel> userModelCall = userApiService.addUser(name, job, imglink);

        Call<userModel> userModelCall = userApiController.getInstance().getuserApiService().addUser(name,job,imglink);
        userModelCall.enqueue(new Callback<userModel>() {
            @Override
            public void onResponse(Call<userModel> call, Response<userModel> response) {

                if (response.isSuccessful()) {
                    txt_name.setText("");
                    txt_job.setText("");
                    txt_imglink.setText("");
                    Toast.makeText(MainActivity.this, "User Data Successfully Added.", Toast.LENGTH_SHORT).show();
                    getAllUsers();

                }

            }

            @Override
            public void onFailure(Call<userModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void getAllUsers() {
        Call<List<userModel>> call = userApiController.getInstance().getuserApiService().getUser();

        call.enqueue(new Callback<List<userModel>>() {
            @Override
            public void onResponse(Call<List<userModel>> call, Response<List<userModel>> response) {

                try {
                    List<userModel> data = response.body();
                    userAdapter userAdapter = new userAdapter(data);
                    rvList.setAdapter(userAdapter);
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<List<userModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}