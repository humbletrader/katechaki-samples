/**
 * 
 */
package net.sf.reportengine.samples.output;

import java.io.FileWriter;
import java.io.IOException;

import net.sf.reportengine.Report;
import net.sf.reportengine.components.FlatTable;
import net.sf.reportengine.components.ReportTitle;
import net.sf.reportengine.config.DefaultDataColumn;
import net.sf.reportengine.in.TextTableInput;
import net.sf.reportengine.out.ExcelXmlReportOutput;

/**
 * this is a simple example of how to create excel output
 * 
 * @author dragos balan
 *
 */
public class ExcelOutputSample {
	
	public static void main(String[] args) throws IOException {
		
		FlatTable table = new FlatTable.Builder()
			.input(new TextTableInput("./inputData/expenses.csv",","))
			.addDataColumn(new DefaultDataColumn("Month",0))	
			.addDataColumn(new DefaultDataColumn("Spent on",1))
			.addDataColumn(new DefaultDataColumn("Amount",2))
			.build(); 
		
		new Report.Builder(new ExcelXmlReportOutput(new FileWriter("./output/myFirstExcelReport.xml")))
			.add(new ReportTitle("excel output report"))
			.add(table)
			.build()
		.execute();
	}
}
