package com.example.exemplomodelos_de_comunicacao;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class CalculadoraHttpPOST extends AsyncTask<Void, Void, String> {

    TextView tv;
    String oper1,oper2;
    PrecisaCalcular pc;
    String s;
    public CalculadoraHttpPOST(TextView tv, String oper1, String oper2){
        this.tv=tv;
        this.oper1=oper1;
        this.oper2=oper2;

    }
    public CalculadoraHttpPOST(PrecisaCalcular pc, String s, String oper1, String oper2){
        this.tv=tv;
        this.oper1=oper1;
        this.oper2=oper2;
        this.pc=pc;
        this.s=s;

    }
    @Override
    protected String doInBackground(Void... voids) {
        String result="";

        switch(Integer.parseInt(s)){
            case 1:
                try {

                    //cria url
                    URL url = new URL("https://double-nirvana-273602.appspot.com/?hl=pt-BR");
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                    //timeout de leitura
                    conn.setReadTimeout(10000);
                    //timeout de conexão
                    conn.setConnectTimeout(15000);
                    //método para envio dos dados
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    //envio de solicitação
                    conn.setDoOutput(true) ;

                    //ENVIO DOS PARAMETROS
                    OutputStream os = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write("oper1="+oper1+"&oper2="+oper2+"&operacao=1");
                    writer.flush();
                    writer.close();
                    os.close();

                    //armazenamento do retorno da requisição
                    int responseCode=conn.getResponseCode();
                    //verifica se a requisição foi OK
                    if (responseCode == HttpsURLConnection.HTTP_OK) {

                        //RECBIMENTO DOS PARAMETROS


                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(conn.getInputStream(), "utf-8"));
                        StringBuilder response = new StringBuilder();
                        String responseLine = null;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        //resposta para String
                        result = response.toString();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return result;

            case 2:
                try {
                    //cria url
                    URL url = new URL("https://double-nirvana-273602.appspot.com/?hl=pt-BR");
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                    //timeout de leitura
                    conn.setReadTimeout(10000);
                    //timeout de conexão
                    conn.setConnectTimeout(15000);
                    //método para envio dos dados
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    //envio de solicitação
                    conn.setDoOutput(true) ;

                    //ENVIO DOS PARAMETROS
                    OutputStream os = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write("oper1="+oper1+"&oper2="+oper2+"&operacao=2");
                    writer.flush();
                    writer.close();
                    os.close();

                    //armazenamento do retorno da requisição
                    int responseCode=conn.getResponseCode();
                    //verifica se a requisição foi OK
                    if (responseCode == HttpsURLConnection.HTTP_OK) {

                        //RECBIMENTO DOS PARAMETROS


                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(conn.getInputStream(), "utf-8"));
                        StringBuilder response = new StringBuilder();
                        String responseLine = null;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        //resposta para String
                        result = response.toString();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return result;
                //break;
            case 3:
                try {
                    //cria url
                    URL url = new URL("https://double-nirvana-273602.appspot.com/?hl=pt-BR");
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                    //timeout de leitura
                    conn.setReadTimeout(10000);
                    //timeout de conexão
                    conn.setConnectTimeout(15000);
                    //método para envio dos dados
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    //envio de solicitação
                    conn.setDoOutput(true) ;

                    //ENVIO DOS PARAMETROS
                    OutputStream os = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write("oper1="+oper1+"&oper2="+oper2+"&operacao=3");
                    writer.flush();
                    writer.close();
                    os.close();

                    //armazenamento do retorno da requisição
                    int responseCode=conn.getResponseCode();
                    //verifica se a requisição foi OK
                    if (responseCode == HttpsURLConnection.HTTP_OK) {

                        //RECBIMENTO DOS PARAMETROS


                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(conn.getInputStream(), "utf-8"));
                        StringBuilder response = new StringBuilder();
                        String responseLine = null;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        //resposta para String
                        result = response.toString();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return result;
            case 4:
                try {
                    //cria url
                    URL url = new URL("https://double-nirvana-273602.appspot.com/?hl=pt-BR");
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                    //timeout de leitura
                    conn.setReadTimeout(10000);
                    //timeout de conexão
                    conn.setConnectTimeout(15000);
                    //método para envio dos dados
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    //envio de solicitação
                    conn.setDoOutput(true) ;

                    //ENVIO DOS PARAMETROS
                    OutputStream os = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write("oper1="+oper1+"&oper2="+oper2+"&operacao=4");
                    writer.flush();
                    writer.close();
                    os.close();

                    //armazenamento do retorno da requisição
                    int responseCode=conn.getResponseCode();
                    //verifica se a requisição foi OK
                    if (responseCode == HttpsURLConnection.HTTP_OK) {

                        //RECBIMENTO DOS PARAMETROS


                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(conn.getInputStream(), "utf-8"));
                        StringBuilder response = new StringBuilder();
                        String responseLine = null;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        //resposta para String
                        result = response.toString();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return result;
           // default:
              //  System.out.println("Digite SOMENTE números entre 1 e 4");
                //break;
        }


        //Codigo

        return result;
    }


    @Override
    protected void onPreExecute() {
        //Codigo
    }


    @Override
    protected void onPostExecute(String result) {
        //Codigo
        if(this.tv!=null) {
            this.tv.setText(result);
        }else {
            this.pc.result_calculoRemoto(result);
        }
    }

}

