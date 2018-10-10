package p1;

/**
 * Classe Bicicleta subclasse de Veiculo
 * @author Victtor da Silva Mendes
 * @version 0.3
 */
public class Bicicleta extends Veiculo {
    /**
     * Construtor Bicicleta
     * @param m mundo em que a bicicleta será colocada
     * @param x posição <u>x</u> (coluna) da bicicleta
     * @param y posição <u>y</u> (linha) da bicicleta
     */
    public Bicicleta(Mundo m, int x, int y) {
        super(m, x, y, 0.5, 1, "\u001B[42m"); //Verde
    }

}
