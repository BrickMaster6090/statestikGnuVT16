import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ntn13dcm
 * @author ofk14den
 * @version 2016-02-17
 */
public class DataSourcerBuilder implements DataSource {

	Map<LocalDate, Double> DataValue = new HashMap<LocalDate, Double>();
	List<String> nameandunit = new ArrayList<String>();

	/**
	 * Constructor of the DataSourceer Class
	 */
	public DataSourcerBuilder() {

	}

	@Override
	public String getName() {

		return nameandunit.get(0).toString();
	}

	@Override
	public String getUnit() {

		return nameandunit.get(1).toString();
	}

	/**
	 * adds the values to a Map and sort it
	 * 
	 * @param name
	 *            String
	 * @param unit
	 *            String
	 * @param date
	 *            LocalDate
	 * @param value
	 *            Double
	 */
	public void setValue(String name, String unit, LocalDate date, Double value) {
		DataValue.put(date, value);
		sortData();

		nameandunit.add(name);
		nameandunit.add(unit);
		;

	}

	@Override
	public Map<LocalDate, Double> getData() {

		return DataValue;
	}

	private void sortData() {
		DataValue = new TreeMap<LocalDate, Double>(DataValue);
	}

}
