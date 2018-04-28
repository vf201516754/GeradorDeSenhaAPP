package br.com.victor.geradordesenha;

import android.content.Context;
import android.net.ConnectivityManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SenhaNetwork {

    public static Senha gerarSenha(String url, String servico, String fila) throws  IOException {

        String urlGerarSenha = url+"gera_senha?servico="+servico+"&fila="+fila;
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(urlGerarSenha)
                .build();

        Response response = client.newCall(request).execute();
        String  resultado =  response.body().string();

        Senha senha = new Senha();

        try {
            JSONObject senhaJSON = new JSONObject(resultado);
            senha.setCodigo(senhaJSON.getString("codigo"));
            senha.setDataAbertura(senhaJSON.getString("dataAbertura"));
            senha.setDataFechamento(senhaJSON.getString("dataFechamento"));
            senha.setServico(senhaJSON.getString("servico"));
            senha.setFila(senhaJSON.getString("fila"));
        } catch (JSONException e) {
            e.printStackTrace();
            throw  new IOException(e);
        }

        return senha;
    }

   public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
