package com.example.evandro.msports;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;


public class Detalhe extends ActionBarActivity {

    public void calculaTotal(View view) {
        TextView nomeProd = (TextView)findViewById((R.id.nome));
        String nome = nomeProd.getText().toString();

        TextView precoProd = (TextView)findViewById(R.id.preco);
        String preco = precoProd.getText().toString();
        preco = preco.replace("R$","");
        preco = preco.replace(",",".");
        Double valor = Double.parseDouble(preco);

        final Carrinho carrinho = (Carrinho) getApplicationContext();
        carrinho.setNomes(nome);
        carrinho.setTotal(valor);

        Toast msg = Toast.makeText(this, "Compra efetuada com sucesso!", Toast.LENGTH_SHORT);
        msg.show();

        Intent it = new Intent(this, TelaInicial.class);
        startActivity(it);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        Intent it = getIntent();
        if(it != null) {
            Bundle params = it.getExtras();
            if(params != null) {
                String nome = params.getString("nome");
                TextView nomeProd = (TextView)findViewById(R.id.nome);
                nomeProd.setText(nome);

                Double preco = params.getDouble("preco");
                TextView precoProd = (TextView)findViewById(R.id.preco);
                precoProd.setText("R$" + String.format( "%.2f", preco));

                String descricao = "";
                TextView descProd = (TextView)findViewById(R.id.descricao);

                Integer img = params.getInt("img");
                ImageView imgProd = (ImageView)findViewById(R.id.img);
                switch (img) {
                    case 0:
                        imgProd.setImageResource(R.drawable.prod1);
                        descricao = "Faça exercícios físicos sem sair de casa com a Bicicleta Ergométrica Oxer Spinning OXS -1300. Possui a qualidade Oxer com design anatômico que oferece mais conforto e qualidade para sua atividade. Com ela você pode regular a intensidade do seu próprio exercício, se adequando ao seu limite e melhorando seu condicionamento físico ao longo do tempo. Garanta a companheira ideal para uma rotina saudável!";
                        break;
                    case 1:
                        imgProd.setImageResource(R.drawable.prod2);
                        descricao = "Material: Em madeira; estrutura dos pés em madeira: tampo em MDF revestido com tecido poliéster\nPeso Aproximado: 57 Kg\nDimensões do Produto (C x L x A): 187 cm x 108 cm x 78 cm\nMedidas Internas: 165 cm x 86 cm";
                        break;
                    case 2:
                        imgProd.setImageResource(R.drawable.prod3);
                        descricao = "Esta é a excepcional Mesa de Tênis de Mesa Klopf Olim 1013 15 mm desmontável com medidas oficiais que atendem aos padrões da ITTF (International Table Tennis Federation). Seu tampo em MDP apresenta ótimo acabamento em massa e primer azul com linhas demarcatórias brancas, com pés de madeira maciça dobráveis. Aproveite!";
                        break;
                    case 3:
                        imgProd.setImageResource(R.drawable.prod4);
                        descricao = "Conheça o Skate X7 Spitfire!\nFeito de lâmina de madeira resistente, o Skate X7 Spitfire vai fazer a cabeça de todos aqueles que gostam de segurança e estilo durante as manobras radicais e ainda possui uma base antiderrapante. Aproveite!";
                        break;
                    case 4:
                        imgProd.setImageResource(R.drawable.prod5);
                        descricao = "O Saco de Pancada Punch 120 cm é ideal para a utilização em academias e para todo tipo de treino em saco de pancada. Além disso, ele aperfeiçoa o treinamento de chutes e socos e traz mais flexibilidade e agilidade para você.  Adquira o seu ainda hoje!";
                        break;
                    case 5:
                        imgProd.setImageResource(R.drawable.prod6);
                        descricao = "A Chuteira Society Umbro Attack 2014 é uma ótima opção para deixar suas partidas de futebol society ainda mais decisivas, permitindo desempenho diferenciado. Seu solado é confeccionado em borracha Non Marking com 360 Zone, auxiliando nos movimentos com travas que otimizam a tração durante a passada. Compre já a sua!";
                        break;
                    case 6:
                        imgProd.setImageResource(R.drawable.prod7);
                        descricao = "Se você é apaixonado pelo Merengue e não perde nenhum lance do seu time de coração, a Camisa Adidas Real Madrid I 2014-2015 s/ nº é a pedida certa para você. Ela traz mangas curtas e gola careca com fechamento em botões. Além disso, a peça apresenta a tecnologia Climacool, responsável por afastar o suor do torcedor, auxiliando a manter a sua temperatura corpórea ideal. Aproveite já para levar a sua para casa!";
                        break;
                    case 7:
                        imgProd.setImageResource(R.drawable.prod8);
                        descricao = "As Luvas de Goleiro Nike Vapor Grip 3 são perfeitas para que você tenha muito mais conforto na hora de defender seu time. Produzidas com materiais altamente resistentes, elas possuem a tecnologia Grip3, que garante maior aderência e controle. Aproveite agora!";
                        break;
                    case 8:
                        imgProd.setImageResource(R.drawable.prod9);
                        descricao = "A Bola de Campo Nike Team Training foi desenvolvida especialmente para todos que procuram mais controle e precisão durante o jogo. Com um design diferenciado e inovador, ela é confeccionada em material resistente que oferece mais eficiência, agilidade e rapidez para seus passes. Vale a pena conferir!";
                        break;
                    case 9:
                        imgProd.setImageResource(R.drawable.prod10);
                        descricao = "Para que os jogadores de Futebol tenham muito mais proteção, segurança e conforto dentro de campo, a Nike confeccionou a Caneleira Nike J Guard, que contém um tecido muito leve, macio e resistente, que garante a sua durabilidade.";
                        break;
                }
                descProd.setText(descricao);

            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalhe, menu);
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
        } else {
            if (id == R.id.home) {
                Intent redirectHome = new Intent(this, TelaInicial.class);
                startActivity(redirectHome);
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
