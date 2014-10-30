package Expression;

import java.util.HashMap;
import java.util.Map;

/**
 * 运算符类
 * @author xujian
 *
 */
public class Operators {
	public static Operators INSTANCE = new Operators();
	/**
	 * String 响应的运算符
	 * Integer 该运算符的优先级
	 */
	public Map<String, Integer> optors = new HashMap<String, Integer>();
	
	private Operators(){
		load_optors();
	}

	private void load_optors() {
		optors.put("+", 1);
		optors.put("-", 1);
		optors.put("*", 2);
		optors.put("/", 2);
		optors.put("(", 0);
		optors.put(")", 0);
	}
	
	public boolean isOperator(String op){
		if(op == null) return false;
		op = op.trim();
		if(op.length() == 0) return false;
		if(optors.containsKey(op)){
			return true;
		}
		else{
			return false;
		}
	}
	
	

}
