import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        // System.out.println(contaTempo(1003917915 * 100));
        // System.out.print("(");
        // for (int i = 0; i < encontraFatoresPrimos(1700).size(); i++) {
        // System.out.print(encontraFatoresPrimos(1700).get(i) + ",");
        // }
        // System.out.println(")");
        System.out.println(contagemCaracteres("T1.txt").toString());
        System.out.println(indiceCoincidencia(contagemCaracteres("T1.txt")));
    }

    public static double contaTempo(int num) {
        double start = System.currentTimeMillis();
        int count = 0;

        while (count < num) {
            System.out.println(count);
            count++;
        }

        double elapsed = System.currentTimeMillis() - start;
        return (elapsed / 1000);
    }

    public static ArrayList<Integer> encontraFatoresPrimos(int numComposto) {
        ArrayList<Integer> fatoresPrimos = new ArrayList<>();
        int fator = 2;
        int divisores = 0;
        int divisor = 1;

        while (fator <= numComposto) {
            // Descobre a quantidade de divisores do fator
            while (divisor <= fator) {
                if (fator % divisor == 0) {
                    divisores++;
                }
                divisor++;
            }
            // Se o fator for primo, descobre se eh divisor do numero composto
            if (divisores == 2) {
                // Se o fator for divisor, adiciona na lista e divide o numero composto
                if (numComposto % fator == 0) {
                    fatoresPrimos.add(fator);
                    numComposto = numComposto / fator;
                    // Se nao for divisor, vai para o proximo numero
                } else {
                    fator++;
                    divisores = 0;
                    divisor = 1;
                }
                // Se nao for primo, vai para o proximo numero
            } else {
                fator++;
                divisores = 0;
                divisor = 1;
            }
        }
        return fatoresPrimos;
    }

    public static ArrayList<Map.Entry<Character, Integer>> contagemCaracteres(String file) {
        String filePath = file; // Substitua pelo caminho do arquivo
        HashMap<Character, Integer> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                for (int i = 0; i < linha.length(); i++) {
                    char c = linha.charAt(i);
                    Integer count = map.get(c);
                    if (count == null) {
                        map.put(c, 1);
                    } else {
                        map.put(c, count + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        ArrayList<Map.Entry<Character, Integer>> lista = new ArrayList<>(map.entrySet());
        lista.sort(Map.Entry.comparingByValue());
        return lista;
    }

    public static double indiceCoincidencia(ArrayList<Map.Entry<Character, Integer>> lista) {
        double indice = 0.0;

        double n = 0.0;
        for (int i = 0; i < lista.size(); i++) {
            n += lista.get(i).getValue();
        }

        double somatorio = 0.0;
        for (int i = 0; i < lista.size(); i++) {
            double fi = lista.get(i).getValue();
            somatorio += fi * (fi - 1);
        }

        indice = somatorio / (n * (n - 1));
        return indice;
    }
}