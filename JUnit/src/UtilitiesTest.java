import static org.junit.Assert.*;

import org.junit.Test;

public class UtilitiesTest {

	private Utilities util;
	
	@org.junit.Before
	public void setup() {
		util= new Utilities();
	}
	
	@Test
	public void testEveryNthChar() throws Exception{
		char[] output = util.everyNthChar(new char[] {'h','e','l','l','o'}, 2);
		assertArrayEquals(new char[] {'e','l'}, output);	
		char[] output2 = util.everyNthChar(new char[] {'h','e','l','l','o'}, 8);
		assertArrayEquals(new char[] {'h','e','l','l','o'}, output2);	
	}
	@Test
	public void testRemovePairs() throws Exception{
		assertEquals("ABCDEF",util.removePairs("AABCDDEFF"));
		assertEquals("ABCABDEF",util.removePairs("ABCCABDEEF"));
		
	}

	@Test
	public void testConverter() throws Exception{
		assertEquals(300,util.converter(10,5));
	}
	@org.junit.Test(expected = ArithmeticException.class)
	public void testConverterA() throws Exception {
		util.converter(10,0);
	}

	@Test
	public void testNullIfOddLength() throws Exception{
		
		assertNull(util.nullIfOddLength("Yusuf"));
		assertNotNull(util.nullIfOddLength("Yilmaz"));
	}

}
