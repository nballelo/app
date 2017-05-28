package edu.upc.eetac.dsa.android;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.*;
import retrofit2.http.*;
import retrofit2.Retrofit;

public class LogIn extends AppCompatActivity {
    User user;
    Retrofit retrofit;
    Service service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        retrofit = new Retrofit.Builder().baseUrl(Service.URL).addConverterFactory(GsonConverterFactory.create()).build();
        service = retrofit.create(Service.class);
    }
    public void LogIn(View view) {
        try{
            EditText name=(EditText) findViewById(R.id.editText);
            EditText pass=(EditText) findViewById(R.id.editText2);
            user=new User(name.getText().toString(),pass.getText().toString());
            Call<User> callUser =service.login(user);
            callUser.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    user=response.body();
                    if(user!=null){
                    Intent intent=new Intent(LogIn.this,Menu.class);
                    intent.putExtra("User",(Serializable)user);
                    startActivity(intent);
                    }
                    else {
                        Toast.makeText(LogIn.this,"Usuario no registrado",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(LogIn.this,"FALLO",Toast.LENGTH_SHORT).show();
                }
            });
            }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void SingIn(View view){
        EditText name=(EditText) findViewById(R.id.editText);
        EditText pass=(EditText) findViewById(R.id.editText2);
        user=new User(name.getText().toString(),pass.getText().toString());
        Call<User> singin=service.sinin(user);
        singin.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user=response.body();
                if(user!=null){
                    Intent intent=new Intent(LogIn.this,Menu.class);
                    intent.putExtra("User",(Serializable)user);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LogIn.this,"Usuario no se pudo registrar",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LogIn.this,"FALLO",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
