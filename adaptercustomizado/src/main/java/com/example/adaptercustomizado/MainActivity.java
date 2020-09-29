package com.example.adaptercustomizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listViewProduto;
    List<Produto> produtos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewProduto = findViewById(R.id.listViewProdutos);
        produtos = new ArrayList<>();

        listViewProduto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Produto produto = (Produto)adapterView.getItemAtPosition(i);
                String info = "Quantidade em estoque de " + produto.getNome() + " = ";
                info += produto.getQuantidade();
                Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        produtos.add(new Produto("Lapis",20));
        produtos.add(new Produto("Caneta",5));
        produtos.add(new Produto("Borracha",50));
        produtos.add(new Produto("Apontador",7));

        preencherListViewProdutos();
    }

    private void preencherListViewProdutos(){
        int layout_id = R.layout.produto_list_item;
        ProdutoAdapter adapter = new ProdutoAdapter(this,layout_id,produtos);

        listViewProduto.setAdapter(adapter);
    }
}
