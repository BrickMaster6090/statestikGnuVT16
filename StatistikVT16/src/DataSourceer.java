import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DataSourceer implements DataSource {

	Map<LocalDate, Double> DataValue = new HashMap<LocalDate, Double>();
	Map<LocalDate, Double> sortDataValue;
	public DataSourceer() {

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setValue(LocalDate date, Double value) {

		DataValue.put(date, value);
		sortData();
		
	}

	@Override
	public Map<LocalDate, Double> getData() {
		// TODO Auto-generated method stub

		return sortDataValue;
	}

	// sorterings koden
	// http://beginnersbook.com/2013/12/how-to-sort-hashmap-in-java-by-keys-and-values/
	private void sortData() {
		sortDataValue = new TreeMap<LocalDate, Double>(DataValue);

		Set set = sortDataValue.entrySet();

		Iterator iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry sortmap = (Map.Entry) iterator.next();
			
			
		
		}
	
	}

}
