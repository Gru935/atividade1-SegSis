// 1 - 17576 =              0 milissegundos
// 1 - 105456 =             2 milissegundos
// 1 - 100.391.791.500 =    0,004 segundos

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        double start = System.currentTimeMillis();

        int count = 1;
        while (count < (1003917915 * 100)) {
            count++;
        }

        double elapsed = System.currentTimeMillis() - start;
        System.out.println((elapsed / 1000));
    }

    public ArrayList<Integer> encontraFatoresPrimos() {
        ArrayList<Integer> fatoresPrimos = new ArrayList<>();
        int numComposto = 10;
        int fator = 2;
        int divisores = 0;
        int divisor = 1;

        while (fator < numComposto) {
            // Descobre se eh primo
            while (divisor < fator) {
                if (fator % divisor == 0) {
                    divisores++;
                }
                divisor++;
            }
            // Se for primo, descobre se eh divisor do numero composto
            if (divisores == 2) {
                if (numComposto % fator == 0) {
                    fatoresPrimos.add(fator);
                    numComposto = numComposto / fator;
                }
            }
            fator++;
            divisores = 0;
            divisor = 1;
        }
        return fatoresPrimos;
    }
}