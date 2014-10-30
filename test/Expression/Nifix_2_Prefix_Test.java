package Expression;

import static org.junit.Assert.*;

import org.junit.Test;

public class Nifix_2_Prefix_Test {
	@Test
	public void test() {
		String expression = "( a + b ) * c + d";
		String result = Nifix_2_Prefix.INSTANCE.processor(expression );
		System.out.println(result);
//		fail("Not yet implemented");
	}

}
