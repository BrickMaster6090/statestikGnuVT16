import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum Resolution {

	YEAR{
		public String trim(LocalDate date ){
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
			String year = date.format(formatter);
			
			return year;
			
		}
	},
	QUARTER{
public String trim(LocalDate date ){
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy Q");
	String quater = date.format(formatter);
	
	
	
	
	return quater ;
			
			
			
		}
	},
	MONTH{
public String trim(LocalDate date ){
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM");
	String month = date.format(formatter);
	
	
	return month;
			
		}
	},
	WEEK{
public String trim(LocalDate date ){
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy w");
	String week = date.format(formatter);
	
	
	
	
	return week ;
			
		}
	},
	DAY{
public String trim(LocalDate date ){
			return date.toString();
		}
	};
	
	public abstract String trim(LocalDate date );
		
	
	
}
