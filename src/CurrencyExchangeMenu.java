
public class CurrencyExchangeMenu {
	private void showMenu() {
		System.out.println("***Welcome to the currency exchange calculator***");
		System.out.println();
		System.out.println("1) List available currencies");
		System.out.println("2) Add a currency");
		System.out.println("3) Show an exchange rate");
		System.out.println("4) Convert an amount");
		System.out.println();
		System.out.print("Enter your choice: ");		
	}
	/**
	 * Gets keyboard input from the  user
	 * this is a class method
	 * invoked by getChoice() in the same class.
	 * @param k: keyboard input from the user
	 * @return the users input
	 */
	private int getInput(KeyboardInput k) {
        String choiceStr = k.getLine();     
        return Integer.parseInt(choiceStr);
	}
	/**
	 * Gets choice from keyboard input and returns it.
	 * This is an instance method.
	 * Invoked by run() in CurrencyExchangeProgram.
	 * @param k: keyboard input from user.
	 * @return the choice of the users input
	 */
	public int getChoice(KeyboardInput k) {
		showMenu();
		int choice = getInput(k);
		while ((choice < 1) || (choice > 4)) {
			System.out.print("Invalid input. Please enter your choice: ");
			choice = getInput(k);
		}
		return choice;		
	}	
}
