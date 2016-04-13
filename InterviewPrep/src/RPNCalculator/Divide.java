package RPNCalculator;

import java.util.Stack;

public class Divide extends Operator{

	@Override
	public Stack<Double> execute(Stack<Double> stack) {
		if(stack != null) {
			double r = stack.pop();
			double l = stack.pop();
			if(r != 0)
				stack.push(l/r);
		}
		return stack;
	}
}
