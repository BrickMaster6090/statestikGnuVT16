import java.time.LocalDate;
import java.util.Map;

public interface DataSource {
	
	public String getName();
	
	public String getUnit();
	//fråga åke
	public Map<LocalDate, Double> getData();

}
