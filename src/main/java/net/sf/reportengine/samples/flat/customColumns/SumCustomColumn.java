/**
 * 
 */
package net.sf.reportengine.samples.flat.customColumns;

import java.util.List;

import net.sf.reportengine.config.AbstractDataColumn;
import net.sf.reportengine.core.algorithm.NewRowEvent;

/**
 * this column holds the sum of the first and the third columns
 * 
 * @author dragos balan
 */
public class SumCustomColumn extends AbstractDataColumn {
	
	public SumCustomColumn(){
		super("Sum"); 
	}
	
	/* (non-Javadoc)
	 * @see net.sf.reportengine.config.IDataColumn#getValue(net.sf.reportengine.core.algorithm.NewRowEvent)
	 */
	@Override
	public Integer getValue(NewRowEvent newRowEvent) {
		List<Object> inputRow = newRowEvent.getInputDataRow(); 
		Integer firstColumn = Integer.valueOf(inputRow.get(0).toString());
		Integer thirdColumn = Integer.valueOf(inputRow.get(2).toString());
		return firstColumn + thirdColumn;
	}
}