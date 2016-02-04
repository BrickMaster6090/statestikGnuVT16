import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.LoggingMXBean;

public class DataCollectionBuilder {
	
	private DataSource xData;
	private DataSource yData;
	private Resolution resolution;
	private Map<String,List<MatchedDataPair>> reultData;
	private Map<String,MatchedDataPair> finalResult;
	
	
	public DataCollectionBuilder(DataSource xData,DataSource yData,Resolution resolution){
		
	}
	public String getTitle(){
		
		return xData+ "  " +yData;
		
	}
	public DataCollection getResult(){
		
		
	
		return ;
	}
	
	
	private void CalculateData() {

		MatchedDataPair matchdatapair;
		for(int i = 0; i<xData.getData().size();i++){
	
			Set<LocalDate> Key = xData.getData().keySet();
					
			for( LocalDate comaprekey: yData.getData().keySet()){
				
				if(Key.equals(comaprekey) ){
					matchdatapair = new MatchedDataPair(xData.getData().get(Key), yData.getData().get(Key));
					
				}
				
			}
			
			
		}
	 
		
		return ;
	
	
	
}
}
