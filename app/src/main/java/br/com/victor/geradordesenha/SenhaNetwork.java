package br.com.victor.geradordesenha;

import android.content.Context;
import android.net.ConnectivityManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SenhaNetwork {

    public static void gerarSenha(String url, String servico, String fila) throws  IOException {

        String urlGerarSenha = url+"gera_senha?servico="+servico+"&fila="+fila;
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(urlGerarSenha)
                .build();

        Response response = client.newCall(request).execute();
        String  resultado =  response.body().string();
    }

    public static String buscaUltimaSenha(String url) throws  IOException {

        String urlBuscaUltimaSenha = url+"busca_ultima_senha";
        OkHttpClient client = new OkHttpClient();
        Senha senha = new Senha();
        Fila fila = new Fila();
        Servico servico = new Servico();


        Request request = new Request.Builder()
                .url(urlBuscaUltimaSenha)
                .build();

        Response response = client.newCall(request).execute();
        String  resultado =  response.body().string();
        String senhaResultado = null;

        try {
            JSONArray vetor = new JSONArray(resultado);
            for(int i = 0; i < vetor.length(); i++){
                JSONObject item = (JSONObject) vetor.get(i);

                senha.setId(item.getInt("id"));
                senha.setNumero(item.getInt("numero"));
                senha.setCodigo(item.getString("codigo"));
                //senha.setDataAbertura(Timestamp.valueOf(item.getString("dataAbertura")));
                //senha.setDataFechamento(Timestamp.valueOf(item.getString("dataFechamento")));
                fila.setId(item.getJSONObject("fila").getInt("id"));
                fila.setNome(item.getJSONObject("fila").getString("nome"));
                fila.setSigla(item.getJSONObject("fila").getString("sigla"));
                servico.setId(item.getJSONObject("servico").getInt("id"));
                servico.setNome(item.getJSONObject("servico").getString("nome"));
                servico.setSigla(item.getJSONObject("servico").getString("sigla"));

                //Teste deve retonar todos os dados do Json busca_ulitma_senha.json
                senhaResultado = senha.toString() + " " + fila.toString() + " " + servico.toString();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            throw  new IOException(e);
        }

        return senhaResultado;
    }



   public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
