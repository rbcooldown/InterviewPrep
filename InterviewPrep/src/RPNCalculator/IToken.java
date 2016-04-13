package RPNCalculator;

import java.util.Stack;

interface IToken {
	
	public Stack<Double> execute(Stack<Double> stack);

}
