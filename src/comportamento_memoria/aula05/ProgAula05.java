package comportamento_memoria.aula05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProgAula05 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(); // Instanciação de uma lista

        // Adicionando elementos na lista
        list.add("Pietro");
        list.add("Vittor");
        list.add("Rafael");
        list.add("Francine");

        list.add(2, "Nathalia"); // Adicionando elemento em um índice específico

        System.out.println(list.size()); // Retorna o tamanho da lista

        list.remove("Francine"); // Remove o valor especificado
        list.remove(1); // Removendo através do índice

        list.removeIf(x -> x.charAt(0) == 'R'); // Remoção através de predicado

        list.indexOf("Francine"); // Retorna o índice do elemento especificado. Quando não encontrado retorna -1

        List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').toList();

        String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);

        // Percorrendo a lista com foreach
        for (String obj : list) {
            System.out.println(obj);
        }
    }
}
