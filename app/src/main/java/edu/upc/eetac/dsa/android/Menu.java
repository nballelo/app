package edu.upc.eetac.dsa.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Menu extends AppCompatActivity {
    User user;
    Retrofit retrofit;
    Service service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        TextView nombre=(TextView)findViewById(R.id.textView);
        user=(User)getIntent().getSerializableExtra("User");
        nombre.setText(user.getName());
        retrofit=new Retrofit.Builder().baseUrl(Service.URL).addConverterFactory(GsonConverterFactory.create()).build();;
        service=retrofit.create(Service.class);

    }
    public void Listar(View view){
        Call<List<String>> call =service.eetakemons(user.getName());
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                List<String> s=new ArrayList<String>();
                s=response.body();
                Intent intent=new Intent(Menu.this,Listar.class);
                intent.putExtra("User",(Serializable)user);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
            }
        });
    }
    public void Add(View view){
        Intent intent=new Intent(Menu.this,Add.class);
        startActivityForResult(intent,100);

    }
    protected void onActivityResult(int requestCode,int resultCode,Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        Eetackemon eetackemon=(Eetackemon) intent.getExtras().get("addEetakemon");
        Call<String> call =service.setEetakemon(user.getName().toString(),eetackemon);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(Menu.this,response.body(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(Menu.this,"Fallo",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
