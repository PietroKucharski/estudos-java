package comportamento_memoria.aula03;

public class ProgAula03 {
    public static void main(String[] args) {
        int x = 20;

        Object obj = x; // Boxing

        System.out.println(obj);

        int y = (int) obj; // Unboxing
    }
}
