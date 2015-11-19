package com.android.giovani.list;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main_Activity extends AppCompatActivity {
    public static ArrayList<String> nomes = new ArrayList<>();
    EditText edit;
    Button btn;
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_);

        edit= (EditText) findViewById(R.id.xEdit);
        btn =(Button) findViewById(R.id.xBtn);
        list =(ListView) findViewById(R.id.xList);

        final   ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,nomes);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int achou = 0;

                if (edit.getText().toString().isEmpty()) {
                    AlertDialog.Builder dialago = new AlertDialog.Builder(Main_Activity.this);
                    dialago.setTitle("MENSAGEM");
                    dialago.setMessage("VAZIO");
                    dialago.setNeutralButton("OK", null);
                    dialago.show();
                    achou = 1;
                }
                if (!edit.getText().toString().isEmpty()) {
                    for (int i = 0; i < nomes.size(); i++) {
                        if (edit.getText().toString().equals(nomes.get(i))) {
                            AlertDialog.Builder dialago = new AlertDialog.Builder(Main_Activity.this);
                            dialago.setTitle("MENSAGEM");
                            dialago.setMessage(" EXISTEM NOMES IGUAIS");
                            dialago.setNeutralButton("OK", null);
                            dialago.show();
                            achou = 1;

                        }
                    }
                    if (edit.getText().toString().length() < 3) {
                        AlertDialog.Builder dialago = new AlertDialog.Builder(Main_Activity.this);
                        dialago.setTitle("MENSAGEM");
                        dialago.setMessage("NAO ADICIONADO NUMERO DE CARACTERES MENORES QUE 3");
                        dialago.setNeutralButton("OK", null);
                        dialago.show();
                        achou = 1;
                    }
                    if (achou == 0) {
                        nomes.add(edit.getText().toString().toLowerCase());
                        list.setAdapter(adapter);
                        edit.setText("");
                    }
                    if (achou == 1) {
                        AlertDialog.Builder dialago = new AlertDialog.Builder(Main_Activity.this);
                        dialago.setTitle("MENSAGEM");
                        dialago.setMessage("NAO ADICIONADO");
                        dialago.setNeutralButton("OK", null);
                        dialago.show();
                    }
                }
            }




    });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valor = (String) parent.getAdapter().getItem(position);
                list.setAdapter(adapter);
                Toast.makeText(Main_Activity.this, valor, Toast.LENGTH_SHORT).show();


                int p = nomes.indexOf(valor);
                Intent intecao = new Intent(Main_Activity.this, AlterarNome.class);
                intecao.putExtra("id", p);
                startActivity(intecao);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        final   ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,nomes);
        list.setAdapter(adapter);
    }
}