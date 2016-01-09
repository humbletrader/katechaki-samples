/**
 * 
 */
package net.sf.reportengine.samples.input;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.sf.reportengine.Report;
import net.sf.reportengine.components.FlatTable;
import net.sf.reportengine.components.ReportTitle;
import net.sf.reportengine.config.DefaultDataColumn;
import net.sf.reportengine.in.TextTableInput;
import net.sf.reportengine.out.HtmlReportOutput;

/**
 * this report gets its data from an url
 * 
 * @author dragos balan
 *
 */
public class InputFromUrl {
	
	
	public static void main(String[] args) {
		try {
			URL fileUrl = new URL("http://svn.code.sf.net/p/reportengine/code/trunk/reportengine-samples/inputData/expenses.csv");
			
			FlatTable table = new FlatTable.Builder()
				.input(new TextTableInput(new InputStreamReader(fileUrl.openStream()),","))
				.addDataColumn(new DefaultDataColumn("Month",0))	
				.addDataColumn(new DefaultDataColumn("Spent on",1))
				.addDataColumn(new DefaultDataColumn("Amount",2))
				.build(); 
			
			new Report.Builder(new HtmlReportOutput(new FileWriter("./output/outReportFromUrl.html")))
				.add(new ReportTitle("This report gets its input data from an URL"))
				.add(table)
				.build()
			.execute();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
