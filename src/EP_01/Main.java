package EP_01;

import org.jfree.chart.demo.BarChartDemo1;
import org.jfree.ui.RefineryUtilities;

public class Main {
    public static void main(String[] args) {
        String caminho = "C:\\Users\\gabri\\Desktop\\Faculdade\\AED2\\EPs\\EP1\\OD_2017.csv";
        Arquivo entrada = new Arquivo();
        Lista lista = new Lista();
        lista = entrada.extrair(caminho);
        Grafico grafico = new Grafico("Grafico de pessoas", "Numero de IDs por coordenada", lista);
        grafico.pack();
        RefineryUtilities.centerFrameOnScreen(grafico);
        grafico.setVisible(true);
    }
}
