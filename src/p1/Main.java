package p1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe Principal
 * @author Victtor da Silva Mendes
 * @version 0.4
 */
public class Main {

    /**
     * Função main
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Mundo mundo = new Mundo(30, 60);
        Random rand = new Random();
        String[] arrTipo = {"Scooter", "Cub", "Street", "Trail", "Naked", "Esportiva", "Touring", "Trial", "Triciclo"};
        ArrayList<Veiculo> arr = new ArrayList<>();
        
        /* 
         * Cria os 10 veiculos iniciais e os coloca no ArrayList
         * com todos atributos randomicos, mas com valores possíveis
         */
        for (int i = 0; i < 10; i++) {
            arr.add( new Bicicleta(mundo, rand.nextInt(mundo.getTamanho_x()), rand.nextInt(mundo.getTamanho_y())) );
            arr.add( new Moto     (mundo, rand.nextInt(mundo.getTamanho_x()), rand.nextInt(mundo.getTamanho_y()), arrTipo[rand.nextInt(arrTipo.length)]) );
            arr.add( new Carro    (mundo, rand.nextInt(mundo.getTamanho_x()), rand.nextInt(mundo.getTamanho_y()), rand.nextInt(5)+1) );
            arr.add( new Caminhao (mundo, rand.nextInt(mundo.getTamanho_x()), rand.nextInt(mundo.getTamanho_y()), rand.nextInt(7000)+1000) );
        }
        
        for (int i = 0; i < arr.size(); i++) {
            switch (arr.get(i).getPrioridade()) {
                case 1:
                    System.out.printf("Bike: (%d, %d)\n", 
                                      arr.get(i).getX(), arr.get(i).getY());
                    break;
                case 2:
                    System.out.printf("Motoca: (%d, %d) tipo:%s\n", 
                                      arr.get(i).getX(), arr.get(i).getY(), ((Moto)arr.get(i)).getTipo());
                    break;
                case 3:
                    System.out.printf("Carro: (%d, %d) passageiros:%d\n", 
                                      arr.get(i).getX(), arr.get(i).getY(), ((Carro)arr.get(i)).getNum_passageiros());
                    break;
                case 4:
                    System.out.printf("Caminhao: (%d, %d) capacidadeCarga:%dkg\n", 
                                      arr.get(i).getX(), arr.get(i).getY(), ((Caminhao)arr.get(i)).getCapacidade_carga());
                    break;
                default:
                    break;
            }
        }
        do {
            mundo.cont.print(arr);
            mundo.desenhaMundo(arr);
            mundo.move(arr);
            Thread.sleep(1000);
        } while (mundo.cont.getSoma() > 0);
    }
    
}
