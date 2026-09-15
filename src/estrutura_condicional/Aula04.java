package estrutura_condicional;

public class Aula04 {
    public static void main(String[] args) {
        // Sem expressão condicional ternária
//        double preco = 34.5;
//        double desconto;
//
//        if (preco < 20.0) {
//            desconto = preco * 0.1;
//        } else {
//            desconto = preco * 0.05;
//        }

        // Com expressão condicional ternária
        double preco = 34.5;
        double desconto = (preco < 20) ? preco * 0.1 : preco * 0.05;

        if (preco < 20.0) {
            desconto = preco * 0.1;
        } else {
            desconto = preco * 0.05;
        }
    }
}
