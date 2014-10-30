package Expression;

import static org.junit.Assert.fail;

import java.util.Stack;

import org.junit.Test;

public class Nifix_2_Postfix_Test {

	@Test
	public void test() {
		String expression = "( 2 + 2 * 3 - 3 ) * 3";
		String result = Nifix_2_Postfix.INSTANCE.processor(expression );
		System.out.println(result);
		
		fail("Not yet implemented");
	}

}
