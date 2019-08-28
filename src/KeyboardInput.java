
public class KeyboardInput {
	private java.util.Scanner s;
	/**
	 * takes a keyboard input from the user
	 * this is an instance method
	 * invoked by addCurrency() in CurrentcyExchangeProgram
	 * this method takes no parameters
	 */
	KeyboardInput() {
	    s = new java.util.Scanner(System.in);
	}
	/**
	 * scanner reads the next line
	 * this is an instance method
	 * invoked by getInput() in CurrencyExchangeMenu
	 * this method takes no parameters
	 * @return the variable s of your input string
	 */
	public String getLine() {
        return s.nextLine();
	}
	/**
	 * closes the scanner
	 * this is an instance method
	 * currently not invoked
	 * this method takes no parameters
	 */
	public void close() {
		s.close();
	}
}
