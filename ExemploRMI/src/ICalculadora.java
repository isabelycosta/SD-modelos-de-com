import java.rmi.Remote;
import java.rmi.RemoteException;
//Interface contendo os métodos que serão fornecidos por nosso objeto remoto. 
public interface ICalculadora extends Remote{

	public int soma(int a, int b) throws RemoteException;
	public int subtrair(int a, int b) throws RemoteException;
	public int multiplicar(int a, int b) throws RemoteException;
	public int dividir(int a, int b) throws RemoteException;
}
