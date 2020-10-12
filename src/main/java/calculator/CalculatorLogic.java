package calculator;

public class CalculatorLogic {

	public static int calculate(int x, int y, String action) {
		
		switch (action) {
		
		case "+": return x + y;
		case "-": return x - y;
		case "*": return x * y;
		case "/": return x / y;		
		
		default: return 0;
		
		}
		
	}

}