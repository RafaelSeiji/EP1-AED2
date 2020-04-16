package EP_01;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.Collections;

public class Grafico extends ApplicationFrame {

    protected Grafico(String applicationTitle , String chartTitle, Lista lista ){
        super(applicationTitle );
        JFreeChart barChart = ChartFactory.createBarChart(applicationTitle ,"IDs","Valores",
                                                          createDataset(lista,chartTitle), PlotOrientation.VERTICAL, false, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(900, 700));
        setContentPane(chartPanel);
    }

    protected CategoryDataset createDataset(Lista lista, String desc){
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if(lista.inicio == null) return null;
        else{
            No aux = lista.inicio;
            float maior = 0;
            while (aux.prox != null){
                if(Collections.max(aux.frequentadores) > maior){
                    maior = Collections.max(aux.frequentadores);
                }
                aux = aux.prox;
            }
            aux = lista.inicio;
            while (aux.prox != null){
                String cox = Integer.toString(aux.coordenada_x);
                String coy = Integer.toString(aux.coordenada_y);
                String concat = cox + "_" + coy;
                if(aux.frequentadores.get(0) != 0){
                    dataset.addValue(aux.frequentadores.get(0),concat,desc);
                }
                aux = aux.prox;
            }
        }
        return dataset;
    }

}

