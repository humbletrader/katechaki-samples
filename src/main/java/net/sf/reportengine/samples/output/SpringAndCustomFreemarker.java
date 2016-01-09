/**
 * 
 */
package net.sf.reportengine.samples.output;

import net.sf.reportengine.Report;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dragos balan
 *
 */
public class SpringAndCustomFreemarker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//load spring context from src/main/resources/application-context.xml
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-custom-freemarker-template.xml");
		Report report = (Report)context.getBean("customFreemarkerReport");
		report.execute();
	}
}
