package RPNCalculator;

import java.util.Stack;

public class Multiply extends Operator{

	@Override
	public Stack<Double> execute(Stack<Double> stack) {
		if(stack != null){
			double r = stack.pop();
			double l = stack.pop();
			stack.push(l*r);
		}
		return stack;
	}

}
