package p1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe Mundo
 * @author Victtor da Silva Mendes
 * @version 1.2
 */
public class Mundo {
    /**
     * Construtor Mundo
     * @param linha quantidade de linhas da matriz mapa
     * @param coluna quantidade de colunas da matriz mapa
     * @param fab número de fábricas que serão criadas
     * @param veiculos quantidade de veículos de cada tipo que serão criados incialmente
     */
    public Mundo(int linha, int coluna, int fab, int veiculos) {
        arr = new ArrayList<>();
        cont = new Contador();
        this.tamanho_x = coluna;
        this.tamanho_y = linha;
        this.numFabrica = 0;
        mapa = new int[linha][coluna];
        boolean[][] temp = new boolean[linha][coluna];
        /* Se não tiver espaço suficiente para criar os veiculos cria o máximo possivel */
        int max = linha*coluna;
        if ((veiculos*4) > max) veiculos = max/4;
        /* Preenche o mapa */
        for(int i = 0; i < linha; i++) {
            for(int j = 0; j < coluna; j++) {
                mapa[i][j] = 0;
                temp[i][j] = false;
            }
        }
        
        /* Cria 10 veículos de cada tipo */
        for (int i = 0; i < veiculos; i++) {
            for (int tipo = 1; tipo <= 4; tipo++) {
                int l;
                int c;
                /* Verifica as posições para não colidir de primeira */
                while (true){
                    Veiculo v = criaVeiculo(tipo);
                    l = v.getY();
                    c = v.getX();
                    if (temp[l][c]) {
                        removeVeiculo(v);
                    }
                    else break;
                }
                temp[l][c] = true;
            }
        }
        
        criaFabricas(fab);
    }
    
    public Contador cont;
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
     */
    public void desenhaMundo() {
        /* É feita uma cópia do mapa */
        String[][] novoMapa = new String[tamanho_y][tamanho_x];
        for (int i = 0; i < tamanho_y; i++) {
            for (int j = 0; j < tamanho_x; j++) {
                if (mapa[i][j] == 0) {
                    novoMapa[i][j] = "\u001B[47m"; //Branco
                }
                else if (mapa[i][j] == 9) {
                    novoMapa[i][j] = "\u001B[43m"; //Amarelo
                }
            }
        }
        
        /* Preenchimento do mapa com veículos */
        for (int k = 0; k < arr.size(); k++) {
            int i = arr.get(k).getY();
            int j = arr.get(k).getX();
            novoMapa[i][j] = arr.get(k).getCor();
        }
        
        /* Print do mapa */
        for (int i = 0; i < tamanho_y; i++) {
            for (int j = 0; j < tamanho_x; j++) {
                System.out.print(novoMapa[i][j] + " ");
            }
            System.out.println(); //Pula linha
        }
        System.out.print("\u001B[0m"); //Reset
    }
    
