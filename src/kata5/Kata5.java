package kata5;

import java.sql.SQLException;
import java.util.List;
import kata5.model.Histogram;
import kata5.model.Mail;
import kata5.view.HistogramDisplay;
import kata5.view.MailDatabaseReader;
import kata5.view.MailHistogramBuilder;

public class Kata5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        List<Mail> mailList = MailDatabaseReader.read();

        Histogram<String> histogram = MailHistogramBuilder.build(mailList);

        HistogramDisplay histogramDisplay = new HistogramDisplay(histogram, "HISTOGRAM");
        histogramDisplay.execute(); 
    }
}
