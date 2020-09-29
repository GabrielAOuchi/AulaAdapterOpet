package com.example.adaptercustomizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ProdutoAdapter extends ArrayAdapter<Produto> {

    int rId;

    public ProdutoAdapter(Context context, int resource, List<Produto> objects) {
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mView = convertView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId,null);
        }

        Produto produto = getItem(position);

        TextView textNome = mView.findViewById(R.id.textNomeProduto);
        TextView textQtde = mView.findViewById(R.id.textQtdeProduto);

        textNome.setText(produto.getNome());
        textQtde.setText(String.valueOf(produto.getQuantidade()));
        if(produto.getQuantidade() > 10)
            textQtde.setTextColor(getContext().getResources().getColor(R.color.estoque_ok));
        else
            textQtde.setTextColor(getContext().getResources().getColor(R.color.estoque_baixo));

        return mView;
    }
}
