package com.android.giovani.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlterarNome extends AppCompatActivity {

    EditText editUpdate;
    Button btdUp;
    Button btdDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_nome);
        editUpdate =(EditText) findViewById(R.id.xUpd);
        btdUp =(Button) findViewById(R.id.xBtnU);
        btdDel = (Button) findViewById(R.id.xBtnD);

        final Bundle extras = getIntent().getExtras();
        final  int id = extras.getInt("id");
        editUpdate.setText(Main_Activity.nomes.get(id).toString());


        btdUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String novoNome = editUpdate.getText().toString();
                Main_Activity.nomes.set(id, novoNome);
                onBackPressed();
            }
        });



        btdDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main_Activity.nomes.remove(id);
                onBackPressed();

            }
        });
    }


}