package RPNCalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator {

	public Map<String, IToken> map = new HashMap<String, IToken>();
	
	{
		map.put("+", new Add());
		map.put("-", new Subtract());
		map.put("*", new Multiply());
		map.put("/", new Divide());
	}
	
	public IToken createToken(String s){
		IToken result = map.get(s);
		if(result == null){
			result = new Operand(Double.valueOf(s));
		}
		return result;
	}
	
	/*
	 * do calculation
	 */
	public double execute(String s) {
		if(!isValid(s))
			throw new IllegalArgumentException("The input string is not legal RPN expression.");
		Stack<Double> stack = new Stack<Double>();
		char[] tokens = s.toCharArray();
		for(char c: tokens) {
			IToken token = createToken(String.valueOf(c));
			token.execute(stack);
		}
		return stack.pop();
	}
	
	/*
	 * given string is valid for RPN or not
	 */
	private boolean isValid(String s){
		char[] chars = s.toCharArray();
		int count = 0;
		for(char c : chars){
			if(map.containsKey(String.valueOf(c)))
				count--;
			else
				count++;
		}
			
		return count == 1;
	}
}
