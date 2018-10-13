package p1;

import java.util.Scanner;

/**
 * Classe Principal
 * @author Victtor da Silva Mendes
 * @version 1.2
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
        
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o tempo de sleep (em ms):");
        int tempo = input.nextInt();
        
        /* Loop de imagens na tela */
        while (mundo.cont.getSoma() > 0) {
            mundo.cont.print();
            mundo.desenhaMundo();
            mundo.move();
            Thread.sleep(tempo);
        }
        mundo.cont.print();
        mundo.desenhaMundo();
        
    }
    
}
