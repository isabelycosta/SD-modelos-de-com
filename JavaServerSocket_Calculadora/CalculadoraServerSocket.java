import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculadoraServerSocket {

	public static void main(String[] args) throws NumberFormatException, Exception {
		ServerSocket welcomeSocket;
		DataOutputStream socketOutput;
		BufferedReader socketEntrada;
		Calculadora calc = new Calculadora();
		try {
			//Criação do servidor socket, colocando-o para "escutar" chamadas na porta 9090
			welcomeSocket = new ServerSocket(9090);
			int i = 0; // número de clientes

			System.out.println("Servidor no ar");
			while (true) {

				Socket connectionSocket = welcomeSocket.accept();
				i++;
				System.out.println("Nova conexão");

				// Interpretando dados do cliente
				socketEntrada = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
				String operacao = socketEntrada.readLine();
				String oper1 = socketEntrada.readLine();
				String oper2 = socketEntrada.readLine();

				String result = "";
				// Chamando a calculadora
				// 1-somar 2-subtrair 3-dividir 4-multiplicar
				if (operacao.equals("1"))
					result += calc.somar(Double.parseDouble(oper1), Double.parseDouble(oper2));
				else if (operacao.equals("2"))
					result += calc.subtrair(Double.parseDouble(oper1), Double.parseDouble(oper2));
				else if (operacao.equals("3"))
					result += calc.multiplicar(Double.parseDouble(oper1), Double.parseDouble(oper2));
				else if (operacao.equals("4"))
					result += calc.dividir(Double.parseDouble(oper1), Double.parseDouble(oper2));

				// Enviando dados para o cliente
				socketOutput = new DataOutputStream(connectionSocket.getOutputStream());
				socketOutput.writeBytes(result + '\n');
				System.out.println(result);
				socketOutput.flush();
				socketOutput.close();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
