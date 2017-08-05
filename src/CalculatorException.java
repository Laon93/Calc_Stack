
public class CalculatorException extends Exception{
	private static final long serialVersionUID = 1L;

	public CalculatorException() {
		super("MyStackException : Exception Occur");
	}
	
	public CalculatorException(String message) {
		super(message);
	}
}
