package SortCommon;

public class SortUtil {
	public static SortUtil INSTANCE = new SortUtil(); 
	/**
	 * 创建一个size大小的数组（从小到大）
	 * @param size
	 * @return
	 */
	public int[] arrayBuilder(int size){
		int[] array = new int[size];
		for(int i=0;i<size;i++){
//			array[i] = (int) (Math.random()*100 + 1);
			array[i] = i + 1 ;
		}
		return array;
	}
	
	/**
	 * 打印一个大小为size的数组的内容
	 * @param array
	 * @param size
	 */
	public void printArray(int[] array, int size){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<size;i++){
			sb.append(array[i]);
			sb.append("    ");
		}
		System.out.println(sb.toString().trim());
	}
}
