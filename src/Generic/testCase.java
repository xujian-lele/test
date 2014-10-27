package Generic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testCase {

	@Before
	public void setUp() throws Exception {
		System.out.println("test is start！");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("test is finish！");

	}

	@Test
	public void test() {
		test1();
		test2();
		test3();

		fail("Not yet implemented");
	}

	public void test1(){
		Gen<Integer> gen = new Gen<Integer>(new Integer(1));
		gen.showType();
		Gen<String> gen1 = new Gen<String>("how are you");
		gen1.showType();
	}
	public void test2(){
		Integer[] s={
				1,2,3,4,8,423,39210
		};
		Pair<Integer> pair = ArrayAlg.instance.minmax(s);
		System.out.println("min="+pair.getFirst());
		System.out.println("max="+pair.getSecond());
		
	}
	
	public void test3(){
		Date[] s={
			new Date(1890,02,10),
			new Date(1989, 9, 9)
		};
		Pair<Date> pair = ArrayAlg.instance.minmax(s);
		System.out.println("min="+pair.getFirst());
		System.out.println("max="+pair.getSecond());
	}
}
