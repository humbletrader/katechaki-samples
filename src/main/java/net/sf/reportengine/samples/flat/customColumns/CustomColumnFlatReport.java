/**
 * 
 */
package net.sf.reportengine.samples.flat.customColumns;

import java.io.FileWriter;
import java.io.IOException;

import net.sf.reportengine.Report;
import net.sf.reportengine.components.FlatTable;
import net.sf.reportengine.components.ReportTitle;
import net.sf.reportengine.in.TextTableInput;
import net.sf.reportengine.out.HtmlReportOutput;

/**
 * This report uses the {@link FullNameCustomDataColumn} custom created column
 * 
 * @author dragos balan
 */
public class CustomColumnFlatReport {

	public static void main(String[] args) throws IOException{
		
		FlatTable table = new FlatTable.Builder()
			.input(new TextTableInput("./inputData/names.txt","\t"))
			//this is a custom data column
			.addDataColumn(new FullNameCustomDataColumn())
			
			//another custom data column
			.addDataColumn(new SumCustomColumn())
		.build(); 
		
		new Report.Builder(new HtmlReportOutput(new FileWriter("./output/customColumnsResult.html")))
			.add(new ReportTitle("My custom columns report"))
			.add(table)
			.build()
		.execute(); 
	}
}
