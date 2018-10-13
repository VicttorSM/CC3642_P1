package p1;

import java.util.ArrayList;

/**
 * Classe Principal
 * @author Victtor da Silva Mendes
 * @version 1.1
 */
public class Main {

    /**
     * Função main
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        /* Começa um mundo com 10 fábricas e 10 veículos de cada tipo */
        Mundo mundo = new Mundo(30, 60, 10, 10);
        ArrayList<Veiculo> arr = new ArrayList<>();
        
        /* Loop de imagens na tela */
        while (mundo.cont.getSoma() > 0) {
            mundo.cont.print();
            mundo.desenhaMundo();
            mundo.move();
            Thread.sleep(1000);
        }
        mundo.cont.print();
        mundo.desenhaMundo();
        
    }
    
}
