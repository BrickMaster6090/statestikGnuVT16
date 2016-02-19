import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDataCollection {

	DataCollection dataCollection;
	MatchedDataPair matchedDataPair;
	Map<String, MatchedDataPair> testMap = new HashMap<String, MatchedDataPair>();

	@Before
	public void setUp() throws Exception {
		matchedDataPair = new MatchedDataPair(10.20, 30.12);
		testMap.put("gnu", matchedDataPair);
		dataCollection = new DataCollection("time", "xdata", "ydata", testMap);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringMethods() {

		assertEquals("time", dataCollection.getTitle());
		assertEquals("xdata", dataCollection.getXUnit());
		assertEquals("ydata", dataCollection.getYUnit());
	}

	@Test
	public void testDataMethod() {

		assertEquals("[gnu]", dataCollection.getData().keySet().toString());
		assertEquals(matchedDataPair, dataCollection.getData().get("gnu"));
	}

}
