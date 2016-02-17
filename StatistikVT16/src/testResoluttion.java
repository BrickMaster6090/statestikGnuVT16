import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testResoluttion {
	
	Resolution resolution;
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDay() {
		
		assertEquals("1988-11-23", Resolution.DAY.trim(LocalDate.of(1988, 11, 23)));
		
	}
	@Test
	public void testMonth() {
		
		assertEquals("1998 06", Resolution.MONTH.trim(LocalDate.of(1998, 06, 23)));
		
	}
	@Test
	public void testWeek() {
		
		assertEquals("1998 26", Resolution.WEEK.trim(LocalDate.of(1998, 06, 23)));
		
	}
	@Test
	public void testQuarter() {
		
		assertEquals("2015 2", Resolution.QUARTER.trim(LocalDate.of(2015, 06, 16)));
		
	}
	@Test
	public void testYear() {
		
		assertEquals("2015", Resolution.YEAR.trim(LocalDate.of(2015, 06, 16)));
		
	}
}
