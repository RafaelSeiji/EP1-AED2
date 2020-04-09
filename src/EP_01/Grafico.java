package EP_01;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Grafico extends ApplicationFrame {

    protected Grafico(String applicationTitle , String chartTitle, Lista lista ){
        super(applicationTitle );
        JFreeChart barChart = ChartFactory.createBarChart(applicationTitle ,"IDs","Valores",
                                                          createDataset(lista), PlotOrientation.VERTICAL, false, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1920, 1080));
        setContentPane(chartPanel);
    }

    protected CategoryDataset createDataset(Lista lista){
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if(lista.inicio == null) return null;
        else{
            No aux = lista.inicio;
            while (aux.prox != null){
                String cox = Integer.toString(aux.coordenada_x);
                String coy = Integer.toString(aux.coordenada_y);
                String concat = cox + "_" + coy;
                dataset.addValue((aux.frequentadores.size()-1),concat,"Frequentadores");
                aux = aux.prox;
            }
        }
        return dataset;
    }

}

