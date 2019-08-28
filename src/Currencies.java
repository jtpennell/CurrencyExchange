
public class Currencies {
	private int currencyIndex;
	private Currency[] currencies;
	
	public Currencies() {
		currencies = null;
		currencyIndex = 0;
	}
	/**
	 * Adds a new currency type object to the currency array based on a newCurrency object
	 * this is an instance method
	 * invoked by run() in CurrencyExchangeProgram
	 * @param newCurrency: a currency object to be put in the array
	 */
	public void addCurrency(Currency newCurrency) {
		if (currencies == null) {
			currencies = new Currency[1];
			currencies[0] = newCurrency;
		}
		else
		{
			Currency[] tmpCurrencies = new Currency[currencies.length + 1];
			for (int i=0; i < currencies.length; i++) {
				tmpCurrencies[i] = currencies[i];
			}
			tmpCurrencies[currencies.length] = newCurrency;
			currencies = tmpCurrencies;
		}
	}
	/**
	 * This is an overloading method that Adds a currency object to the currency type array based on its parameters code and exchangeRate 
	 * This is an instance method.
	 * invoked by run() in CurrencyExchangeProgram 
	 * @param code: a three character string
	 * @param exchangeRate: the exchange rate of the code compared to NZD
	 */
	public void addCurrency(String code, double exchangeRate) {
		Currency newCurrency = new Currency(code,exchangeRate);
		addCurrency(newCurrency);
	}
	/**
	* Returns a Currency object based on its currency code.
	* This is an instance method.
	* Invoked by showRate() in CurrencyExchangeProgram.
	* @param code: the currency code of the Currency object to retrieve
	* @return the Currency object retrieved, or null if it is not found
	*/
	public Currency getCurrencyByCode(String code) {
		for (int i=0; i < currencies.length; i++) {
			if (currencies[i].getCode().equals(code)) return currencies[i];
		}
		return null;
	}
	/**
	 * deletes a currency object from the array based on its code
	 * this is an instance method
	 * not currently invoked
	 * @param code: the code to be checked if it's in the array
	 */
	public void deleteCurrencyByCode(String code) {
		if (currencies == null) return;
		for (int i=0; i < currencies.length; i++) {
			if (currencies[i].getCode().equals(code)) {
				if (currencies.length == 1) {
					currencies = null;
					return;
				}
				else
				{
					Currency[] tmpCurrencies = new Currency[currencies.length-1];
					for (int j=0; j<i; j++) {
						tmpCurrencies[j] = currencies[j];
					}
					for (int j=i; j<tmpCurrencies.length; j++) {
						tmpCurrencies[j] = currencies[j+1];
					}
					currencies = tmpCurrencies;
				}
			}
		}
	}
	/**
	 * resets the index to zero in the currencies array
	 * this is an instance method
	 * invoked by listCurrencies() in CurrencyExchangeProgram
	 * this method takes no parameters
	 */
	public void reset() {
		currencyIndex = 0;
	}
	/**
	 * gets the next element in the currencies array
	 * this is an instance method
	 * invoked by listCurrencies() in CurrencyExchangeProgram
	 * this method takes no parameters
	 * @return the next currency type object
	 */
	public Currency next() {
		if (currencyIndex == currencies.length) return null;
		Currency c = currencies[currencyIndex];
		currencyIndex++;
		return c;
	}
	
}
