package EP_01;

import org.jfree.chart.demo.BarChartDemo1;
import org.jfree.ui.RefineryUtilities;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String caminho = "C:\\Users\\gabri\\Desktop\\Faculdade\\AED2\\EPs\\EP1\\OD_2017.csv";
        Scanner sc = new Scanner(System.in);
        int valida = -1;
        int opcao = -1;
        String tituloGrafico = "IDs por local";
        while(valida == -1){
            System.out.println("Qual dado gostaria de ser visualizado?: \n Digite 1 para dados de domicilio. \n Digite 2 para dados de escola. \n" +
                    " Digite 3 para dados do 1° trabalho. \n Digite 4 para dados de 2° trabalho");
            opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Opcao selecionada com sucesso");
                    tituloGrafico = "Pessoas por domicilio";
                    valida = 0;
                    break;
                case 2:
                    System.out.println("Opcao selecionada com sucesso");
                    tituloGrafico = "Pessoas por escola";
                    valida = 0;
                    break;
                case 3:
                    System.out.println("Opcao selecionada com sucesso");
                    tituloGrafico = "Pessoas por 1° trabalho";
                    valida = 0;
                    break;
                case 4:
                    System.out.println("Opcao selecionada com sucesso");
                    tituloGrafico = "Pessoas por 2° trabalho";
                    valida = 0;
                    break;
                default:
                    System.out.println("Opcao invalida");
                    valida = -1;
            }
        }
        Arquivo entrada = new Arquivo();
        Lista lista = new Lista();
        lista = entrada.extrair(caminho,opcao);
        Lista lista2 = lista.contarCasos(lista);
        Grafico grafico = new Grafico("Grafico de pessoas", tituloGrafico, lista2);
        grafico.pack();
        RefineryUtilities.centerFrameOnScreen(grafico);
        grafico.setVisible(true);
    }
}
