package p1;

/**
 * Classe Caminhão subclasse de Veiculo
 * @author Victtor da Silva Mendes
 * @version 0.1
 */
public class Caminhao extends Veiculo {
    /**
     * Construtor Caminhao
     * @param m mundo em que o caminhão será colocado
     * @param x posição <u>x</u> (coluna) do caminhão
     * @param y posição <u>y</u> (linha) do caminhão
     * @param capacidade_carga capacidade de carga do caminhão em kg
     */
    public Caminhao(Mundo m, int x, int y, int capacidade_carga) {
        super(m, x, y, 1, 4, "Caminhao");
        this.capacidade_carga = capacidade_carga;
    }
    
    /**
     * Getter <u>capacidade_carga</u>
     * @return capacidade de carga do caminhão em kg
     */
    public int getCapacidade_carga() {
        return capacidade_carga;
    }
    
    private final int capacidade_carga;
}
