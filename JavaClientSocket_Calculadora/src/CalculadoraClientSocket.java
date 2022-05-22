import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class CalculadoraClientSocket {

    public static void main(String[] args) {
        double oper1 = 10, oper2 = 20;
        int operacao = 2; // 1-somar 2-subtrair 3-dividir 4-multiplicar
        String result = "";
        try {
            System.out.println("Cliente rodando");
            
            
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // Conexão com o Servidor
                Socket clientSocket = new Socket("localhost", 9090);
                DataOutputStream socketSaidaServer = new DataOutputStream(clientSocket.getOutputStream());
                
                // Entrada de dados para a realização das operações
                System.out.println("Digite o primeiro valor");
                oper1 = scanner.nextDouble();
                System.out.println("Digite o segundo valor");
                oper2 = scanner.nextDouble();

                System.out.println("Agora digite a operacao");
                System.out.println("Digite 1 para somar");
                System.out.println("Digite 2 para subtrair");
                System.out.println("Digite 3 para multipliclar");
                System.out.println("Digite 4 para dividir");
                System.out.println("Digite 0 para sair");

                operacao = scanner.nextInt();
                
                if(operacao==0){
                    clientSocket.close();
                    break;
                }
                    

                // Enviando os dados para o servidor
                socketSaidaServer.writeBytes(operacao + "\n");
                socketSaidaServer.writeBytes(oper1 + "\n");
                socketSaidaServer.writeBytes(oper2 + "\n");
                socketSaidaServer.flush();

                // Recebendo a resposta do servidor socket
                BufferedReader messageFromServer = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                result = messageFromServer.readLine();

                System.out.println("resultado=" + result);
                //Encerrando a conexão com o server
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
