/**
 * 
 */
package net.sf.reportengine.samples.flat.customColumns;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

import net.sf.reportengine.config.AbstractDataColumn;
import net.sf.reportengine.core.algorithm.NewRowEvent;

/**
 * Custom column which calculates the moving averages of the values from another column
 * 
 * @author dragos balan
 */
public class MovingAverageColumn extends AbstractDataColumn {
	
	private Queue<BigDecimal> lastXValues = new LinkedList<BigDecimal>(); 
	private final int DATA_COLUMN_INDEX; 
	private final int VALUES_COUNT; 
	
	/**
	 * Constructor for the moving average column. 
	 * 
	 * @param header			the header of the column
	 * @param values			the number of values to be taken into account for this moving average
	 * @param dataColumnIndex	the index of the data column for which you want to compute the moving average
	 */
	public MovingAverageColumn(String header, int values, int dataColumnIndex){
		super(header); 
		DATA_COLUMN_INDEX = dataColumnIndex; 
		VALUES_COUNT = values; 
	}

	@Override
	public Object getValue(NewRowEvent newRowEvent) {
		//prepare the queue ( in case there's more than x values -> delete the last one)
		if(lastXValues.size() == VALUES_COUNT){
			lastXValues.poll(); 
		}
		
		//detect the new value which will be added to the queue of the last x values
		BigDecimal value = new BigDecimal((String)newRowEvent.getInputDataRow().get(DATA_COLUMN_INDEX)); 
		lastXValues.add(value);
		
		//computing the result
		BigDecimal result = null; 
		if(lastXValues.size() < VALUES_COUNT){
			result = BigDecimal.ZERO; 
		}else{
			result = computeAverage(); 
		}
		return result;
	}
	
	private BigDecimal computeAverage(){
		BigDecimal result = BigDecimal.ZERO; 
		for (Object value : lastXValues) {
			result = result.add(new BigDecimal(value.toString())); 
		}
		return result.divide(new BigDecimal(VALUES_COUNT)); 
	}
}
