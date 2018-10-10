package p1;

/**
 * Classe Moto subclasse de Veiculo
 * @author Victtor da Silva Mendes
 * @version 0.3
 */
public class Moto extends Veiculo {
    /**
     * Construtor Moto
     * @param m mundo em que a moto será colocada
     * @param x posição <u>x</u> (coluna) da moto
     * @param y posição <u>y</u> (linha) da moto
     * @param tipo tipo da moto
     */
    public Moto(Mundo m, int x, int y, String tipo) {
        super(m, x, y, 3, 2, "\u001B[44m"); //Azul
        this.tipo = tipo;
    }

    /**
     * Getter <u>tipo</u>
     * @return tipo da moto
     */
    public String getTipo() {
        return tipo;
    }
    
    private final String tipo;
}
