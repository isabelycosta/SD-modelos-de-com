import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class CalculadoraClientHTTP {

	public static void main(String[] args) throws InterruptedException {
        try {
           
            int oper1, oper2, operacao;
            Scanner scanner = new Scanner(System.in);
            while(true){
                //Entrada de dados para realização das operações
                System.out.println ("Digite o primeiro valor");
                oper1 = scanner.nextInt();
                System.out.println ("Digite o segundo valor");
                oper2 = scanner.nextInt();

                System.out.println ("Agora digite a operacao");
                System.out.println ("Digite 1 para somar");
                System.out.println ("Digite 2 para subtrair");
                System.out.println ("Digite 3 para multipliclar");
                System.out.println ("Digite 4 para dividir");
                System.out.println ("Digite 0 para sair");


                operacao = scanner.nextInt();
                if(operacao == 0)
                    break;
                DoHttpPostRequest(oper1, oper2,operacao);
                //Fazendo um delay para aguardar a resposta do servidor
                Thread.sleep(2000);
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

    //Método para abstrair a requisição HTTP Post para o servidor com a implementação da Calculador
    public static void DoHttpPostRequest(int valor1, int valor2, int operacao) throws IOException
    {
        //URL do servidor
        URL url = new URL("https://double-nirvana-273602.appspot.com/?hl=pt-BR");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        //Método HTTP usado
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true) ;

        //ENVIO DOS PARAMETROS
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, "UTF-8"));
        writer.write("oper1=" + valor1 + "&oper2=" + valor2 + "&operacao=" + operacao); //1-somar 2-subtrair 3-dividir 4-multiplicar
        writer.flush();
        writer.close();
        os.close();

        int responseCode=conn.getResponseCode();
        //Tratamento em caso de sucesso da requisição (STATUS CODE 200)
        if (responseCode == HttpsURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println("Resposta do Servidor PHP="+response.toString());
            return; 
        }
        //Tratamento em caso de falha do lado cliente (STATUS CODE 400)
        else if(responseCode == HttpsURLConnection.HTTP_BAD_REQUEST){
            System.out.println("Erro de cliente, cheque os parâmetros enviados!!");
        }
        //Tratamento em caso de falha do lado servidor (STATUS CODE 500)
        else if(responseCode == HttpsURLConnection.HTTP_INTERNAL_ERROR){
            System.out.println("Erro no servidor!!");
        }
        //Tratamento em caso de um falha desconhecida (nenhum dos STATUS CODE tratados anteriormente)
        else{
            System.out.println("Erro inesperado!!");
        }
    }
}