package com.example.afgetapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Afmodel> afmodel;
    Retrofit retrofit;
    AdapterAf adapterAf;
    RecyclerView recyclerView;
    int count;
Button b1 ,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
b1 =findViewById(R.id.button);
b2 =findViewById(R.id.buttonback);

        fun();
        progress();

    }
    void fun(){
        recyclerView = findViewById(R.id.recycler);
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl("https://phplaravel-882494-3459554.cloudwaysapps.com/").addConverterFactory(GsonConverterFactory.create()).build();

        }
        RetrofitAf retrofitAf = retrofit.create(RetrofitAf.class);
        Call<List<Afmodel>> request = retrofitAf.getaf();
        request.enqueue(new Callback<List<Afmodel>>() {
            @Override
            public void onResponse(Call<List<Afmodel>> call, Response<List<Afmodel>> response) {
                afmodel=response.body();
                adapterAf = new AdapterAf(MainActivity.this, response.body().subList(0,10));
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(adapterAf);
                b2.setVisibility(View.GONE);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    if (count==0) {
                        adapterAf = new AdapterAf(MainActivity.this, response.body().subList(10,20));
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(adapterAf);
                        count++;
                        b2.setVisibility(View.VISIBLE);
                        b2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                adapterAf = new AdapterAf(MainActivity.this, response.body().subList(0,10));
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                                recyclerView.setLayoutManager(linearLayoutManager);
                                recyclerView.setAdapter(adapterAf);
                                b1.setVisibility(View.VISIBLE);
                                count=0;
                            }
                        });

                    } else if (count==1) {
                        adapterAf = new AdapterAf(MainActivity.this, response.body().subList(20,21));
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(adapterAf);
                        b1.setVisibility(View.GONE);
                        b2.setVisibility(View.VISIBLE);
                       count=1;
                        b2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                adapterAf = new AdapterAf(MainActivity.this, response.body().subList(10,20));
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                                recyclerView.setLayoutManager(linearLayoutManager);
                                recyclerView.setAdapter(adapterAf);
                                b1.setVisibility(View.VISIBLE);
                                count=1;
                            }
                        });

                    }

                    }
                });
                Log.d("TAG", "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<List<Afmodel>> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());

            }
        });
    }
    public void progress()
    {
        getSupportActionBar().hide();
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        progressDialog.setTitle("Afsale");
        progressDialog.create();
        progressDialog.show();
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        },2500);
    }
    void  next(){
        afmodel.subList(10,20);
        adapterAf.notifyDataSetChanged();
    }
}

