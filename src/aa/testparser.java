package aa;

import sun.org.mozilla.javascript.internal.json.JsonParser;
import sun.org.mozilla.javascript.internal.json.JsonParser.ParseException;

public class testparser {

	public static void main(String[] args){
		JsonParser parser = new JsonParser(null, null);
		String line="";
		try {
			parser.parseValue(line);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("fail");
			e.printStackTrace();
		}
	}
}
