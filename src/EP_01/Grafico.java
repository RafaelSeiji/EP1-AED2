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

    protected Grafico(String tituloApp, String tituloGrafico){
        super(tituloApp);
        JFreeChart barChart = ChartFactory.createBarChart(tituloGrafico,"IDs","Valores",
                                                          createDataset(), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    protected CategoryDataset createDataset(Lista lista){
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if(lista.inicio == null) return null;
        else{
            No aux = lista.inicio;
            while (aux.prox != null){
                dataset.addValue();
            }
        }
    }

}
