
public class Currency {
	private String code;
	private double exchangeRate;
	
	public Currency(String code, double exchangeRate) {
		this.code = code;
		this.exchangeRate = exchangeRate;
	}
	/**
	 * retrieves the tree letter code and returns it
	 * this is an instance method
	 * invoked by convertAmount() in the CurrencyExchangeProgram
	 * this method takes no parameters
	 * @return a three letter code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * gets the exchange rate from the currency object
	 * this is an instance method
	 * invoked by the showRate() method in the CurrencyExchangeProgram
	 * this method take no parameters
	 * @return an exchange rate value
	 */
	public double getExchangeRate() {
		return exchangeRate;
	}
	/**
	 * sets the current exchange rate to a new exchange rate
	 * this is an instance method
	 * not currently invoked
	 * @param newExchangeRate: an exchange rate of type double as input to be changed
	 */
	public void setExchangeRate(double newExchangeRate) {
		exchangeRate = newExchangeRate;
	}
}
