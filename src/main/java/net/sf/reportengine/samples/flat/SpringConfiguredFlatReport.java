/**
 * 
 */
package net.sf.reportengine.samples.flat;

import net.sf.reportengine.Report;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * this is your first spring configured flat report
 * 
 * @author dragos balan
 */
public class SpringConfiguredFlatReport {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//load spring context from src/main/resources/application-context.xml
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		Report report = (Report)context.getBean("expensesReport");
		report.execute();
	}
}
