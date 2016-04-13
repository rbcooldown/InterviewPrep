package RPNCalculator;

import java.util.Stack;

public class Subtract implements IOperator{

	@Override
	public Stack<Double> execute(Stack<Double> stack) {
		if(stack != null){
			double r = stack.pop();
			double l = stack.pop();
			stack.push(l-r);
		}
		return null;
	}
}
