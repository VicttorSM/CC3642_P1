package p1;

import java.util.ArrayList;

/**
 * Classe Principal
 * @author Victtor da Silva Mendes
 * @version 1.0
 */
public class Main {

    /**
     * Função main
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        /* Começa um mundo com 10 fábricas */
        Mundo mundo = new Mundo(30, 60, 10);
        ArrayList<Veiculo> arr = new ArrayList<>();
        
        /* Cria os 10 veiculos iniciais de cada tipo */
        for (int i = 0; i < 10; i++) {
            for (int tipo = 1; tipo <= 4; tipo++) {
                mundo.criaVeiculo(arr, tipo);
            }
        }
        
        /* Loop de imagens na tela */
        do {
            mundo.cont.print();
            mundo.desenhaMundo(arr);
            mundo.move(arr);
            Thread.sleep(1000);
        } while (mundo.cont.getSoma() > 0);
    }
    
}
