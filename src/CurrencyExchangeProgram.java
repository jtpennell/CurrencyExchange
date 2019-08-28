import java.io.BufferedReader;
import java.io.*;
/** 
 * 
 * @author 	Ulrich Speidel
 * @version 1.0
 * @since	2016-02-19
 *
 */

public class CurrencyExchangeProgram {
	private Currencies currencies; // this private instance variable holds an object of class Currencies
	private KeyboardInput keyboardInput; // this private instance variable holds an object of class keyboardInput 
	
	/**
	 * This instance method is the central method of our program. It sets
	 * up all we need for keyboard input later, and contains the central
	 * loop to which execution returns. It takes no parameters. 
	 */
	public void run() {
		readFile();
		keyboardInput = new KeyboardInput(); // we will use this object to obtain keyboard input
		while (true) { // endless while-loop
			// display the menu and get the user's choice
			CurrencyExchangeMenu menu = new CurrencyExchangeMenu(); // ...using the 
			int menuChoice = menu.getChoice(keyboardInput);

			// now process
			switch (menuChoice) {
			case 1:
				listCurrencies(); // output a list of all currencies added to the system
				break;
			case 2: 
				addCurrency(); // add a currency to the system
				break;
			case 3:
				showRate(); // show the exchange rate for a given currency
				break;
			case 4:
				convertAmount(); // convert an amount between two currencies
				break;
			}
		}
	}
	
	/**
	 * This private instance method outputs a list of all currencies stored in the
	 * private instance variable currencies. The method takes no parameters. 
	 */
	private void listCurrencies() {
		// Test whether we already have currencies
		if (currencies == null) {
			// No, so complain and return
			System.out.println("There are currently no currencies in the system.");
			System.out.println("Please add at least one currency.");
			System.out.println();
			return;
		}
		// Reset the index into the currencies list
		currencies.reset();
		Currency currency;
		// Output all currencies
		while ((currency = currencies.next()) != null) {
			System.out.println(currency.getCode());			
		}
		System.out.println();
	}
	private String checkCurrencyCode() { // part 3
		System.out.print("Enter a three letter currency code (e.g., AUD, JPY, USD, EUR): ");
		String currencyCode = keyboardInput.getLine();
		if (currencyCode.length() != 3){
			System.out.println("\"" + currencyCode + "\" is not a THREE letter code. Returning to menu.");
        	System.out.println();
        	return currencyCode;
		}
		return currencyCode;
	}
	/**
	 * This private instance method adds a currency to the private instance variable currencies. 
	 * The method takes no parameters. 
	 */
	private void addCurrency() {
		String currencyCode = checkCurrencyCode();
		if (currencyCode.length() != 3){
			return;
		}
        System.out.println();
        System.out.print("Enter the exchange rate (value of 1 " +currencyCode+ " in NZD): ");
        String exchangeRateStr = keyboardInput.getLine();
        double exchangeRate = Double.parseDouble(exchangeRateStr);
        if (exchangeRate <= 0) {
        	System.out.println("Negative exchange rates not permitted. Returning to menu.");
        	System.out.println();
        	return;
        }
        System.out.println();
        if (currencies == null) {
        	currencies = new Currencies();
        }
        currencies.addCurrency(currencyCode, exchangeRate);
        System.out.println("Currency " +currencyCode+ " with exchange rate " + exchangeRate + " added");
        System.out.println();
	}
	/**
	 * This method prints the rate in the output based on the currency code.
	 * this is an instance method
	 * invoked by run() in the same class (CurrencyExchangeProgram)
	 * this method takes no parameters
	 */
	private void showRate() {
		String currencyCode = checkCurrencyCode();
		if (currencies == null){//if there are no elements in the currencies array
			System.out.println("\"" + currencyCode + "\" is not on the system. Returning to menu.");
			System.out.println(); // state no currencies are in the system and return to the menu
        	return;
        }
        Currency checkCurrencies = currencies.getCurrencyByCode(currencyCode);// convert the currencyCode object to a Currency type
        if (checkCurrencies == null) { // check if it's in the system
        	System.out.println("\"" + currencyCode + "\" is not on the system. Returning to menu."); // if it's not in the system return to the menu
        	System.out.println();
        	return;
        }
        Currency currency = currencies.getCurrencyByCode(currencyCode);
        System.out.println("Currency " +currencyCode+ " has exchange rate " + currency.getExchangeRate() + ".");
        System.out.println();
	}
	/**
	 * prints out the converted amount of money based on the users input.
	 * this is an instance method
	 * invoked by run() in the same class
	 * this method takes no parameters
	 */
	private void convertAmount() {
		String currencyCodeFrom = checkCurrencyCode();
        String currencyCodeTo = checkCurrencyCode();
        
        Currency currencyFrom = currencies.getCurrencyByCode(currencyCodeFrom);
        if (currencyFrom == null) {
        	System.out.println("\"" + currencyCodeFrom + "\" is not on the system. Returning to menu.");
        	return;
        }
        System.out.println();
        Currency currencyTo = currencies.getCurrencyByCode(currencyCodeTo);
        if (currencyTo == null) {
        	System.out.println("\"" + currencyCodeTo + "\" is not on the system. Returning to menu.");
        	return;
        }
        System.out.println();
        System.out.print("How many " + currencyCodeFrom + " would you like to convert to " + currencyCodeTo + "? Amount: ");
        String amountStr = keyboardInput.getLine();
        Amount amount = new Amount(currencyFrom, Double.parseDouble(amountStr));
        System.out.println();
        System.out.printf("%.2f %s = %.2f %s",  amount.getAmount(), amount.getCurrency().getCode(), 
            amount.getAmountIn(currencyTo), currencyTo.getCode());
        System.out.println(); 
        System.out.println(); 
	}
	private void readFile(){
		String line = null;//This is a reference to a line
		String fileName = "bin/forex.txt"; //This is the name of the file
		try {
			FileReader readFile = new FileReader(fileName); //This is used to read a file in default encoding
			BufferedReader bf = new BufferedReader(readFile);//BufferedReader buffers the file readFile
			currencies = new Currencies(); //Creating a new currencies object (array) to hold the data
			while ((line = bf.readLine())!= null){ //While loop which loops through the buffered text file
				currencies.addCurrency(line.substring(0,3), Double.parseDouble(line.substring(4))); /*Adds a currency to the currencies 
				array by slicing substrings from each line of the text file */
			}
			bf.close(); //Closes the file
		}
		catch(FileNotFoundException ex) {// Exception handling for when the file is not found
			System.out.println(fileName + " not found."); //Prints out that the file isn't found
		}
		catch (IOException ex){ //Exception handling for when there is an i/o error
			System.out.println("Error reading " + fileName);//Prints out that there is an error reading the file
		}
		
	}
}
