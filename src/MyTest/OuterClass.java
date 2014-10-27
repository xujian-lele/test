/**
 * 
 */
package MyTest;

/**
 * @author xujian
 *
 */
public class OuterClass{
	public String s1="我是共有变量";
	protected String s2="我是保护变量";
	private String s3="我是私有变量";
	
	public void printEvent()
	{
		InterClass i = new InterClass();
		i.print();
	}

	public static class InterClass{
		public void print()
		{
			OuterClass o= new OuterClass();
			System.out.println(o.s1);
			System.out.println(o.s2);
			System.out.println(o.s3);

		}
	};
	public InterClass interclass;
	public static void main(String[] args){
		OuterClass o = new OuterClass();
		o.printEvent();
	}
}
