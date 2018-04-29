package br.com.victor.geradordesenha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class loginActivity extends AppCompatActivity {

    Button btnPainel;
    Button btnSenha;

    Intent intentPainel;
    Intent intentSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnPainel = (Button) findViewById(R.id.btn_login_painel);
        btnSenha = (Button) findViewById(R.id.btn_login_senha);

    }

    public void onClickSenha (View view) {
        intentSenha = new Intent(loginActivity.this, MainActivity.class);
        startActivity(intentSenha);
    }

    public void onClickPainel (View view) {
        /*intentPainel = new Intent(loginActivity.this, PainelActivity.class);
        startActivity(intentPainel);*/
    }

}
