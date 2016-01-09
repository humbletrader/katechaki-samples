/**
 * 
 */
package net.sf.reportengine.samples.flat.customColumns;

import java.io.FileWriter;
import java.io.IOException;

import net.sf.reportengine.Report;
import net.sf.reportengine.components.FlatTable;
import net.sf.reportengine.components.ReportTitle;
import net.sf.reportengine.config.DefaultDataColumn;
import net.sf.reportengine.in.TextTableInput;
import net.sf.reportengine.out.HtmlReportOutput;

/**
 * @author dragos balan
 *
 */
public class MovingAverageReport {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FlatTable table = new FlatTable.Builder()
				.input(new TextTableInput("./inputData/EURUSD_2007-2009_FirstHours.txt","\t"))
				.addDataColumn(new DefaultDataColumn.Builder(0).header("Date").build())
				.addDataColumn(new DefaultDataColumn.Builder(1).header("Hour").build())
				.addDataColumn(new DefaultDataColumn.Builder(5).header("Price").build())
				.addDataColumn(new MovingAverageColumn("Moving AVG", 10, 5))
				.build(); 
		
		new Report.Builder(new HtmlReportOutput(new FileWriter("./output/movingAverage.html")))
			.add(new ReportTitle("This report contains a column with the computed Moving Average"))
			.add(table)
			.build()
		.execute();
	}

}
