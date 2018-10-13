package p1;

import java.util.ArrayList;

/**
 * Classe Contador responsável pela contagem dos veículos
 * @author Victtor da Silva Mendes
 * @version 1.0
 * @since 0.4
 */
public class Contador {
    /**
     * Construtor padrão de Contador
     * que inicia todos contadores como 0
     */
    public Contador() {
        this.bicicleta = 0;
        this.caminhao = 0;
        this.carro = 0;
        this.moto = 0;
    } 

    /**
     * Conta do zero todos os veículos
     * @param arr ArrayList que contém todos os veículos
     */
    public void contar(ArrayList<Veiculo> arr) {
        bicicleta = 0;
        caminhao = 0;
        carro = 0;
        moto = 0;
        
        for (int i = 0; i < arr.size(); i++) {
            switch (arr.get(i).getPrioridade()) {
                case 1:
                    bicicleta++;
                    break;
                case 2:
                    moto++;
                    break;
                case 3:
                    carro++;
                    break;
                case 4:
                    caminhao++;
                    break;
                default:
                    break;
            }
        }
    }
    
    /**
     * Função que vai printar na tela a quantidade de veículos
     * que ja esta armazenada na classe com as suas respectivas cores 
     */
    public void print() {
        System.out.println();
        System.out.printf("%s Caminhao: %-4d %s", corCaminhao, caminhao, reset);
        System.out.printf("%s Carro: %-4d %s", corCarro, carro, reset);
        System.out.printf("%s Moto: %-4d %s", corMoto, moto, reset);
        System.out.printf("%s Bicicleta: %-4d %s\n", corBicicleta, bicicleta, reset);
    }
    
    /**
     * Função que chama <b>contar(ArrayList<Veiculo>)</b> e <b>print()</b>
     * @param arr ArrayList que contém todos os veículos
     */
    public void print(ArrayList<Veiculo> arr) {
        contar(arr);
        print();
    }
    
    /**
     * Getter <u>bicicleta</u>
     * @return quantidade de bicicletas
     */
    public int getBicicleta() {
        return bicicleta;
    }
    
    /**
     * Getter <u>moto</u>
     * @return quantidade de motos
     */
    public int getMoto() {
        return moto;
    }
    
    /**
     * Getter <u>carro</u>
     * @return quantidade de carros
     */
    public int getCarro() {
        return carro;
    }
    
    /**
     * Soma de todos
     * @return soma de todos os veículos ja guardados na classe
     */
    public int getSoma() {
        return carro+caminhao+moto+bicicleta;
    }
    
    /**
     * Getter <u>caminhao</u>
     * @return quantidade de caminhões
     */
    public int getCaminhao() {
        return caminhao;
    }

    /**
     * Getter <u>corBicicleta</u>
     * @return string ANSI referente a cor das bicicletas
     */
    public String getCorBicicleta() {
        return corBicicleta;
    }

    /**
     * Getter <u>corMoto</u>
     * @return string ANSI referente a cor dos motos
     */
    public String getCorMoto() {
        return corMoto;
    }

    /**
     * Getter <u>corCarro</u>
     * @return string ANSI referente a cor dos carros
     */
    public String getCorCarro() {
        return corCarro;
    }

    /**
     * Getter <u>corCaminhao</u>
     * @return string ANSI referente a cor dos caminhões
     */
    public String getCorCaminhao() {
        return corCaminhao;
    }

    /**
     * Vai somar ou subtrair 1 em um tipo de veículo
     * @param soma se for <b>true</b> soma 1, se for <b>false</b> tira 1
     * @param id numero que refere a prioridade do tipo de veículo
     * @since 0.6
     */
    public void incrementaVeiculo(boolean soma, int id) {
        switch (id) {
            case 1:
                incrementaBicicleta(soma);
                break;
            case 2:
                incrementaMoto(soma);
                break;
            case 3:
                incrementaCarro(soma);
                break;
            case 4:
                incrementaCaminhao(soma);
                break;
            default:
                break;
        }
    }
    
    /**
     * Adiciona ou remove uma bicicleta
     * @param soma se for <b>true</b> soma 1, se for <b>false</b> tira 1
     * @since 0.6
     */
    public void incrementaBicicleta(boolean soma) {
        if (soma) bicicleta++;
        else bicicleta--;
    }

    /**
     * Adiciona ou remove uma moto
     * @param soma se for <b>true</b> soma 1, se for <b>false</b> tira 1
     * @since 0.6
     */
    public void incrementaMoto(boolean soma) {
        if (soma) moto++;
        else moto--;
    }

    /**
     * Adiciona ou remove um carro
     * @param soma se for <b>true</b> soma 1, se for <b>false</b> tira 1
     * @since 0.6
     */
    public void incrementaCarro(boolean soma) {
        if (soma) carro++;
        else carro--;
    }

    /**
     * Adiciona ou remove um caminhão
     * @param soma se for <b>true</b> soma 1, se for <b>false</b> tira 1
     * @since 0.6
     */
    public void incrementaCaminhao(boolean soma) {
        if (soma) caminhao++;
        else caminhao--;
    }
    
    
    private final String reset = "\u001B[0m"; //Reset
    private final String corBicicleta = "\u001B[32m"; //Verde
    private final String corMoto = "\u001B[34m"; //Azul
    private final String corCarro = "\u001B[31m"; //Vermelho
    private final String corCaminhao = "\u001B[35m"; //Roxo
    private int bicicleta;
    private int moto;
    private int carro;
    private int caminhao;
}
