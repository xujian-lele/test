import java.util.EmptyStackException;
import java.util.Stack;

public class StackTest<E> extends Stack<E> {

	public StackTest() {
		super();
	}
	

    public E pop() {
        E       obj;
        int     len = size();

        obj = peek();
        removeElementAt(len - 1);

        return obj;
    }
    
    public synchronized E peek() {
        int     len = size();

        if (len == 0)
            throw new EmptyStackException();
        E obj = elementAt(len - 1);
        return obj;
    }
    
    private E pop(int i) {
        E       obj;
        int     len = size();
        obj = peek();
//        removeElementAt(len - 1);
        return obj;
    }
    
    private static void print(){
    	System.out.println(5);
    }
    
    public static void print(int i){
    	System.out.println(10);
    }
    
    
	public static void main(String[] args) {
		StackTest st = new StackTest();
		String str1 = "xujian";
		String str2 = "dujing";
		String str3 = "秦凯";
		st.add(str1);
		st.add(str2);
		st.add(str3);
		st.add(8);
		System.out.println(st.toString());
		st.pop();
		System.out.println(st.toString());
		st.pop(0);
		System.out.println(st.toString());
		print();
		print(1);
		
	}

}
