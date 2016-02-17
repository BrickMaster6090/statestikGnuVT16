import java.time.LocalDate;
import java.util.Map;

/**
 * @author ntn13dcm
 * @author ofk14den
 * @version 2016-02-17
 */
public interface DataSource {

	/**
	 * returns the name of the DataSource
	 * 
	 * @return String
	 */
	public String getName();

	/**
	 * returns the unit of the DataSource
	 * 
	 * @return String
	 */
	public String getUnit();

	/**
	 * returns the data from DataSource
	 * 
	 * @return Map<LocalDate, Double>
	 */
	public Map<LocalDate, Double> getData();

}
