package com.example.aulaadapteropet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textLista;
    ListView listaString;
    EditText editFruta;
    List<String> lista;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLista = findViewById(R.id.textLista);
        listaString = findViewById(R.id.listString);
        editFruta = findViewById(R.id.editFruta);
        lista = new ArrayList<>();
        preencherTextLista();
        preencherListString();

        listaString.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String fruta = (String)adapterView.getItemAtPosition(i);
                Toast.makeText(MainActivity.this, fruta, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void novaFruta(View view) {
        String fruta = editFruta.getText().toString();
        lista.add(0,fruta);
        editFruta.setText("");
        adapter.notifyDataSetChanged();
    }

    private void preencherListString(){
        int layoutId = android.R.layout.simple_list_item_1;

        adapter = new ArrayAdapter<String>(this,layoutId,lista);

        listaString.setAdapter(adapter);
    }

    private void preencherTextLista(){
        lista.add("Maçã");
        lista.add("Uva");
        lista.add("Goiaba");

        String dados = "";

        for(String info : lista){
            dados += info + "\n";
        }

        textLista.setText(dados);
    }

}