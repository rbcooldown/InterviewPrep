package RPNCalculator;

import java.util.Stack;

public class Operand implements IToken{
	
	double value;
	public Operand(double val){
		value = val;
	}

	@Override
	public Stack<Double> execute(Stack<Double> stack) {
		stack.push(value);
		return stack;
	}

}