    /**
     * Chama a função <b>move()</b> para todos os veículos no mundo
     * @since 0.2
     */
    public void move() {
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).move(this);
            /* Se o veiculo parou numa fábrica */
            if (arr.get(i).inFabrica(this)) {
                /* Cria 1 veículos do mesmo tipo */
                criaVeiculo(arr.get(i).getPrioridade());
            }
        }
        colidir();
    }
    
    /**
     * Função responsável por decidir quem vai ser destruido numa colisão
     * @param vec lista dos veículos envolvidos na colisão
     * @since 0.5
     */
    private void destruir(ArrayList<Veiculo> vec) {
        Veiculo maisForte = null;
        int maior = 0;
        int quant = 0;
        /* Procura pelo veículo mais resistente */
        for (int i = 0; i < vec.size(); i++) {
            int prioridade = vec.get(i).getPrioridade();
            if (prioridade > maior) {
                maisForte = vec.get(i);
                maior = prioridade;
                quant = 1;
            }
            else if (prioridade == maior) {
                quant++;
            }
        }
        /* Se apenas um veículo tiver a maior resistencia */
        if (quant <= 1) {
            vec.remove(maisForte); // É removido da lista de veículos que serão destruidos
        }
        /* Destrói todos veículos na lista vec */
        for (int i = 0; i < vec.size(); i++) {
            removeVeiculo(vec.get(i));
        }
    }
    
    /**
     * Função que procura colisões entre os veículos no mapa
     * @since 0.5
     */
    private void colidir() {
        for (int i = 0; i < arr.size(); i++) {
            ArrayList<Veiculo> vec = new ArrayList<>();
            vec.add(arr.get(i));
            for (int j = i+1; j < arr.size(); j++) {
                if (arr.get(i).getX() == arr.get(j).getX() && arr.get(i).getY() == arr.get(j).getY()) {
                    vec.add(arr.get(j));
                }
            }
            if (vec.size() > 1) {
                destruir(vec);
                i--;
            }
        }
    }
    
    /**
     * Função que remove um veículo pelo objeto
     * @param v veículo que será removido
     * @since 1.1
     */
    public void removeVeiculo(Veiculo v) {
        cont.incrementaVeiculo(false, v.getPrioridade());
        arr.remove(v);
    }
    
    /**
     * Função que remove um veículo pelo objeto
     * @param i index do veículo que será removido
     * @since 1.1
     */
    public void removeVeiculo(int i) {
        cont.incrementaVeiculo(false, arr.get(i).getPrioridade());
        arr.remove(i);
    }
    
    /**
     * Função que cria um veículo com propriedades aleatórias
     * @param id numero que refere a prioridade do tipo de veículo
     * @return veículo que foi criado
     * @since 0.6
     */
    public Veiculo criaVeiculo(int id) {
        Random rand = new Random();
        Veiculo veiculo = null;
        String[] arrTipo = {"Scooter", "Cub", "Street", "Trail", "Naked", "Esportiva", "Touring", "Trial", "Triciclo"};
        switch (id) {
            case 1:
                veiculo = new Bicicleta(this, rand.nextInt(getTamanho_x()), rand.nextInt(getTamanho_y()));
                cont.incrementaBicicleta(true);
                break;
            case 2:
                veiculo = new Moto     (this, rand.nextInt(getTamanho_x()), rand.nextInt(getTamanho_y()), arrTipo[rand.nextInt(arrTipo.length)]);
                
                cont.incrementaMoto(true);
                break;
            case 3:
                veiculo = new Carro    (this, rand.nextInt(getTamanho_x()), rand.nextInt(getTamanho_y()), rand.nextInt(5)+1);
                cont.incrementaCarro(true);
                break;
            case 4:
                veiculo = new Caminhao (this, rand.nextInt(getTamanho_x()), rand.nextInt(getTamanho_y()), rand.nextInt(7000)+1000);
                cont.incrementaCaminhao(true);
                break;
            default:
                break;
        }
        if (veiculo != null) arr.add(veiculo);
        return veiculo;
    }
    
    /**
     * Função que cria fábricas em lugares aleatórios do mapa
     * @param num quantidade de fábricas que devem ser criadas
     * @since 1.0
     */
    private void criaFabricas(int num) {
        /* Verifica se existe espaço suficiente para abrigar as fabricas */
        int maximo = ((tamanho_x-2) * (tamanho_y-2)) - numFabrica;
        if (num > maximo) num = maximo;
        numFabrica += num;
        
        /* Cria as fabricas em locais aleatórios */
        Random rand = new Random();
        for (int i = 0; i < num; i++) {
            int linha;
            int coluna;
            do {
                linha = rand.nextInt(tamanho_y-2)+1;
                coluna = rand.nextInt(tamanho_x-2)+1;
            } while (mapa[linha][coluna] == 9);
            mapa[linha][coluna] = 9;
            numFabrica++;
        }
    }
    
    private ArrayList<Veiculo> arr;
    private int numFabrica;
    private final int tamanho_x;
    private final int tamanho_y;
}
