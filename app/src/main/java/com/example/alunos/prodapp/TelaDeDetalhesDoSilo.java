package com.example.alunos.prodapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Interacao.Silos;
import util.Contexto;

import static com.example.alunos.prodapp.R.drawable.silo;

public class TelaDeDetalhesDoSilo extends AppCompatActivity implements View.OnClickListener{

    private TextView FiltroTextViewTelaDeDetalhesDoSilo;
    private RadioGroup FiltroRadioGroupTelaDeDetalhesDoSilo;
    private RadioButton KgRadioButtonTelaDeDetalhesDoSilo;
    private RadioButton TonRadioButtonTelaDeDetalhesDoSilo;
    private TextView NomeDetalheTextViewTelaDeDetalhesDoSilo;
    private TextView RecebeNomeDetalheTextViewTelaDeDetalhesDoSilo;
    private TextView TipoDeGraoTextViewTelaDeDetalhesDoSilo;
    private TextView RecebeTipoDeGraoTextViewTelaDeDetalhesDoSilo;
    private TextView PorteDoSiloTextViewTelaDeDetalhesDoSilo;
    private TextView RecebePorteDoSiloTextViewTelaDeDetalhesDoSilo;
    private TextView CapacidadeTotalTextViewTelaDeDetalhesDoSilo;
    private TextView RecebeCapacidadeTotalTextViewTelaDeDetalhesDoSilo;
    private TextView CapacidadeUtilizadaTextViewTelaDeDetalhesDoSilo;
    private TextView RecebeCapacidadeUtilizadaTextViewTelaDeDetalhesDoSilo;
    private TextView CapacidadeDisponivelTextViewTelaDeDetalhesDoSilo;
    private TextView RecebeCapacidadeDisponivelTextViewTelaDeDetalhesDoSilo;
    private TextView DataDaCriacaoTextViewTelaDeDetalhesDoSilo;
    private TextView RecebeDataDaCriacaoTextViewTelaDeDetalhesDoSilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_detalhes_do_silo);

        //FindView

        NomeDetalheTextViewTelaDeDetalhesDoSilo = (TextView) findViewById(R.id.NomeDetalheTextViewTelaDeDetalhesDoSilo);
        RecebeNomeDetalheTextViewTelaDeDetalhesDoSilo = (TextView) findViewById(R.id.RecebeNomeDetalheTextViewTelaDeDetalhesDoSilo);
        TipoDeGraoTextViewTelaDeDetalhesDoSilo = (TextView) findViewById(R.id.TipoDeGraoTextViewTelaDeDetalhesDoSilo);
        RecebeTipoDeGraoTextViewTelaDeDetalhesDoSilo = (TextView) findViewById(R.id.RecebeTipoDeGraoTextViewTelaDeDetalhesDoSilo);
        PorteDoSiloTextViewTelaDeDetalhesDoSilo = (TextView) findViewById(R.id.PorteDoSiloTextViewTelaDeDetalhesDoSilo);
        RecebePorteDoSiloTextViewTelaDeDetalhesDoSilo = (TextView) findViewById(R.id.RecebePorteDoSiloTextViewTelaDeDetalhesDoSilo);
        CapacidadeTotalTextViewTelaDeDetalhesDoSilo = (TextView) findViewById(R.id.CapacidadeTotalTextViewTelaDeDetalhesDoSilo);
        RecebeCapacidadeTotalTextViewTelaDeDetalhesDoSilo = (TextView) findViewById(R.id.RecebeCapacidadeTotalTextViewTelaDeDetalhesDoSilo);
        CapacidadeUtilizadaTextViewTelaDeDetalhesDoSilo = (TextView) findViewById(R.id.CapacidadeUtilizadaTextViewTelaDeDetalhesDoSilo);
        RecebeCapacidadeUtilizadaTextViewTelaDeDetalhesDoSilo = (TextView) findViewById(R.id.RecebeCapacidadeUtilizadaTextViewTelaDeDetalhesDoSilo);
        CapacidadeDisponivelTextViewTelaDeDetalhesDoSilo = (TextView) findViewById(R.id.CapacidadeDisponivelTextViewTelaDeDetalhesDoSilo);
        RecebeCapacidadeDisponivelTextViewTelaDeDetalhesDoSilo = (TextView) findViewById(R.id.RecebeCapacidadeDisponivelTextViewTelaDeDetalhesDoSilo);
        DataDaCriacaoTextViewTelaDeDetalhesDoSilo = (TextView) findViewById(R.id.DataDaCriacaoTextViewTelaDeDetalhesDoSilo);
        RecebeDataDaCriacaoTextViewTelaDeDetalhesDoSilo = (TextView) findViewById(R.id.RecebeDataDaCriacaoTextViewTelaDeDetalhesDoSilo);


        // PEGANDO O TAMANHO DO SILO, FAZENDO TESTES L??GICOS E SETANDO O TIPO DE PORTE
        double quantidade = (double) Contexto.dados.get("tamanhoDoSilo") ;

        if (quantidade > 0 & (quantidade <= 5000)){
        RecebePorteDoSiloTextViewTelaDeDetalhesDoSilo.setText("Pequeno");
        }if(quantidade > 5000 & (quantidade <= 10000)){
        RecebePorteDoSiloTextViewTelaDeDetalhesDoSilo.setText("M??dio");
        }if(quantidade > 10000 & (quantidade <= 100000)){
            RecebePorteDoSiloTextViewTelaDeDetalhesDoSilo.setText("Grande");
        }

        //PARTE RESPONS??VEL POR SETAR OS VALORES CORRETOS NOS TEXTFILED E FAZER OS CALCULOS L??GICOS
        RecebeNomeDetalheTextViewTelaDeDetalhesDoSilo.setText(Contexto.dados.get("nomeDoSilo")+"");
        RecebeTipoDeGraoTextViewTelaDeDetalhesDoSilo.setText(Contexto.dados.get("produtoDoSilo")+"");
        RecebeCapacidadeTotalTextViewTelaDeDetalhesDoSilo.setText(Contexto.dados.get("tamanhoDoSilo")+"");


        //Pegando o valor que vem da Activity Silo Principal e Setando no Textview

         String pegaDouble = Contexto.dados.get("EnviandoDouble").toString();
        double converteDouble = Double.parseDouble(pegaDouble);
        String valorFinalString = String.valueOf(converteDouble);

        RecebeCapacidadeUtilizadaTextViewTelaDeDetalhesDoSilo.setText(valorFinalString);

        // Recebendo o VALOR TOTAL DO SILO em String e convertendo para Double
        String pegaValorTotal = Contexto.dados.get("tamanhoDoSilo").toString();
        double converteemDoubleValorTotal = Double.parseDouble(pegaValorTotal);

        // Recebendo o valor informado na adi????o e convertendo para double
        String pegaValorAdicao = Contexto.dados.get("EnviandoDouble").toString();
        double converteemDoubleValorAdicao = Double.parseDouble(pegaValorAdicao);

        // Fazendo o calculo para descontar o valor informado do total e exibir no Espa??o Dispon??vel
        double valorDisponivel = converteemDoubleValorTotal - converteemDoubleValorAdicao ;

        // Convertendo para String
        String valorDisponivelParaString = String.valueOf(valorDisponivel);

        RecebeCapacidadeDisponivelTextViewTelaDeDetalhesDoSilo.setText(valorDisponivelParaString);

        // Setando a Data atual, est?? pegando a mesma data certa, porem ele poem em todos os registros, n??o tem
        // Nada haver como banco de dados
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = sdf.format(date);
        RecebeDataDaCriacaoTextViewTelaDeDetalhesDoSilo.setText("0");
        RecebeDataDaCriacaoTextViewTelaDeDetalhesDoSilo.setText(dateString);
    }

    @Override
    public void onClick(View v) {

    }
}
