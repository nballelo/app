package edu.upc.eetac.dsa.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Listar extends AppCompatActivity {
    List<Eetackemon>eetackemons;
    List<String>nombres=new ArrayList<String>();
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        user=(User)getIntent().getSerializableExtra("User");
        eetackemons=user.getEetackemons();
        for (int i=0;i<eetackemons.size();i++){
            nombres.add(eetackemons.get(i).getName());
        }
        ArrayAdapter adapter=new ArrayAdapter(Listar.this,android.R.layout.simple_list_item_1, nombres);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Listar.this,Description.class);
                intent.putExtra("Eetakemon",(Serializable)eetackemons.get(position) );
                startActivity(intent);
            }
        });
    }
}
