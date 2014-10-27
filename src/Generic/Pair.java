package Generic;

public class Pair<T> {
	public T first;
	public T second;
	/**
	 * @return the first
	 */
	public T getFirst() {
		return first;
	}
	/**
	 * @param first the first to set
	 */
	public void setFirst(T first) {
		this.first = first;
	}
	/**
	 * @return the second
	 */
	public T getSecond() {
		return second;
	}
	/**
	 * @param second the second to set
	 */
	public void setSecond(T second) {
		this.second = second;
	}
	public Pair(T first, T second) {
		super();
		this.first = first;
		this.second = second;
	}
	
	public Pair()
	{
		this.first=null;
		this.second=null;
	}
	
}
