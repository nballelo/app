package edu.upc.eetac.dsa.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Description extends AppCompatActivity {
Eetackemon eetackemon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        eetackemon=(Eetackemon)getIntent().getSerializableExtra("Eetakemon");
        TextView nombre=(TextView)findViewById(R.id.textView2);
        TextView lvl=(TextView)findViewById(R.id.textView3);
        nombre.setText("nombre: "+eetackemon.getName());
        lvl.setText("lvl:"+String.valueOf(eetackemon.getLvl()));
    }
    @Override
    public void onBackPressed(){
        finish();
    }
}
