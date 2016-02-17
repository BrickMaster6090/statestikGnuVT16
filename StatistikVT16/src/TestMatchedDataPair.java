import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMatchedDataPair {
	
	MatchedDataPair match;

	@Before
	public void setUp() throws Exception {
		match = new MatchedDataPair(10.1,12.3 );
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValue() {
	assertTrue("wrong but true",10.1==match.getXValue());
	assertTrue("wrong but true",12.3==match.getYValue());
	
		
	}

}
