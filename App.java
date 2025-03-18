import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        // System.out.println(contaTempo(1003917915 * 100));
        System.out.print("(");
        for (int i = 0; i < encontraFatoresPrimos(1700).size(); i++) {
            System.out.print(encontraFatoresPrimos(1700).get(i) + ",");
        }
        System.out.println(")");
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
}