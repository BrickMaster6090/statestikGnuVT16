import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDataCollectionBuilder {

	DataCollectionBuilder testCollection;
	Resolution resolution;
	MatchedDataPair matchedDataPair;
	ArrayList<String> testData = new ArrayList<String>();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDay() {
		DataSourcerBuilder xData = new DataSourcerBuilder();
		DataSourcerBuilder yData = new DataSourcerBuilder();
		String xName = "Gnuer", yName = "Lejon", xUnit = "Antal", yUnit = "Antal";

		xData.setValue(xName, xUnit, LocalDate.of(1994, 05, 27), 37.0);
		xData.setValue(xName, xUnit, LocalDate.of(1988, 11, 23), 52.0);
		xData.setValue(xName, xUnit, LocalDate.of(1994, 05, 3), 50.0);

		yData.setValue(yName, yUnit, LocalDate.of(1994, 05, 27), 37.0);
		yData.setValue(yName, yUnit, LocalDate.of(1995, 10, 21), 52.0);
		yData.setValue(yName, yUnit, LocalDate.of(1994, 07, 27), 300.0);
		yData.setValue(yName, yUnit, LocalDate.of(1994, 05, 3), 21.0);

		testCollection = new DataCollectionBuilder(xData, yData, Resolution.DAY);

		testData.add("1994-05-03");
		testData.add("1994-05-27");

		testOnData(testData);
		testOnNames(xName, yName);
		testOnUnit(xUnit, yUnit);

	}

	@Test
	public void testWeek() {

		DataSourcerBuilder xWeekData = new DataSourcerBuilder();
		DataSourcerBuilder yWeekData = new DataSourcerBuilder();
		String xName = "Gnuer", yName = "Lejon", xUnit = "Antal", yUnit = "Antal";

		xWeekData.setValue(xName, xUnit, LocalDate.of(1994, 05, 27), 37.0);
		xWeekData.setValue(xName, xUnit, LocalDate.of(1988, 11, 23), 52.0);
		xWeekData.setValue(xName, xUnit, LocalDate.of(1994, 05, 3), 50.0);
		xWeekData.setValue(xName, xUnit, LocalDate.now(), 10.0);
		xWeekData.setValue(xName, xUnit, LocalDate.of(1994, 05, 27), 37.0);
		xWeekData.setValue(xName, xUnit, LocalDate.of(1988, 11, 23), 52.0);
		xWeekData.setValue(xName, xUnit, LocalDate.of(1994, 05, 3), 50.0);

		yWeekData.setValue(yName, yUnit, LocalDate.of(1994, 05, 27), 37.0);
		yWeekData.setValue(yName, yUnit, LocalDate.of(1995, 10, 21), 52.0);
		yWeekData.setValue(yName, yUnit, LocalDate.of(1994, 07, 27), 300.0);
		yWeekData.setValue(yName, yUnit, LocalDate.of(1994, 05, 3), 21.0);
		yWeekData.setValue(yName, yUnit, LocalDate.of(1988, 11, 22), 27.0);

		testCollection = new DataCollectionBuilder(xWeekData, yWeekData,
				Resolution.WEEK);

		testData.add("1994 18");
		testData.add("1994 21");
		testData.add("1988 47");

		testOnData(testData);
		testOnNames(xName, yName);
		testOnUnit(xUnit, yUnit);
	}

	@Test
	public void testMonth() {

		DataSourcerBuilder xMonthData = new DataSourcerBuilder();
		DataSourcerBuilder yMonthData = new DataSourcerBuilder();
		String xName = "Gnuer", yName = "Lejon", xUnit = "Antal", yUnit = "Antal";

		xMonthData.setValue(xName, xUnit, LocalDate.now(), 10.0);
		xMonthData.setValue(xName, xUnit, LocalDate.of(1994, 05, 27), 20.0);
		xMonthData.setValue(xName, xUnit, LocalDate.of(1994, 05, 23), 52.0);
		xMonthData.setValue(xName, xUnit, LocalDate.of(1995, 05, 3), 50.0);
		xMonthData.setValue(xName, xUnit, LocalDate.of(1995, 03, 8), 50.0);
		xMonthData.setValue(xName, xUnit, LocalDate.of(1995, 03, 27), 37.0);
		xMonthData.setValue(xName, xUnit, LocalDate.of(1994, 04, 23), 52.0);
		xMonthData.setValue(xName, xUnit, LocalDate.of(1996, 05, 3), 50.0);
		xMonthData.setValue(xName, xUnit, LocalDate.of(1996, 05, 2), 50.0);
		xMonthData.setValue(xName, xUnit, LocalDate.of(1997, 05, 2), 50.0);

		yMonthData.setValue(yName, yUnit, LocalDate.now(), 12.0);
		yMonthData.setValue(yName, yUnit, LocalDate.of(1994, 05, 27), 37.0);
		yMonthData.setValue(yName, yUnit, LocalDate.of(1995, 10, 24), 52.0);
		yMonthData.setValue(yName, yUnit, LocalDate.of(1995, 10, 21), 2.0);
		yMonthData.setValue(yName, yUnit, LocalDate.of(1994, 07, 27), 300.0);
		yMonthData.setValue(yName, yUnit, LocalDate.of(1995, 05, 3), 21.0);
		yMonthData.setValue(yName, yUnit, LocalDate.of(1995, 05, 27), 37.0);
		yMonthData.setValue(yName, yUnit, LocalDate.of(1994, 10, 21), 52.0);
		yMonthData.setValue(yName, yUnit, LocalDate.of(1995, 07, 27), 300.0);
		yMonthData.setValue(yName, yUnit, LocalDate.of(1994, 05, 3), 21.0);
		yMonthData.setValue(yName, yUnit, LocalDate.of(1996, 05, 19), 21.0);
		yMonthData.setValue(yName, yUnit, LocalDate.of(1996, 05, 2), 21.0);
		yMonthData.setValue(yName, yUnit, LocalDate.of(1996, 05, 1), 21.0);

		testCollection = new DataCollectionBuilder(xMonthData, yMonthData,
				Resolution.MONTH);

		testData.add("1995 05");
		testData.add("1996 05");
		testData.add("1994 05");
		testData.add("2016 02");

		testOnData(testData);
		testOnNames(xName, yName);
		testOnUnit(xUnit, yUnit);

	}

	@Test
	public void testQuarter() {

		DataSourcerBuilder xQuarterData = new DataSourcerBuilder();
		DataSourcerBuilder yQuarterData = new DataSourcerBuilder();
		String xName = "Gnuer", yName = "Lejon", xUnit = "Antal", yUnit = "Antal";

		xQuarterData.setValue(xName, xUnit, LocalDate.now(), 10.0);
		xQuarterData.setValue(xName, xUnit, LocalDate.of(1994, 05, 27), 37.0);
		xQuarterData.setValue(xName, xUnit, LocalDate.of(1988, 11, 23), 52.0);
		xQuarterData.setValue(xName, xUnit, LocalDate.of(1994, 06, 3), 50.0);
		xQuarterData.setValue(xName, xUnit, LocalDate.of(1994, 04, 27), 37.0);
		xQuarterData.setValue(xName, xUnit, LocalDate.of(1988, 12, 23), 52.0);
		xQuarterData.setValue(xName, xUnit, LocalDate.of(1988, 8, 3), 50.0);

		yQuarterData.setValue(yName, yUnit, LocalDate.now(), 12.0);
		yQuarterData.setValue(yName, yUnit, LocalDate.of(1994, 04, 27), 37.0);
		yQuarterData.setValue(yName, yUnit, LocalDate.of(1994, 01, 24), 52.0);
		yQuarterData.setValue(yName, yUnit, LocalDate.of(1988, 10, 21), 2.0);
		yQuarterData.setValue(yName, yUnit, LocalDate.of(1991, 07, 27), 300.0);
		yQuarterData.setValue(yName, yUnit, LocalDate.of(1991, 05, 3), 21.0);
		yQuarterData.setValue(yName, yUnit, LocalDate.of(1982, 05, 27), 37.0);
		yQuarterData.setValue(yName, yUnit, LocalDate.of(1983, 10, 21), 52.0);

		testCollection = new DataCollectionBuilder(xQuarterData, yQuarterData,
				Resolution.QUARTER);

		testData.add("1988 4");
		testData.add("2016 1");
		testData.add("1994 2");

		testOnData(testData);
		testOnNames(xName, yName);
		testOnUnit(xUnit, yUnit);
	}

	@Test
	public void testYear() {
		DataSourcerBuilder xYearData = new DataSourcerBuilder();
		DataSourcerBuilder yYearData = new DataSourcerBuilder();
		String xName = "Gnuer", yName = "Katter", xUnit = "Antal", yUnit = "Antal";

		xYearData.setValue(xName, xUnit, LocalDate.now(), 10.0);
		xYearData.setValue(xName, xUnit, LocalDate.of(1994, 05, 27), 37.0);
		xYearData.setValue(xName, xUnit, LocalDate.of(1988, 11, 23), 52.0);
		xYearData.setValue(xName, xUnit, LocalDate.of(1988, 11, 5), 52.0);
		xYearData.setValue(xName, xUnit, LocalDate.of(1995, 05, 3), 50.0);
		xYearData.setValue(xName, xUnit, LocalDate.of(1995, 05, 8), 10.0);
		xYearData.setValue(xName, xUnit, LocalDate.of(1982, 11, 23), 52.0);
		xYearData.setValue(xName, xUnit, LocalDate.of(1991, 05, 3), 50.0);
		xYearData.setValue(xName, xUnit, LocalDate.of(1996, 05, 27), 55.0);
		xYearData.setValue(xName, xUnit, LocalDate.of(1996, 04, 29), 37.0);

		yYearData.setValue(yName, yUnit, LocalDate.now(), 12.0);
		yYearData.setValue(yName, yUnit, LocalDate.of(1994, 05, 27), 37.0);
		yYearData.setValue(yName, yUnit, LocalDate.of(1995, 10, 24), 52.0);
		yYearData.setValue(yName, yUnit, LocalDate.of(1995, 10, 21), 2.0);
		yYearData.setValue(yName, yUnit, LocalDate.of(1991, 07, 27), 300.0);
		yYearData.setValue(yName, yUnit, LocalDate.of(1991, 05, 3), 21.0);
		yYearData.setValue(yName, yUnit, LocalDate.of(1982, 05, 27), 37.0);
		yYearData.setValue(yName, yUnit, LocalDate.of(1983, 10, 21), 52.0);
		yYearData.setValue(yName, yUnit, LocalDate.of(1988, 07, 27), 300.0);
		yYearData.setValue(yName, yUnit, LocalDate.of(1900, 05, 3), 21.0);
		yYearData.setValue(yName, yUnit, LocalDate.of(1996, 05, 27), 37.0);

		testCollection = new DataCollectionBuilder(xYearData, yYearData,
				Resolution.YEAR);

		testData.add("1996");
		testData.add("1995");
		testData.add("1994");
		testData.add("2016");
		testData.add("1982");
		testData.add("1991");
		testData.add("1988");

		testOnData(testData);
		testOnNames(xName, yName);
		testOnUnit(xUnit, yUnit);
	}

	private void testOnData(ArrayList<String> testCompareKey) {
		int i = 0;
		for (String testKey : testCollection.getResult().getData().keySet()) {

			assertEquals(testCompareKey.get(i), testKey);
			assertTrue(testCollection.getResult().getData().keySet() != null);
			i++;
		}
		testData.clear();

	}

	private void testOnNames(String xName, String yName) {

		assertEquals(xName + "/" + yName, testCollection.getTitle());

	}

	private void testOnUnit(String xUnit, String yUnit) {

		assertEquals(xUnit, testCollection.getResult().getXUnit());
		assertEquals(yUnit, testCollection.getResult().getYUnit());

	}

}
