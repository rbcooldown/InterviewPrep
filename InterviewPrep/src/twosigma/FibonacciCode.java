package twosigma;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FibonacciCode {

	public static String coding(int x) {
		List<Integer> fibonaccis = new ArrayList<Integer>();
		fibonaccis.add(1);
		fibonaccis.add(2);
		int f1= 1, f2 = 2, idx = 2;
		// mapping fibonacci number to index.
		while(f1+f2 < x){
			int tmp = f1+f2;
			f1=f2;
			f2=tmp;
			fibonaccis.add(f2);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = fibonaccis.size()-1; i>=0; i--) {
			if(fibonaccis.get(i)<= x){
				sb.append(1);
				x -=fibonaccis.get(i);
			}
			else
				sb.append(0);
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		int test = 65;
		long time = System.currentTimeMillis();
		
		System.out.println(coding(test));
	}
}
