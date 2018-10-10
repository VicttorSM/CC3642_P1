package p1;

/**
 * Classe Carro subclasse de Veiculo
 * @author Victtor da Silva Mendes
 * @version 0.3
 */
public class Carro extends Veiculo {
    /**
     * Construtor Carro
     * @param m mundo em que o carro será colocado
     * @param x posição <u>x</u> (coluna) do carro
     * @param y posição <u>y</u> (linha) do carro
     * @param num_passageiros número de passageiros dentro do carro
     */
    public Carro(Mundo m, int x, int y, int num_passageiros) {
        super(m, x, y, 2, 3, "\u001B[41m"); //Vermelho
        this.num_passageiros = num_passageiros;
    }

    /**
     * Getter <u>num_passageiros</u>
     * @return número de passageiros dentro do carro
     */
    public int getNum_passageiros() {
        return num_passageiros;
    }
    
    private final int num_passageiros;
}
