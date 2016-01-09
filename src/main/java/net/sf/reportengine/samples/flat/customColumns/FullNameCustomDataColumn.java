/**
 * 
 */
package net.sf.reportengine.samples.flat.customColumns;

import java.util.List;

import net.sf.reportengine.config.AbstractDataColumn;
import net.sf.reportengine.core.algorithm.NewRowEvent;

/**
 * This custom column contains the appended values 
 * of the second and the fourth columns 
 */
public class FullNameCustomDataColumn extends AbstractDataColumn {
	
	/**
	 * Constructor for 
	 * @param header
	 */
	public FullNameCustomDataColumn(){
		super("Full Name");//column header
	}
	
	/* (non-Javadoc)
	 * @see net.sf.reportengine.config.IDataColumn#getValue(net.sf.reportengine.core.algorithm.NewRowEvent)
	 */
	@Override
	public String getValue(NewRowEvent newRowEvent) {
		List<Object> inputRow = newRowEvent.getInputDataRow(); 
		String secondColumnValue = (String)inputRow.get(1); 
		String fourthColumnValue = (String)inputRow.get(3);
		
		//append the second and fourth column values
		return secondColumnValue + " " + fourthColumnValue;
		//the string concatenation is just for instructional purposes. 
	}
}