package br.com.victor.geradordesenha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SenhaGeradaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senha_gerada);
        TextView lbSenha = (TextView)findViewById(R.id.lb_senha_gerada);
        Intent intent = getIntent();
        Senha senha = (Senha)intent.getSerializableExtra("senha");
        lbSenha.setText(senha.toString());
    }
}
