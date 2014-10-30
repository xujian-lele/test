package Expression;

import java.util.Stack;

/**
 * 
 * @author xujian 将中缀表达式转换成前缀表达式 :( a + b ) * (c + d) 转换成 * + a b + c d
 */
public class Nifix_2_Prefix implements ExpressionProcessor {
	public static Nifix_2_Prefix INSTANCE = new Nifix_2_Prefix();

	private Nifix_2_Prefix() {

	}

	public String processor(String expression) {
		if (expression == null || expression.length() == 0)
			return null;
		Stack<String> numStack = new Stack<String>();
		Stack<String> optStack = new Stack<String>();
		String[] words = expression.split(" ");
		for (String word : words) {
			word = word.trim();
			if (Operators.INSTANCE.isOperator(word)) {
				if (word.equalsIgnoreCase("(")) {
					optStack.push(word);
				} else if (word.equalsIgnoreCase(")")) {
					while (!optStack.peek().toString().equalsIgnoreCase("(")) {
						String str = popStack(numStack, optStack);
					}
					optStack.pop();
				} else {
					int wordPriority = getPriority(word);
					int optPriority;
					if (optStack.isEmpty()) {
						optPriority = -1;
					} else {
						optPriority = getPriority(optStack.peek().toString());
					}

					if (wordPriority >= optPriority) {
						optStack.push(word);
					} else {
						// 输入符优先级别低
						while (!optStack.isEmpty()
								&& wordPriority < getPriority(optStack.peek()
										.toString())) {
							popStack(numStack, optStack);
						}
						optStack.push(word);
					}
				}

			} else {
				numStack.push(word);
			}
		}

		while (!optStack.isEmpty()) {
			popStack(numStack, optStack);
		}
		return numStack.pop();
	}

	/**
	 * 
	 * @param numStack
	 *            数据栈
	 * @param optStack
	 *            操符栈 function ： 从数据栈中弹出最顶端的两个元素b，a；从操作符栈中淡出最顶端的那个元素o；将oab
	 *            加入到数据栈中。
	 */
	private String popStack(Stack<String> numStack, Stack<String> optStack) {
		if (numStack.isEmpty() || numStack.size() == 1)
			return "";
		if (optStack.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			while (!numStack.isEmpty() && numStack.size() > 1) {
				StringBuffer sb1 = new StringBuffer();
				sb1.append(numStack.pop());
				StringBuffer sb2 = new StringBuffer();
				sb2.append(numStack.pop());
				String result = sb2 + " " + sb1;
				numStack.push(result);
			}
			return numStack.pop();
		}

		// 俩栈都非空
		StringBuffer sb1 = new StringBuffer();
		sb1.append(numStack.pop());
		StringBuffer sb2 = new StringBuffer();
		sb2.append(numStack.pop());
		String result = sb2 + " " + sb1;

		numStack.push(optStack.pop() + " " + result);
		return numStack.peek();
	}

	public int getPriority(String s) {
		return Operators.INSTANCE.optors.get(s);
	}

}
