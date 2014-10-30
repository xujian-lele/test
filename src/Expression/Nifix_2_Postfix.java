package Expression;

import java.util.Stack;

public class Nifix_2_Postfix implements ExpressionProcessor {
	public static Nifix_2_Postfix INSTANCE = new Nifix_2_Postfix();

	private Nifix_2_Postfix() {

	}

	/**
	 * 将中缀表达式转换成后缀表达式 3 * ( 1 + 3 ) ==> 3 1 3 + *
	 */
	public String processor(String expression) {
		Stack optors = new Stack();
		String[] words = expression.split(" ");
		StringBuffer sb = new StringBuffer();
		for (String word : words) {
			word = word.trim();
			if (Operators.INSTANCE.isOperator(word)) {
				if (optors.isEmpty()) {
					optors.push(word.trim());
				} else {
					if (word.equalsIgnoreCase(")")) {
						while (!optors.peek().toString().equalsIgnoreCase("(")) {
							sb.append(optors.pop());
							sb.append(" ");
						}
						optors.pop();
						continue;
					}

					if (word.equalsIgnoreCase("(")) {
						optors.push(word);
						continue;
					}

					String topOptor = (String) optors.peek();
					int topPriority = getPriority(topOptor);
					int wordPriority = getPriority(word);
					if (topPriority <= wordPriority) {
						// 高优先级符号
						optors.push(word);
					} else {
						// 优先级别更低
						while (wordPriority < getPriority(optors.peek()
								.toString())) {
							sb.append(optors.pop());
							sb.append(" ");
						}
						optors.push(word);
					}
				}
			} else {
				sb.append(word);
				sb.append(" ");
			}
		}

		while (!optors.isEmpty()) {
			sb.append(optors.pop());
			sb.append(" ");
		}

		return sb.toString();
	}

	public int getPriority(String s) {
		return Operators.INSTANCE.optors.get(s);
	}

}
