package com.example.evandro.msports;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Evandro on 26/04/2015.
 */
public class ListCell extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] nome;
    private final Double[] preco;
    private final Integer[] imageId;

    public ListCell(Activity context, String[] nome, Double[] preco, Integer[] imageId) {
        super(context, R.layout.list_cell, nome);
        this.context = context;
        this.nome = nome;
        this.preco = preco;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_cell, null, true);
        TextView nomeProd = (TextView)rowView.findViewById(R.id.nome);
        TextView precoProd = (TextView)rowView.findViewById(R.id.preco);
        ImageView imageView = (ImageView)rowView.findViewById(R.id.img);
        nomeProd.setText(nome[position]);
        precoProd.setText("R$" + String.format( "%.2f", preco[position] ));
        imageView.setImageResource(imageId[position]);
        return rowView;
    }

}
