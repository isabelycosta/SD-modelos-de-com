public class Calculadora {
    public String sayHello(String nome, String sobrenome) {
        return "Fala "+ nome + " " + sobrenome;
    }
    public double somar(double oper1, double oper2) {
        return oper1 + oper2;
    }

    public double subtrair(double oper1, double oper2) {
        return oper1 - oper2;
    }

    public double multiplicar(double oper1, double oper2) {
        return oper1 * oper2;
    }

    public double dividir(double oper1, double oper2) throws Exception {
        if(oper2==0)
            throw new Exception("O divisor não pode ser 0");
        return oper1/oper2;
    }
}