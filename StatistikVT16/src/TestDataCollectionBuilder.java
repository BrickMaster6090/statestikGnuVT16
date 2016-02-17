import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDataCollectionBuilder {
	
	DataCollectionBuilder testCollection;	
	DataCollection testCollections;
	Resolution res;
	MatchedDataPair mat;
	ArrayList<String> testData = new ArrayList<String>();

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testDay() {
		DataSourceer xData = new DataSourceer();
		DataSourceer yData = new DataSourceer();
		String xname = "Gnuer", yname = "Lejon",xunit="Antal",yunit="Antal";
		

	
		xData.setValue(xname,xunit,LocalDate.now(), 10.0);
		xData.setValue(xname,xunit,LocalDate.of(1994, 05, 27), 37.0);
		xData.setValue(xname,xunit,LocalDate.of(1988, 11, 23), 52.0);
		xData.setValue(xname,xunit,LocalDate.of(1994, 05, 3), 50.0);
		
			
		yData.setValue(yname,yunit,LocalDate.now(), 12.0);
		yData.setValue(yname,yunit,LocalDate.of(1994, 05, 27), 37.0);
		yData.setValue(yname,yunit,LocalDate.of(1995, 10, 21), 52.0);
		yData.setValue(yname,yunit,LocalDate.of(1994, 07, 27), 300.0);
		yData.setValue(yname,yunit,LocalDate.of(1994, 05, 3), 21.0);
		
		
		
		testCollection = new DataCollectionBuilder(xData, yData, Resolution.DAY);
				
		testData.add("1994-05-03");
		testData.add("1994-05-27");
		testData.add(LocalDate.now().toString());
	
		testOnData(testData);
		testOnNames(xname, yname);
		testOnUnit(xunit, yunit);
		
		
		
	}
	
	@Test
	public void testWeek() {
		
		DataSourceer xWeekData = new DataSourceer();
		DataSourceer yWeekData = new DataSourceer();
		String xname = "Gnuer", yname = "Lejon",xunit="Antal",yunit="Antal";
		
		

		xWeekData.setValue(xname,xunit,LocalDate.of(1994, 05, 27), 37.0);
		xWeekData.setValue(xname,xunit,LocalDate.of(1988, 11, 23), 52.0);
		xWeekData.setValue(xname,xunit,LocalDate.of(1994, 05, 3), 50.0);
		xWeekData.setValue(xname,xunit,LocalDate.now(), 10.0);
		xWeekData.setValue(xname,xunit,LocalDate.of(1994, 05, 27), 37.0);
		xWeekData.setValue(xname,xunit,LocalDate.of(1988, 11, 23), 52.0);
		xWeekData.setValue(xname,xunit,LocalDate.of(1994, 05, 3), 50.0);
		
		

		yWeekData.setValue(yname,yunit,LocalDate.of(1994, 05, 27), 37.0);
		yWeekData.setValue(yname,yunit,LocalDate.of(1995, 10, 21), 52.0);
		yWeekData.setValue(yname,yunit,LocalDate.of(1994, 07, 27), 300.0);
		yWeekData.setValue(yname,yunit,LocalDate.of(1994, 05, 3), 21.0);
		yWeekData.setValue(yname, yunit, LocalDate.of(1988, 11, 22), 27.0);
	
		testCollection = new DataCollectionBuilder(xWeekData, yWeekData, Resolution.WEEK);
	
		testData.add("1994 18");
		testData.add("1994 21");
		testData.add("1988 47");
		
		testOnData(testData);
		testOnNames(xname, yname);
		testOnUnit(xunit, yunit);
	}
	@Test
	public void testMonth() {
		
		DataSourceer  xmonthData = new DataSourceer();
		DataSourceer ymonthData = new DataSourceer();
		String xname = "Gnuer", yname = "Lejon",xunit="Antal",yunit="Antal";
		
		 xmonthData.setValue(xname,xunit,LocalDate.now(), 10.0);
		 xmonthData.setValue(xname,xunit,LocalDate.of(1994, 05, 27), 20.0); // finns j
		 xmonthData.setValue(xname,xunit,LocalDate.of(1994, 05, 23), 52.0); //finns g
		 xmonthData.setValue(xname,xunit,LocalDate.of(1995, 05, 3), 50.0); //finns d
		 xmonthData.setValue(xname,xunit,LocalDate.of(1995, 03, 8), 50.0); //finns d
		 xmonthData.setValue(xname,xunit,LocalDate.of(1995, 03, 27), 37.0);// 
		 xmonthData.setValue(xname,xunit,LocalDate.of(1994, 04, 23), 52.0); // finns e
		 xmonthData.setValue(xname,xunit,LocalDate.of(1996, 05, 3), 50.0); // finns l
		 xmonthData.setValue(xname,xunit,LocalDate.of(1996, 05, 2), 50.0); // finns l
		 xmonthData.setValue(xname,xunit,LocalDate.of(1997, 05, 2), 50.0); // finns l
		 
		
		 
		 ymonthData.setValue(yname,yunit,LocalDate.now(), 12.0);
		 ymonthData.setValue(yname,yunit,LocalDate.of(1994, 05, 27), 37.0); // j
		 ymonthData.setValue(yname,yunit,LocalDate.of(1995, 10, 24), 52.0); // d
		 ymonthData.setValue(yname,yunit,LocalDate.of(1995, 10, 21), 2.0); // d
		 ymonthData.setValue(yname,yunit,LocalDate.of(1994, 07, 27), 300.0); // l
		 ymonthData.setValue(yname,yunit,LocalDate.of(1995, 05, 3), 21.0); // l
		 ymonthData.setValue(yname,yunit,LocalDate.of(1995, 05, 27), 37.0); // e 
		 ymonthData.setValue(yname,yunit,LocalDate.of(1994, 10, 21), 52.0);
		 ymonthData.setValue(yname,yunit,LocalDate.of(1995, 07, 27), 300.0); // g
		 ymonthData.setValue(yname,yunit,LocalDate.of(1994, 05, 3), 21.0);
		 ymonthData.setValue(yname,yunit,LocalDate.of(1996, 05, 19), 21.0);
		 ymonthData.setValue(yname,yunit,LocalDate.of(1996, 05, 2), 21.0);
		 ymonthData.setValue(yname,yunit,LocalDate.of(1996, 05, 1), 21.0);
		

		testCollection = new DataCollectionBuilder( xmonthData, ymonthData, Resolution.MONTH);
	
		testData.add("1995 05");
		testData.add("1996 05");
		testData.add("1994 05");
		testData.add("2016 02");
		
		testOnData(testData);
		testOnNames(xname, yname);
		testOnUnit(xunit, yunit);
		
		
		
	}
	@Test
	public void testQuarter() {
		
		DataSourceer xQuarterData = new DataSourceer();
		DataSourceer yQuarterData = new DataSourceer();
		String xname = "Gnuer", yname = "Lejon",xunit="Antal",yunit="Antal";
		
		
		xQuarterData.setValue(xname,xunit,LocalDate.now(), 10.0);
		xQuarterData.setValue(xname,xunit,LocalDate.of(1994, 05, 27), 37.0);
		xQuarterData.setValue(xname,xunit,LocalDate.of(1988, 11, 23), 52.0);
		xQuarterData.setValue(xname,xunit,LocalDate.of(1994, 06, 3), 50.0);
		xQuarterData.setValue(xname,xunit,LocalDate.of(1994, 04, 27), 37.0);
		xQuarterData.setValue(xname,xunit,LocalDate.of(1988, 12, 23), 52.0);
		xQuarterData.setValue(xname,xunit,LocalDate.of(1988, 8, 3), 50.0);
		
		 
		 yQuarterData.setValue(yname,yunit,LocalDate.now(), 12.0);
		 yQuarterData.setValue(yname,yunit,LocalDate.of(1994, 04, 27), 37.0); // j
		 yQuarterData.setValue(yname,yunit,LocalDate.of(1994, 01, 24), 52.0); // d
		 yQuarterData.setValue(yname,yunit,LocalDate.of(1988, 10, 21), 2.0); // d
		 yQuarterData.setValue(yname,yunit,LocalDate.of(1991, 07, 27), 300.0); // l
		 yQuarterData.setValue(yname,yunit,LocalDate.of(1991, 05, 3), 21.0); // l
		 yQuarterData.setValue(yname,yunit,LocalDate.of(1982, 05, 27), 37.0); // e 
		 yQuarterData.setValue(yname,yunit,LocalDate.of(1983, 10, 21), 52.0);
		

		 testCollection = new DataCollectionBuilder( xQuarterData, yQuarterData, Resolution.QUARTER);

		
		 	testData.add("1988 4");
			testData.add("2016 1");
			testData.add("1994 2");
			
			
			testOnData(testData);
			testOnNames(xname, yname);
			testOnUnit(xunit, yunit);
	}
	@Test
	public void testYear() {
		DataSourceer  xyearData = new DataSourceer();
		DataSourceer yyearData = new DataSourceer();
		String xname = "Gnuer", yname = "Katter",xunit="Antal",yunit="Antal";
		
		 xyearData.setValue(xname,xunit,LocalDate.now(), 10.0);
		 xyearData.setValue(xname,xunit,LocalDate.of(1994, 05, 27), 37.0); // finns j
		 xyearData.setValue(xname,xunit,LocalDate.of(1988, 11, 23), 52.0); //finns g
		 xyearData.setValue(xname,xunit,LocalDate.of(1988, 11, 5), 52.0);
		 xyearData.setValue(xname,xunit,LocalDate.of(1995, 05, 3), 50.0); //finns d
		 xyearData.setValue(xname,xunit,LocalDate.of(1995, 05, 8), 10.0); //finns d
		 xyearData.setValue(xname,xunit,LocalDate.of(1982, 11, 23), 52.0); // finns e
		 xyearData.setValue(xname,xunit,LocalDate.of(1991, 05, 3), 50.0); // finns l
		 xyearData.setValue(xname,xunit,LocalDate.of(1996, 05, 27), 55.0);// 
		 xyearData.setValue(xname,xunit,LocalDate.of(1996, 04, 29), 37.0);// 
		 
		 
		 
		 yyearData.setValue(yname,yunit,LocalDate.now(), 12.0);
		 yyearData.setValue(yname,yunit,LocalDate.of(1994, 05, 27), 37.0); // j
		 yyearData.setValue(yname,yunit,LocalDate.of(1995, 10, 24), 52.0); // d
		 yyearData.setValue(yname,yunit,LocalDate.of(1995, 10, 21), 2.0); // d
		 yyearData.setValue(yname,yunit,LocalDate.of(1991, 07, 27), 300.0); // l
		 yyearData.setValue(yname,yunit,LocalDate.of(1991, 05, 3), 21.0); // l
		 yyearData.setValue(yname,yunit,LocalDate.of(1982, 05, 27), 37.0); // e 
		 yyearData.setValue(yname,yunit,LocalDate.of(1983, 10, 21), 52.0);
		 yyearData.setValue(yname,yunit,LocalDate.of(1988, 07, 27), 300.0); // g
		 yyearData.setValue(yname,yunit,LocalDate.of(1900, 05, 3), 21.0);
		 yyearData.setValue(yname,yunit,LocalDate.of(1996, 05, 27), 37.0);// 
		
		
		testCollection = new DataCollectionBuilder( xyearData, yyearData, Resolution.YEAR);
	 	
		testData.add("1996");
		testData.add("1995");
		testData.add("1994");
		testData.add("2016");
		testData.add("1982");
		testData.add("1991");
		testData.add("1988");
		
		
		
		testOnData(testData);
		testOnNames(xname, yname);
		testOnUnit(xunit, yunit);
	}
	
	private void testOnData(ArrayList<String> testNames){
		int i = 0;
		for (String testKey : testCollection.getResult().getData().keySet()) {

			assertEquals(testNames.get(i), testKey);
			i++;
		}
		testData.clear();
		
		
	}
	private void testOnNames(String xname,String yname){
		
		assertEquals(xname+"/"+yname, testCollection.getTitle());
		
	}
	private void testOnUnit(String xunit,String yunit){
		
		assertEquals(xunit, testCollection.getResult().getXUnit());
		assertEquals(yunit, testCollection.getResult().getYUnit());
		
	}


}
