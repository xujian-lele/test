/**
 * 
 */
package ReaderWriter;

/**
 * @author xujian
 *
 */
public class Reader extends Thread {
	//
	public int num;
	//
	public Book book = new Book();

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Reader(Book book) {
		super();
		this.book = book;
	}
	public void run(){
		book.read(num);
	}
}
