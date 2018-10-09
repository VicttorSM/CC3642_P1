package p1;

import java.util.ArrayList;

/**
 * Classe Mundo
 * @author Victtor da Silva Mendes
 * @version 0.2
 */
public class Mundo {
    /**
     * Construtor Mundo
     * @param linha quantidade de linhas da matriz mapa
     * @param coluna quantidade de colunas da matriz mapa
     */
    public Mundo(int linha, int coluna) {
        this.tamanho_x = coluna;
        this.tamanho_y = linha;
        mapa = new int[linha][coluna];
        for(int i = 0; i < linha; i++) {
            for(int j = 0; j < coluna; j++) {
                mapa[i][j] = 0;
            }
        }
    }
    
    public int[][] mapa;

    /**
     * Getter <u>tamanho_x</u>
     * @return quantidade de colunas do mapa
     */
    public int getTamanho_x() {
        return tamanho_x;
    }

    /**
     * Getter <u>tamanho_y</u>
     * @return quantidade de linhas do mapa
     */
    public int getTamanho_y() {
        return tamanho_y;
    }
    
    /**
     * Função que desenha o mundo com todos os veículos
     * @param arr lista de todos os veículos no mundo
     */
    public void desenhaMundo(ArrayList<Veiculo> arr) {
        /* É feita uma cópia do mapa */
        int[][] novoMapa = new int[tamanho_y][tamanho_x];
        for (int i = 0; i < tamanho_y; i++) {
            System.arraycopy(mapa[i], 0, novoMapa[i], 0, tamanho_x);
        }
        
        /* Preenchimento do mapa com veículos */
        for (int k = 0; k < arr.size(); k++) {
            int i = arr.get(k).getY();
            int j = arr.get(k).getX();
            novoMapa[i][j] = arr.get(k).getPrioridade();
        }
        
        /* Print do mapa */
        for (int i = 0; i < tamanho_y; i++) {
            for (int j = 0; j < tamanho_x; j++) {
                System.out.print(novoMapa[i][j]);
            }
            System.out.println();
        }
    }
    
    /**
     * Chama a função <b>move()</b> para todos os veículos no mundo
     * @param arr lista de todos os veículos no mundo
     * @since 0.2
     */
    public void move(ArrayList<Veiculo> arr) {
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).move(this);
        }
    }
    
    private final int tamanho_x;
    private final int tamanho_y;
}
