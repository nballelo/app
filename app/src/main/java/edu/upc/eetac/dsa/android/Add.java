package edu.upc.eetac.dsa.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
    public void add(View view){
        Intent intent=getIntent();
        EditText nombre=(EditText)findViewById(R.id.editText3);
        EditText lvl=(EditText)findViewById(R.id.editText4);
        Eetackemon eetackemon=new Eetackemon(nombre.getText().toString(), Integer.parseInt(lvl.getText().toString()));
        intent.putExtra("addEetakemon",(Serializable)eetackemon);
        setResult(RESULT_OK,getIntent());
        finish();
    }
}
