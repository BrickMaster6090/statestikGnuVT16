import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class test {
	
	DataCollectionBuilder testCollection;	
	DataCollection testCollections;
	Resolution res;
	MatchedDataPair mat;
	List testList = new ArrayList<>();
	List testList2 = new ArrayList<>();

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
		
		

	
		xData.setValue(LocalDate.now(), 10.0);
		xData.setValue(LocalDate.of(1994, 05, 27), 37.0);
		xData.setValue(LocalDate.of(1988, 11, 23), 52.0);
		xData.setValue(LocalDate.of(1994, 05, 3), 50.0);
		
			
		yData.setValue(LocalDate.now(), 12.0);
		yData.setValue(LocalDate.of(1994, 05, 27), 37.0);
		yData.setValue(LocalDate.of(1995, 10, 21), 52.0);
		yData.setValue(LocalDate.of(1994, 07, 27), 300.0);
		yData.setValue(LocalDate.of(1994, 05, 3), 21.0);
		
		
		
		testCollection = new DataCollectionBuilder(xData, yData, Resolution.DAY);
	
		
		testList = testCollection.GetList();

		

		
		
		
	}
	@Test
	public void testWeek() {
		
		DataSourceer xyearData = new DataSourceer();
		DataSourceer yyearData = new DataSourceer();
			
		xyearData.setValue(LocalDate.now(), 10.0);
		xyearData.setValue(LocalDate.of(1994, 05, 27), 37.0);
		xyearData.setValue(LocalDate.of(1988, 11, 23), 52.0);
		xyearData.setValue(LocalDate.of(1994, 05, 3), 50.0);
		xyearData.setValue(LocalDate.now(), 10.0);
		xyearData.setValue(LocalDate.of(1994, 05, 27), 37.0);
		xyearData.setValue(LocalDate.of(1988, 11, 23), 52.0);
		xyearData.setValue(LocalDate.of(1994, 05, 3), 50.0);
		
	
		
		
	}
	@Test
	public void testMonth() {
		
		DataSourceer  xmonthData = new DataSourceer();
		DataSourceer ymonthData = new DataSourceer();

		
		 xmonthData.setValue(LocalDate.now(), 10.0);
		 xmonthData.setValue(LocalDate.of(1994, 05, 27), 20.0); // finns j
		 xmonthData.setValue(LocalDate.of(1994, 05, 23), 52.0); //finns g
		 xmonthData.setValue(LocalDate.of(1995, 05, 3), 50.0); //finns d
		 xmonthData.setValue(LocalDate.of(1995, 03, 8), 50.0); //finns d
		 xmonthData.setValue(LocalDate.of(1995, 03, 27), 37.0);// 
		 xmonthData.setValue(LocalDate.of(1994, 04, 23), 52.0); // finns e
		 xmonthData.setValue(LocalDate.of(1996, 05, 3), 50.0); // finns l
		 xmonthData.setValue(LocalDate.of(1996, 05, 2), 50.0); // finns l
		 xmonthData.setValue(LocalDate.of(1997, 05, 2), 50.0); // finns l
		 
		
		 
		 ymonthData.setValue(LocalDate.now(), 12.0);
		 ymonthData.setValue(LocalDate.of(1994, 05, 27), 37.0); // j
		 ymonthData.setValue(LocalDate.of(1995, 10, 24), 52.0); // d
		 ymonthData.setValue(LocalDate.of(1995, 10, 21), 2.0); // d
		 ymonthData.setValue(LocalDate.of(1994, 07, 27), 300.0); // l
		 ymonthData.setValue(LocalDate.of(1995, 05, 3), 21.0); // l
		 ymonthData.setValue(LocalDate.of(1995, 05, 27), 37.0); // e 
		 ymonthData.setValue(LocalDate.of(1994, 10, 21), 52.0);
		 ymonthData.setValue(LocalDate.of(1995, 07, 27), 300.0); // g
		 ymonthData.setValue(LocalDate.of(1994, 05, 3), 21.0);
		 ymonthData.setValue(LocalDate.of(1996, 05, 19), 21.0);
		 ymonthData.setValue(LocalDate.of(1996, 05, 2), 21.0);
		 ymonthData.setValue(LocalDate.of(1996, 05, 1), 21.0);
		

		testCollection = new DataCollectionBuilder( xmonthData, ymonthData, Resolution.MONTH);
		
	}
	@Test
	public void testQuarter() {
		
		DataSourceer xQuarterData = new DataSourceer();
		DataSourceer yQuarterData = new DataSourceer();
			
		xQuarterData.setValue(LocalDate.now(), 10.0);
		xQuarterData.setValue(LocalDate.of(1994, 05, 27), 37.0);
		xQuarterData.setValue(LocalDate.of(1988, 11, 23), 52.0);
		xQuarterData.setValue(LocalDate.of(1994, 06, 3), 50.0);
		xQuarterData.setValue(LocalDate.of(1994, 04, 27), 37.0);
		xQuarterData.setValue(LocalDate.of(1988, 12, 23), 52.0);
		xQuarterData.setValue(LocalDate.of(1988, 8, 3), 50.0);
		
		 
		 yQuarterData.setValue(LocalDate.now(), 12.0);
		 yQuarterData.setValue(LocalDate.of(1994, 04, 27), 37.0); // j
		 yQuarterData.setValue(LocalDate.of(1994, 01, 24), 52.0); // d
		 yQuarterData.setValue(LocalDate.of(1988, 10, 21), 2.0); // d
		 yQuarterData.setValue(LocalDate.of(1991, 07, 27), 300.0); // l
		 yQuarterData.setValue(LocalDate.of(1991, 05, 3), 21.0); // l
		 yQuarterData.setValue(LocalDate.of(1982, 05, 27), 37.0); // e 
		 yQuarterData.setValue(LocalDate.of(1983, 10, 21), 52.0);
		
		 testCollection = new DataCollectionBuilder( xQuarterData, yQuarterData, Resolution.QUARTER);
		
	}
	@Test
	public void testYear() {
		DataSourceer  xyearData = new DataSourceer();
		DataSourceer yyearData = new DataSourceer();

		
		 xyearData.setValue(LocalDate.now(), 10.0);
		 xyearData.setValue(LocalDate.of(1994, 05, 27), 37.0); // finns j
		 xyearData.setValue(LocalDate.of(1988, 11, 23), 52.0); //finns g
		 xyearData.setValue(LocalDate.of(1988, 11, 5), 52.0);
		 xyearData.setValue(LocalDate.of(1995, 05, 3), 50.0); //finns d
		 xyearData.setValue(LocalDate.of(1995, 05, 8), 10.0); //finns d
		 xyearData.setValue(LocalDate.of(1982, 11, 23), 52.0); // finns e
		 xyearData.setValue(LocalDate.of(1991, 05, 3), 50.0); // finns l
		 xyearData.setValue(LocalDate.of(1996, 05, 27), 55.0);// 
		 xyearData.setValue(LocalDate.of(1996, 04, 29), 37.0);// 
		 
		 
		 
		 yyearData.setValue(LocalDate.now(), 12.0);
		 yyearData.setValue(LocalDate.of(1994, 05, 27), 37.0); // j
		 yyearData.setValue(LocalDate.of(1995, 10, 24), 52.0); // d
		 yyearData.setValue(LocalDate.of(1995, 10, 21), 2.0); // d
		 yyearData.setValue(LocalDate.of(1991, 07, 27), 300.0); // l
		 yyearData.setValue(LocalDate.of(1991, 05, 3), 21.0); // l
		 yyearData.setValue(LocalDate.of(1982, 05, 27), 37.0); // e 
		 yyearData.setValue(LocalDate.of(1983, 10, 21), 52.0);
		 yyearData.setValue(LocalDate.of(1988, 07, 27), 300.0); // g
		 yyearData.setValue(LocalDate.of(1900, 05, 3), 21.0);
		 yyearData.setValue(LocalDate.of(1996, 05, 27), 37.0);// 
		
		
		

		testCollection = new DataCollectionBuilder( xyearData, yyearData, Resolution.YEAR);
		
	}


}
