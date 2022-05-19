import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Calculadora  implements ICalculadora {

	private static final long serialVersionUID = 1L;
	
	private static int chamadas = 0;

	//Implementação dos métodos fornecidos por nossa interface remota.
	public int soma(int a, int b) throws RemoteException {
		System.out.println("Método soma chamado " + chamadas++);
		return a + b;
	}

	@Override
	public int subtrair(int a, int b) throws RemoteException {
		System.out.println("Método subtrair chamado " + chamadas++);
		return a - b;
	}

	@Override
	public int multiplicar(int a, int b) throws RemoteException {
		System.out.println("Método multiplicar chamado " + chamadas++);
		return a * b;
	}

	@Override
	public int dividir(int a, int b) throws RemoteException {
		System.out.println("Método dividir chamado " + chamadas++);
		return a / b;
	}

	public static void main(String[] args) throws AccessException, RemoteException, AlreadyBoundException  {
		Calculadora calculadora = new Calculadora();		
		Registry reg = null;
		ICalculadora stub = (ICalculadora) UnicastRemoteObject.
				exportObject(calculadora, 1100);
		try {
			System.out.println("Creating registry...");
			//Criação do serviço de nomes onde registraremos nosso objeto remoto
			reg = LocateRegistry.createRegistry(1099);
		} catch (Exception e) {
			try {
				//Caso já exista um serviço de nomes na porta especificada, fazemos apenas a recuperação do serivço existente.
				reg = LocateRegistry.getRegistry(1099);
			} catch (Exception e1) {
				System.exit(0);
			}
		}
		//Fazemos o registro do nosso objeto remoto no serviço de nomes, e damos um nome a ele, para que ele possa ser localizado e posteriomente usado pelos clientes.
		reg.rebind("calculadora", stub);
	}

	
}
