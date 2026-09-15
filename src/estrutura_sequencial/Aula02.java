package estrutura_sequencial;

public class Aula02 {
    public static void main(String[] args) {
        int x, y;

        x = 5;
        y = 2 * x;

        System.out.println(x);
        System.out.println(y);

//        double b, B, h, area;
//        b = 6.0;
//        B = 8.0;
//        h = 5.0;
//        area = (b + B) / 2.0 * h;
//        System.out.println(area);

        int a, b;
        double resultado ;

        a = 5;
        b = 2;

        resultado = a / b; // Divisão por dois números inteiros será um resultado do tipo inteiro

        // Para fazer com que o resultado seja um valor double é preciso fazer um cast explícito, ou seja,
        // Uma conversão do valor inteiro para um valor double. Também chamado de upercasting

        resultado = (double) a / b;
        System.out.println(resultado);

        // Não é possível fazer a conversão de um double para um int (downcasting), pois irá ocorrer a perca de dados

        double z;
        int j;

        z = 5.0;
//        j = z; // Não é possível, é preciso fazer cast explícito
        j = (int) z;
        System.out.println(j);
    }
}
