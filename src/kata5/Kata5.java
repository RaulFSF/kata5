package kata5;

import kata5.model.Histogram;
import kata5.view.PeopleLoader;
import kata5.view.SqlitePeopleLoader;
import kata5.view.SwingHistogramDisplay;

public class Kata5 {

    public static void main(String[] args) {
        PeopleLoader pl = new SqlitePeopleLoader();
        Histogram<String> histogram = new Histogram();
        pl.load().forEach(person -> {
            histogram.increment(person.getEmailDomain());
        });
        new SwingHistogramDisplay("Histogram", histogram);
    }
    
}
