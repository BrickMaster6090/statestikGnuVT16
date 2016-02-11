import java.time.LocalDate;

public enum Resolution {

	YEAR{
		public String trim(LocalDate date ){
			Integer yearDate;
			yearDate = date.getYear();
			
			return yearDate.toString() ;
			
		}
	},
	QUARTER{
public String trim(LocalDate date ){
	Integer yearDate;
	yearDate = date.getYear();
	Integer monthDate;
	monthDate = date.getMonthValue();
	Integer quarter;
	quarter = (monthDate + 2)/ 3;
	// tag månad plusa på 2 dividera med tre, måste vara int.
	
	
	String yearandquarter;
	yearandquarter = yearDate.toString() +" - " + quarter.toString();
	
	return yearandquarter ;
			
			
			
		}
	},
	MONTH{
public String trim(LocalDate date ){
	Integer yearDate;
	yearDate = date.getYear();
	Integer monthDate;
	monthDate = date.getMonthValue();
	
	String yearandmonth;
	
	yearandmonth = yearDate.toString() +" - "+ monthDate.toString();
	
	return yearandmonth;
			
		}
	},
	WEEK{
public String trim(LocalDate date ){
	Integer yearDate;
	yearDate = date.getYear();
	
	return yearDate.toString() ;
			
		}
	},
	DAY{
public String trim(LocalDate date ){
			return date.toString();
		}
	};
	
	public abstract String trim(LocalDate date );
	
}
