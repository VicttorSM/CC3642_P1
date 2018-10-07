package p1;

/**
 * Superclasse abstrata Veiculo
 * @author Victtor da Silva Mendes
 * @version 0.1
 */
public abstract class Veiculo {
    /**
     * Construtor Veiculo
     * @param m mundo em que o veículo será colocado
     * @param x posição <u>x</u> (coluna) do veículo
     * @param y posição <u>y</u> (linha) do veículo
     * @param velocidade velocidade (pixels por frame) que o veículo anda
     * @param prioridade prioridade do veículo (um veículo que colide com outro veículo de prioridade menor sobrevive)
     * @param cor cor do veículo
     */
    public Veiculo(Mundo m, int x, int y, double velocidade, int prioridade, String cor) {
        setX(x, m.getTamanho_x());
        setY(y, m.getTamanho_y());
        this.velocidade = velocidade;
        this.prioridade = prioridade;
        setCor(cor);
        this.carry = 0;
    }
    
    /**
     * Setter <u>x</u> que modifica se necessário a posição para satisfazer a
     * condição de mapa cíclico
     * @param x posição <u>x</u> (coluna) que o veículo vai ocupar
     * @param max o numero de colunas que o mapa possui
     */
    public void setX(int x, int max) {
        while (x < 0) {
            x += max;
        }
        this.x = x % max;
    }
    
    /**
     * Getter <u>x</u>
     * @return posição <u>x</u> (coluna) que o veículo está ocupando
     */
    public int getX() {
        return x;
    }

    /**
     * Setter <u>y</u> que modifica se necessário a posição para satisfazer a
     * condição de mapa cíclico
     * @param y posição <u>y</u> (linha) que o veículo vai ocupar
     * @param max numero de linhas que o mapa possui
     */
    public void setY(int y, int max) {
        while (y < 0) {
            y += max;
        }
        this.y = y % max;
    }
    
    /**
     * Getter <u>y</u>
     * @return posição <u>y</u> (linha) que o veículo está ocupando
     */
    public int getY() {
        return y;
    }

    /**
     * Getter <u>velocidade</u>
     * @return velocidade (pixel por frame) que o veículo anda
     */
    public double getVelocidade() {
        return velocidade;
    }

    /**
     * Setter <u>velocidade</u> que não permite uma velocidade negativa
     * @param velocidade velocidade (pixel por frame) que o veículo anda
     */
    public void setVelocidade(double velocidade) {
        if (velocidade < 0) velocidade = 0;
        this.velocidade = velocidade;
    }

    /**
     * Verifica se o veículo está numa posição de fábrica
     * @param m mundo em que o veículo se encontra
     * @return <b>true</b> se estiver em uma fábrica, <b>false</b> se não estiver
     */
    public boolean inFabrica(Mundo m) {
        return m.mapa[y][x] == 9;
    }

    /**
     * Getter <u>cor</u>
     * @return cor do veículo
     */
    public String getCor() {
        return cor;
    }

    /**
     * Setter <u>cor</u>
     * @param cor cor do veículo
     */
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    /**
     * Getter <u>prioridade</u>
     * @return prioridade do veículo (um veículo que colide com outro veículo de prioridade menor sobrevive)
     */
    public int getPrioridade() {
        return prioridade;
    }
    
    private int carry; /// variável que guarda a quantidade quebrada de movimento que o veículo acumulou
    private int x;
    private int y;
    private double velocidade;
    private String cor;
    private final int prioridade;
}
