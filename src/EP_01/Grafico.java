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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Grafico extends ApplicationFrame {

    protected Grafico(String applicationTitle , String chartTitle, HashMap<Integer,Integer> mapa ){
        super(applicationTitle );
        JFreeChart barChart = ChartFactory.createBarChart(applicationTitle ,"IDs das localizacoes","Pessoas por local",
                                                          createDataset(mapa,chartTitle), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(900, 700));
        setContentPane(chartPanel);
    }

    protected CategoryDataset createDataset(HashMap<Integer,Integer> mapa, String desc){
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if(mapa.isEmpty()) return null;
        else{
            Iterator it = mapa.entrySet().iterator();
            for(Map.Entry<Integer,Integer> pair : mapa.entrySet()){
                dataset.addValue(pair.getKey(),pair.getValue(),desc);
            }
        }
        return dataset;
    }

}

