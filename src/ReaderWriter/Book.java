/**
 * 
 */
package ReaderWriter;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xujian
 *
 */
public class Book {
	//rong liang
	public int FULL_SIZE = 20;
	//cang ku
	List<Object> book = new LinkedList<Object>();
	//lock
	public Lock lock = new ReentrantLock();
	//full
	public void read(int num) {

		
	}

	//write
	public void write(int num) {
		// TODO Auto-generated method stub
		
	}

}
