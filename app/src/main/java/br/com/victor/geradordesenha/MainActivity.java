package br.com.victor.geradordesenha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView lbTitulo;
    Spinner spinnerServico;
    Spinner spinnerFila;
    Button btnGerarSenha;
    Button btnCancelar;

    String servico = "Selecione um serviço";
    String fila = "Selecione uma fila";

    Intent intent;
    Senha senha;

    public static final String URL = "http://10.0.2.2:8080/projeto_cartorio/";
    //public static final String SENHA = "br.com.victor.geradordesenha.senha";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lbTitulo = (TextView) findViewById(R.id.lb_gerar_senha);

        spinnerServico = (Spinner) findViewById(R.id.servico_spinner);
        spinnerServico.setOnItemSelectedListener(new ServicoSelecionado());

        spinnerFila = (Spinner) findViewById(R.id.fila_spinner);
        spinnerFila.setOnItemSelectedListener(new FilaSelecionada());

        btnGerarSenha = (Button) findViewById(R.id.btn_gerar_agora);
        btnCancelar = (Button) findViewById(R.id.btn_cancelar);
    }

    public void onClickGerarSenha(View view) {
        intent = new Intent(MainActivity.this, SenhaGeradaActivity.class);
        if(SenhaNetwork.isConnected(this)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        senha = SenhaNetwork.gerarSenha(URL, servico, fila);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                intent.putExtra("senha", senha);
                                startActivity(intent);
                            }
                        });

                    } catch (IOException e)  {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            Toast.makeText(this, "Rede inativa.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickCancelar(View view) {
        finish();
    }

    private class ServicoSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            servico = (String) parent.getItemAtPosition(position);
            String siglaServico = "";
            if(servico.equals("Selecione um serviço")){

            } else {
                siglaServico = servico.substring(0,3);
                siglaServico.toUpperCase();
                servico = siglaServico;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class FilaSelecionada implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            fila = (String) parent.getItemAtPosition(position);
            String siglaFila = "";
            if(fila.equals("Selecione uma fila")){

            } else {
                siglaFila = fila.substring(0,1);
                siglaFila.toUpperCase();
                fila = siglaFila;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
