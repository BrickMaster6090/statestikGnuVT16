import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DataSourceer implements DataSource {

	Map<LocalDate, Double> DataValue = new HashMap<LocalDate, Double>();
	Map<List<String>,Map<LocalDate,Double>> tmep = new HashMap<List<String>, Map<LocalDate,Double>>();
	List<String> nameandunit = new ArrayList<String>();
	
	public DataSourceer() {

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		
		return nameandunit.get(0).toString() ;
	}

	@Override
	public String getUnit() {
		
		return nameandunit.get(1).toString();
	}

	public void setValue(String name,String unit, LocalDate date, Double value) {
		DataValue.put(date, value);
		sortData();
	
		nameandunit.add(name);
		nameandunit.add(unit);;
		
		
	}

	@Override
	public Map<LocalDate, Double> getData() {
		// TODO Auto-generated method stub

		return DataValue;
	}

	// sorterings koden
	// http://beginnersbook.com/2013/12/how-to-sort-hashmap-in-java-by-keys-and-values/
	private void sortData() {
		DataValue = new TreeMap<LocalDate, Double>(DataValue);
	}

}
