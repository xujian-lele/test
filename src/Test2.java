
	class A {
	    public String f(A obj)
	    {
	        return("A");
	    }
	}
	class B extends A {
	    public String f(B obj)
	    {
	        return("C");
	    }
	    public String f(A obj)
	    {
	        return("D");
	    }
	} 
public class Test2 {
	public static void main(String[] args){
		A a1 = new A();
		B b = new B();
		A a2 = b;
		System.out.println(a2.f(a2));
//		System.out.println(a2.f(a1));
		System.out.println();
	}

}
