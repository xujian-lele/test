package aa;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="1/ni shi zhu";
		String[] m = s.split("/");
		System.out.println(m[1]);
		for(int j=0;j<10000;j++)
		{
//			System.out.println((int)(Math.random()*100)%10);
			int i = new Random().nextInt(10);
			System.out.println(i);
			if(i==10)System.out.println("error!");
		}
	}
}
