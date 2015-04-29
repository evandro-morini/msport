package com.example.evandro.msports;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evandro on 28/04/2015.
 */
public class Carrinho extends Application{
    private List<String> nomes = new ArrayList<String>();
    private Double total = 0.0;

    public List getNomes() {
        return nomes;
    }

    public void setNomes(String nome) {
        nomes.add(nome);
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double preco) {
        total += preco;
    }
}
