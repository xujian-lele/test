public class Test {
	public static void main(String[] args) {
		System.out.println("return value of test(): " + test());
		String s1 = "hello";
		String s2 = "hell"+"o";
		System.out.println(s1 == s2);
		String s3 = new String("hello");
		String s4 = new String("hello");
		System.out.println(s3 == s1);

	}

	public static int test() {
		int i = 1;
		// if(i == 1)
		// return 0;
		System.out.println("the previous statement of try block");
		// i = i / 0;
		try {
			System.out.println("try block");
			return i;
		} finally {
			i = i + 5;
			System.out.println("finally block");
		}
	}
}