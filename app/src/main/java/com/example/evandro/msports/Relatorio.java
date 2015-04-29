package com.example.evandro.msports;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class Relatorio extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);

        final Carrinho carrinho = (Carrinho) getApplicationContext();
        Double valorTotal = carrinho.getTotal();
        List<String> nomesProd = carrinho.getNomes();

        TextView total = (TextView)findViewById(R.id.total);
        total.setText("R$" + String.format( "%.2f", valorTotal ));
        ListView nomes = (ListView)findViewById(R.id.nomes);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomesProd );
        nomes.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_relatorio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home) {
            Intent redirectHome = new Intent(this, TelaInicial.class);
            startActivity(redirectHome);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
