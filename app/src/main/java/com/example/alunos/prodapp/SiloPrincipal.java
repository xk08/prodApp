package com.example.alunos.prodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import util.Contexto;

public class SiloPrincipal extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView3;
    private Toolbar toolbar1;
    private Toolbar toolbar2;
    private Toolbar toolbar3;
    private Toolbar toolbar4;
    private Toolbar toolbar5;
    private Toolbar toolbar6;
    private Toolbar toolbar7;
    private Toolbar toolbar8;
    private Toolbar toolbar9;
    private Toolbar toolbar10;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private TextView textViewNomeSilo;

    private ImageView imageViewDetalhes;
    private ImageView imageViewAdicionar;
    private ImageView imageViewRemover;

    private LinearLayout LinearLayoutAdicionar1;
    private LinearLayout LinearLayoutAdicionar2;
    private LinearLayout LinearLayoutRemover1;
    private LinearLayout LinearLayoutRemover2;

    private Button buttonDetalhe;
    private Button buttonRemover;

    private EditText pegaValorInformado;
    private EditText tiraValorInformado ;
    private Button botaoAdicionar;
    private String teste;
    private boolean testeVisivelAdicionar;
    private boolean testeVisivelRemover;
    private double QuantidadeDoubleConvertido;

    double pegaPositivo = 0;
    double pegaNegativo = 0;
    double somaPositivo = 0 ;
    double somaNegativo = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silo_principal);

        imageView3 = (ImageView) findViewById(R.id.imageView3);
        toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
        toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        toolbar3 = (Toolbar) findViewById(R.id.toolbar3);
        toolbar4 = (Toolbar) findViewById(R.id.toolbar4);
        toolbar5 = (Toolbar) findViewById(R.id.toolbar5);
        toolbar6 = (Toolbar) findViewById(R.id.toolbar6);
        toolbar7 = (Toolbar) findViewById(R.id.toolbar7);
        toolbar8 = (Toolbar) findViewById(R.id.toolbar8);
        toolbar9 = (Toolbar) findViewById(R.id.toolbar9);
        toolbar10 = (Toolbar) findViewById(R.id.toolbar10);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textViewNomeSilo = (TextView) findViewById(R.id.textViewNomeSilo);
        imageViewDetalhes = (ImageView) findViewById(R.id.imageViewDetalhes);
        imageViewAdicionar = (ImageView) findViewById(R.id.imageViewAdicionar);
        imageViewRemover = (ImageView) findViewById(R.id.imageViewRemover);
        LinearLayoutAdicionar1 = (LinearLayout) findViewById(R.id.LinearLayoutAdicionar1);
        LinearLayoutRemover1 = (LinearLayout) findViewById(R.id.LinearLayoutRemover1);
        buttonRemover = (Button) findViewById(R.id.buttonRemover);

        pegaValorInformado = (EditText) findViewById(R.id.pegaValorInformado);
        tiraValorInformado = (EditText) findViewById(R.id.tiraValorInformado) ;
        botaoAdicionar = (Button) findViewById(R.id.botaoAdicionar);

        imageViewDetalhes.setOnClickListener(this);
        imageViewAdicionar.setOnClickListener(this);
        imageViewRemover.setOnClickListener(this);

        botaoAdicionar.setOnClickListener(this);
        buttonRemover.setOnClickListener(this);
        imageViewDetalhes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(SiloPrincipal.this, TelaDeDetalhesDoSilo.class);
                startActivity(i);
                finish();
            }
        });
        textViewNomeSilo.setText("");
        textViewNomeSilo.setText(Contexto.dados.get("nomeDoSilo") + "");

        testeVisivelAdicionar = true;
        testeVisivelRemover = true;

        double valorFinalPego = somaPositivo - somaNegativo;
        Contexto.dados.put("EnviandoDouble", valorFinalPego);

        // Transformando num objeto do tipo context apenas para manter o valor ativo
        String pegaValorDoubleContext = Contexto.dados.get("EnviandoDouble").toString();
        double converteemDoubleValorDouble = Double.parseDouble(pegaValorDoubleContext);

        //Pegando o tamanho total do Silo
        String pegaValorTotal = Contexto.dados.get("tamanhoDoSilo").toString();
        double converteemDoubleValorTotal = Double.parseDouble(pegaValorTotal);

        //Calculo para achar a porcentagem
        double valorFinal = ((converteemDoubleValorDouble * 100) / converteemDoubleValorTotal);
    }

    @Override
    public void onClick(View v) {

        if (imageViewAdicionar.isPressed()) {
            if(testeVisivelAdicionar == true){
                LinearLayoutAdicionar1.setVisibility(View.VISIBLE);
                LinearLayoutRemover1.setVisibility(View.GONE);
                pegaValorInformado.setVisibility(View.VISIBLE);
                tiraValorInformado.setVisibility(View.VISIBLE);

                testeVisivelAdicionar = false;
                testeVisivelRemover = true;
            }else{
                LinearLayoutAdicionar1.setVisibility(View.GONE);
                LinearLayoutRemover1.setVisibility(View.GONE);
                pegaValorInformado.setVisibility(View.GONE);
                tiraValorInformado.setVisibility(View.GONE);

                testeVisivelAdicionar = true;
                testeVisivelRemover = true;
            }
        }
        if (imageViewRemover.isPressed()) {
            if(testeVisivelRemover == true){
                LinearLayoutRemover1.setVisibility(View.VISIBLE);
                LinearLayoutAdicionar1.setVisibility(View.GONE);
                pegaValorInformado.setVisibility(View.VISIBLE);
                tiraValorInformado.setVisibility(View.VISIBLE);

                testeVisivelRemover = false;
                testeVisivelAdicionar = true;
            }else{
                LinearLayoutRemover1.setVisibility(View.GONE);
                LinearLayoutAdicionar1.setVisibility(View.GONE);
                pegaValorInformado.setVisibility(View.GONE);
                tiraValorInformado.setVisibility(View.GONE);

                testeVisivelRemover = true;
                testeVisivelAdicionar = true;
            }
        }

        if (botaoAdicionar.isPressed()) {
            LinearLayoutAdicionar1.setVisibility(View.GONE);
            LinearLayoutRemover1.setVisibility(View.GONE);
            pegaValorInformado.setVisibility(View.GONE);
            tiraValorInformado.setVisibility(View.GONE);
            testeVisivelAdicionar = true;
            testeVisivelRemover = true;

            double valorConvertido = Double.valueOf(pegaValorInformado.getText().toString());
            pegaPositivo = valorConvertido;
            somaPositivo= somaPositivo + pegaPositivo ;
        }

        if (buttonRemover.isPressed()) {
            LinearLayoutRemover1.setVisibility(View.GONE);
            LinearLayoutAdicionar1.setVisibility(View.GONE);
            pegaValorInformado.setVisibility(View.GONE);
            tiraValorInformado.setVisibility(View.GONE);
            testeVisivelRemover = true;
            testeVisivelAdicionar = true;

            double valorConvertido = Double.valueOf(tiraValorInformado.getText().toString());
            pegaNegativo = valorConvertido;

            somaNegativo= somaNegativo + pegaNegativo ;
        }
        double valorFinalPego = somaPositivo - somaNegativo;
        Contexto.dados.put("EnviandoDouble", valorFinalPego);

        // Transformando num objeto do tipo context apenas para manter o valor ativo
        String pegaValorDoubleContext = Contexto.dados.get("EnviandoDouble").toString();
        double converteemDoubleValorDouble = Double.parseDouble(pegaValorDoubleContext);

        //Pegando o tamanho total do Silo
        String pegaValorTotal = Contexto.dados.get("tamanhoDoSilo").toString();
        double converteemDoubleValorTotal = Double.parseDouble(pegaValorTotal);

        //Calculo para achar a porcentagem
        double valorFinal = ((converteemDoubleValorDouble * 100) / converteemDoubleValorTotal);

        if (valorFinal == 0) {
            teste = "0";
        }
        if (valorFinal > 0 & valorFinal <= 10) {
            teste = "10";
        }

        if (valorFinal > 10 & valorFinal <= 20) {
            teste = "20";
        }

        if (valorFinal > 20 & valorFinal <= 30) {
            teste = "30";
        }

        if (valorFinal > 30 & valorFinal <= 40) {
            teste = "40";
        }

        if (valorFinal > 40 & valorFinal <= 50) {
            teste = "50";
        }

        if (valorFinal > 50 & valorFinal <= 60) {
            teste = "60";
        }

        if (valorFinal > 60 & valorFinal <= 70) {
            teste = "70";
        }

        if (valorFinal > 70 & valorFinal <= 80) {
            teste = "80";
        }

        if (valorFinal > 80 & valorFinal <= 90) {
            teste = "90";
        }
        if (valorFinal > 90 & valorFinal <= 100) {
            teste = "100";
        }

        if (valorFinal > 100) {
            Toast.makeText(getBaseContext(), "Voc?? informou um valor maior que o valor total do Silo !!!", Toast.LENGTH_LONG).show(); // mensagem ?? apenas temporaria.
        }


        switch (teste) {
            case "0":
                //setando a imagem de fundo, diferente a cada 10% com excess??o dos 90 e 100% que sao os mesmos...
                // ?? pra da uma sensa????o de que os toolbars est??o dentro o silo...
                imageView3.setImageResource(R.drawable.silo);

                //visibilidade referente aos toolbars contidos na activity...
                toolbar1.setVisibility(View.INVISIBLE);
                toolbar2.setVisibility(View.INVISIBLE);
                toolbar3.setVisibility(View.INVISIBLE);
                toolbar4.setVisibility(View.INVISIBLE);
                toolbar5.setVisibility(View.INVISIBLE);
                toolbar6.setVisibility(View.INVISIBLE);
                toolbar7.setVisibility(View.INVISIBLE);
                toolbar8.setVisibility(View.INVISIBLE);
                toolbar9.setVisibility(View.INVISIBLE);
                toolbar10.setVisibility(View.INVISIBLE);

                //visibilidade referente aos textviews contidos na activity, eles possuem a escrita da porcentagem...
                textView1.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.INVISIBLE);
                textView4.setVisibility(View.INVISIBLE);
                textView5.setVisibility(View.INVISIBLE);
                textView6.setVisibility(View.INVISIBLE);
                textView7.setVisibility(View.INVISIBLE);
                textView8.setVisibility(View.INVISIBLE);
                textView9.setVisibility(View.INVISIBLE);
                textView10.setVisibility(View.INVISIBLE);

                //parte que ta aqui so pra limpar o que foi ecrito no edittext, essa parte ?? dispensavel depois...
                pegaValorInformado.setText("");
                break;

            case "10":
                imageView3.setImageResource(R.drawable.silo10);

                toolbar1.setVisibility(View.VISIBLE);
                toolbar2.setVisibility(View.INVISIBLE);
                toolbar3.setVisibility(View.INVISIBLE);
                toolbar4.setVisibility(View.INVISIBLE);
                toolbar5.setVisibility(View.INVISIBLE);
                toolbar6.setVisibility(View.INVISIBLE);
                toolbar7.setVisibility(View.INVISIBLE);
                toolbar8.setVisibility(View.INVISIBLE);
                toolbar9.setVisibility(View.INVISIBLE);
                toolbar10.setVisibility(View.INVISIBLE);

                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.INVISIBLE);
                textView4.setVisibility(View.INVISIBLE);
                textView5.setVisibility(View.INVISIBLE);
                textView6.setVisibility(View.INVISIBLE);
                textView7.setVisibility(View.INVISIBLE);
                textView8.setVisibility(View.INVISIBLE);
                textView9.setVisibility(View.INVISIBLE);
                textView10.setVisibility(View.INVISIBLE);

                pegaValorInformado.setText("");
                break;

            case "20":
                imageView3.setImageResource(R.drawable.silo20);

                toolbar1.setVisibility(View.VISIBLE);
                toolbar2.setVisibility(View.VISIBLE);
                toolbar3.setVisibility(View.INVISIBLE);
                toolbar4.setVisibility(View.INVISIBLE);
                toolbar5.setVisibility(View.INVISIBLE);
                toolbar6.setVisibility(View.INVISIBLE);
                toolbar7.setVisibility(View.INVISIBLE);
                toolbar8.setVisibility(View.INVISIBLE);
                toolbar9.setVisibility(View.INVISIBLE);
                toolbar10.setVisibility(View.INVISIBLE);

                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.INVISIBLE);
                textView4.setVisibility(View.INVISIBLE);
                textView5.setVisibility(View.INVISIBLE);
                textView6.setVisibility(View.INVISIBLE);
                textView7.setVisibility(View.INVISIBLE);
                textView8.setVisibility(View.INVISIBLE);
                textView9.setVisibility(View.INVISIBLE);
                textView10.setVisibility(View.INVISIBLE);

                pegaValorInformado.setText("");
                break;

            case "30":
                imageView3.setImageResource(R.drawable.silo30);

                toolbar1.setVisibility(View.VISIBLE);
                toolbar2.setVisibility(View.VISIBLE);
                toolbar3.setVisibility(View.VISIBLE);
                toolbar4.setVisibility(View.INVISIBLE);
                toolbar5.setVisibility(View.INVISIBLE);
                toolbar6.setVisibility(View.INVISIBLE);
                toolbar7.setVisibility(View.INVISIBLE);
                toolbar8.setVisibility(View.INVISIBLE);
                toolbar9.setVisibility(View.INVISIBLE);
                toolbar10.setVisibility(View.INVISIBLE);

                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.INVISIBLE);
                textView5.setVisibility(View.INVISIBLE);
                textView6.setVisibility(View.INVISIBLE);
                textView7.setVisibility(View.INVISIBLE);
                textView8.setVisibility(View.INVISIBLE);
                textView9.setVisibility(View.INVISIBLE);
                textView10.setVisibility(View.INVISIBLE);
                pegaValorInformado.setText("");
                break;

            case "40":
                imageView3.setImageResource(R.drawable.silo40);

                toolbar1.setVisibility(View.VISIBLE);
                toolbar2.setVisibility(View.VISIBLE);
                toolbar3.setVisibility(View.VISIBLE);
                toolbar4.setVisibility(View.VISIBLE);
                toolbar5.setVisibility(View.INVISIBLE);
                toolbar6.setVisibility(View.INVISIBLE);
                toolbar7.setVisibility(View.INVISIBLE);
                toolbar8.setVisibility(View.INVISIBLE);
                toolbar9.setVisibility(View.INVISIBLE);
                toolbar10.setVisibility(View.INVISIBLE);

                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.INVISIBLE);
                textView6.setVisibility(View.INVISIBLE);
                textView7.setVisibility(View.INVISIBLE);
                textView8.setVisibility(View.INVISIBLE);
                textView9.setVisibility(View.INVISIBLE);
                textView10.setVisibility(View.INVISIBLE);

                pegaValorInformado.setText("");
                break;

            case "50":
                imageView3.setImageResource(R.drawable.silo50);

                toolbar1.setVisibility(View.VISIBLE);
                toolbar2.setVisibility(View.VISIBLE);
                toolbar3.setVisibility(View.VISIBLE);
                toolbar4.setVisibility(View.VISIBLE);
                toolbar5.setVisibility(View.VISIBLE);
                toolbar6.setVisibility(View.INVISIBLE);
                toolbar7.setVisibility(View.INVISIBLE);
                toolbar8.setVisibility(View.INVISIBLE);
                toolbar9.setVisibility(View.INVISIBLE);
                toolbar10.setVisibility(View.INVISIBLE);

                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.VISIBLE);
                textView6.setVisibility(View.INVISIBLE);
                textView7.setVisibility(View.INVISIBLE);
                textView8.setVisibility(View.INVISIBLE);
                textView9.setVisibility(View.INVISIBLE);
                textView10.setVisibility(View.INVISIBLE);

                pegaValorInformado.setText("");
                break;

            case "60":
                imageView3.setImageResource(R.drawable.silo60);

                toolbar1.setVisibility(View.VISIBLE);
                toolbar2.setVisibility(View.VISIBLE);
                toolbar3.setVisibility(View.VISIBLE);
                toolbar4.setVisibility(View.VISIBLE);
                toolbar5.setVisibility(View.VISIBLE);
                toolbar6.setVisibility(View.VISIBLE);
                toolbar7.setVisibility(View.INVISIBLE);
                toolbar8.setVisibility(View.INVISIBLE);
                toolbar9.setVisibility(View.INVISIBLE);
                toolbar10.setVisibility(View.INVISIBLE);

                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.VISIBLE);
                textView6.setVisibility(View.VISIBLE);
                textView7.setVisibility(View.INVISIBLE);
                textView8.setVisibility(View.INVISIBLE);
                textView9.setVisibility(View.INVISIBLE);
                textView10.setVisibility(View.INVISIBLE);
                pegaValorInformado.setText("");
                break;

            case "70":
                imageView3.setImageResource(R.drawable.silo70);

                toolbar1.setVisibility(View.VISIBLE);
                toolbar2.setVisibility(View.VISIBLE);
                toolbar3.setVisibility(View.VISIBLE);
                toolbar4.setVisibility(View.VISIBLE);
                toolbar5.setVisibility(View.VISIBLE);
                toolbar6.setVisibility(View.VISIBLE);
                toolbar7.setVisibility(View.VISIBLE);
                toolbar8.setVisibility(View.INVISIBLE);
                toolbar9.setVisibility(View.INVISIBLE);
                toolbar10.setVisibility(View.INVISIBLE);

                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.VISIBLE);
                textView6.setVisibility(View.VISIBLE);
                textView7.setVisibility(View.VISIBLE);
                textView8.setVisibility(View.INVISIBLE);
                textView9.setVisibility(View.INVISIBLE);
                textView10.setVisibility(View.INVISIBLE);
                pegaValorInformado.setText("");
                pegaValorInformado.setText("");
                break;

            case "80":
                imageView3.setImageResource(R.drawable.silo80);

                toolbar1.setVisibility(View.VISIBLE);
                toolbar2.setVisibility(View.VISIBLE);
                toolbar3.setVisibility(View.VISIBLE);
                toolbar4.setVisibility(View.VISIBLE);
                toolbar5.setVisibility(View.VISIBLE);
                toolbar6.setVisibility(View.VISIBLE);
                toolbar7.setVisibility(View.VISIBLE);
                toolbar8.setVisibility(View.VISIBLE);
                toolbar9.setVisibility(View.INVISIBLE);
                toolbar10.setVisibility(View.INVISIBLE);

                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.VISIBLE);
                textView6.setVisibility(View.VISIBLE);
                textView7.setVisibility(View.VISIBLE);
                textView8.setVisibility(View.VISIBLE);
                textView9.setVisibility(View.INVISIBLE);
                textView10.setVisibility(View.INVISIBLE);

                pegaValorInformado.setText("");
                break;

            case "90":
                imageView3.setImageResource(R.drawable.silo90);

                toolbar1.setVisibility(View.VISIBLE);
                toolbar2.setVisibility(View.VISIBLE);
                toolbar3.setVisibility(View.VISIBLE);
                toolbar4.setVisibility(View.VISIBLE);
                toolbar5.setVisibility(View.VISIBLE);
                toolbar6.setVisibility(View.VISIBLE);
                toolbar7.setVisibility(View.VISIBLE);
                toolbar8.setVisibility(View.VISIBLE);
                toolbar9.setVisibility(View.VISIBLE);
                toolbar10.setVisibility(View.INVISIBLE);

                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.VISIBLE);
                textView6.setVisibility(View.VISIBLE);
                textView7.setVisibility(View.VISIBLE);
                textView8.setVisibility(View.VISIBLE);
                textView9.setVisibility(View.VISIBLE);
                textView10.setVisibility(View.INVISIBLE);

                pegaValorInformado.setText("");
                break;

            case "100":
                imageView3.setImageResource(R.drawable.silo90);

                toolbar1.setVisibility(View.VISIBLE);
                toolbar2.setVisibility(View.VISIBLE);
                toolbar3.setVisibility(View.VISIBLE);
                toolbar4.setVisibility(View.VISIBLE);
                toolbar5.setVisibility(View.VISIBLE);
                toolbar6.setVisibility(View.VISIBLE);
                toolbar7.setVisibility(View.VISIBLE);
                toolbar8.setVisibility(View.VISIBLE);
                toolbar9.setVisibility(View.VISIBLE);
                toolbar10.setVisibility(View.VISIBLE);

                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.VISIBLE);
                textView6.setVisibility(View.VISIBLE);
                textView7.setVisibility(View.VISIBLE);
                textView8.setVisibility(View.VISIBLE);
                textView9.setVisibility(View.VISIBLE);
                textView10.setVisibility(View.VISIBLE);
                pegaValorInformado.setText("");
                break;

            default:
                pegaValorInformado.setError("informe um valor v??lido");
                break;
        }

    }
}



