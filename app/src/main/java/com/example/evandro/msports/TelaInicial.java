package com.example.evandro.msports;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class TelaInicial extends ActionBarActivity {
    Double total = 0.0;
    ListView list;
    String[] nome = {
            "Bicicleta Spinning Oxer OXS1300",
            "Mesa de Sinuca Procópio 187 X 108",
            "Mesa de Tênis de Mesa Klopf Olim",
            "Skate X7 Spitfire",
            "Saco de Pancada Punch 120 cm",
            "Chuteira Society Umbro Attack",
            "Camisa adidas Real Madrid I 2014",
            "Luvas de Goleiro Nike Vapor Grip",
            "Bola de Futebol Nike Team Training",
            "Caneleira Nike J Guard (Adulto)",
    };

    Double[] preco = {
            1099.99,
            849.99,
            369.99,
            99.99,
            199.99,
            119.99,
            219.90,
            199.90,
            34.90,
            24.90,
    };

    Integer[] imageId = {
            R.drawable.prod1,
            R.drawable.prod2,
            R.drawable.prod3,
            R.drawable.prod4,
            R.drawable.prod5,
            R.drawable.prod6,
            R.drawable.prod7,
            R.drawable.prod8,
            R.drawable.prod9,
            R.drawable.prod10,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        Intent it = getIntent();
        if(it != null) {
            Bundle params = it.getExtras();
            if (params != null) {
                total = params.getDouble("total");
            }
        }
        ListCell adapter = new ListCell(TelaInicial.this, nome, preco, imageId);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                Bundle params = new Bundle();
                params.putString("nome", nome[position].toString());
                params.putDouble("preco", preco[position]);
                params.putInt("img", position);
                params.putDouble("total", total);

                intent = new Intent(getBaseContext(), Detalhe.class);
                intent.putExtras(params);
                startActivityForResult(intent, 1);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_inicial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.relatorio) {
            Intent redirectRelatorio = new Intent(this, Relatorio.class);
            startActivity(redirectRelatorio);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
