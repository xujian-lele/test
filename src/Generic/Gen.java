package Generic;

public class Gen<T> {
	public T obj;

	/**
	 * @return the obj
	 */
	public T getObj() {
		return obj;
	}

	/**
	 * @param obj the obj to set
	 */
	public void setObj(T obj) {
		this.obj = obj;
	}

	public Gen(T obj) {
		super();
		this.obj = obj;
	}
	public void showMessage(){
		System.out.println(this.obj);
	}

	public void showType(){
		System.out.println("T的实际类型是："+obj.getClass().getName());
	}
}
