import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class CalculadoraCliente {
	
	public static void main(String[] args) {
		Registry reg = null;
		ICalculadora calc;
		int oper1, oper2, operacao;		
		try {
			//Faz a recuperação do nosso serviço de nomes
			reg = LocateRegistry.getRegistry(1099);
			//Recupera o objeto registrado no servidor, através do mesmo nome dado na hora de realizar o registro
			calc = (ICalculadora) reg.lookup("calculadora");

			Scanner scanner = new Scanner(System.in);
            while(true){
				//Captura das entradas para nosso cliente funcionar
				System.out.println ("Digite o primeiro valor");
				oper1 = scanner.nextInt();
				System.out.println ("Digite o segundo valor");
				oper2 = scanner.nextInt();
	
				System.out.println ("Agora digite a operacao");
				System.out.println ("Digite 1 para somar");
				System.out.println ("Digite 2 para subtrair");
				System.out.println ("Digite 3 para multipliclar");
				System.out.println ("Digite 4 para dividir");
	
				
				operacao = scanner.nextInt();
				//A partir da operação digitada pelo cliente, é realizado uma operação matemática em nosso objeto remoto, através da definição da interface remota. 
				if(operacao==1){
					System.out.println(calc.soma(oper1, oper2));
				}
				if(operacao==2){
					System.out.println(calc.subtrair(oper1, oper2));
				}
				if(operacao==3){
					System.out.println(calc.multiplicar(oper1, oper2));
				}
				if(operacao==4){
					System.out.println(calc.dividir(oper1, oper2));
				}
				else {
					break;
				}
			}
           
		} catch (RemoteException | NotBoundException e) {
				System.out.println(e);
				System.exit(0);
		}
	}		

}
