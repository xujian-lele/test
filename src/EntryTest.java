import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.Test ;


public class EntryTest {
	public static Map<String,String> map = new HashMap<String,String>();

	public static Map<String, String> getMap() {
		return map;
	}

	public static void setMap(Map<String, String> map) {
		EntryTest.map = map;
	}

	/**
	 * @return
	 * @see java.util.Map#entrySet()
	 */
	public Set<Entry<String, String>> entrySet() {
		return map.entrySet();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EntryTest [entrySet()=" + entrySet() + "]";
	}
	
	@Test(timeout = 0)
	public void init()
	{
		long startTime = 0;
		for(int i=0;i<10000;i++)
		{
			this.map.put(String.valueOf(i), String.valueOf(i));
		}
		System.out.println(startTime);
	}
	public static void main(String[] args){
		EntryTest en = new EntryTest();
		en.init();
		for(Map.Entry<String, String> map1:map.entrySet())
		{
			int i=0;
			System.out.println("第"+i+"个元素");
			System.out.println(map1.getKey()+"|"+map1.getValue());
		}
		
	}
	

}
