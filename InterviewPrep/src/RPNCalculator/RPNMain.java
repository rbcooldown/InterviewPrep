package RPNCalculator;

public class RPNMain {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		System.out.println(calc.execute("14+25*"));
	}

}
