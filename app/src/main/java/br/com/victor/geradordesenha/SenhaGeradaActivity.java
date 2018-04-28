package br.com.victor.geradordesenha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SenhaGeradaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senha_gerada);
        TextView lbSenha = (TextView)findViewById(R.id.lb_senha_gerada);
        Intent intent = getIntent();
        String resultado = (String) intent.getSerializableExtra(MainActivity.SENHA);
        lbSenha.setText(resultado);
    }
}
