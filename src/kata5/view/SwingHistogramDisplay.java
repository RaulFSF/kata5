package kata5.view;

import javax.swing.JPanel;
import kata5.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class SwingHistogramDisplay extends ApplicationFrame implements HistogramDisplay{
    private final Histogram<String> histogram;
    
    public SwingHistogramDisplay(String tittle, Histogram histogram){
        super(tittle);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }
    
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        return chartPanel;
    }
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("JFreeChart Histrogram", 
                                                    "email domains", 
                                                    "nº emails", 
                                                    dataSet, 
                                                    PlotOrientation.VERTICAL, 
                                                    false, 
                                                    false, 
                                                    rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int others = 0;
        for(String key: this.histogram.keySet()){
            if(this.histogram.get(key)==1){
                others++;
            } else{
                dataset.addValue(histogram.get(key),"", key);
            }
        }
        dataset.addValue(others, "", "Otros");
        return dataset;
    }
    
    @Override
    public void execute(){this.setVisible(true);}
 
}
