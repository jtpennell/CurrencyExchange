
public class Amount {
	private Currency currency;
	private double amount;
	
	public Amount(Currency currency, double amount) {
		this.setCurrency(currency);
		this.setAmount(amount);
	}
	/**
	 * Gets the currency object and returns it.
	 * This is an instance method.
	 * Invoked in convertAmount() in CurrencyExchangeProgram.
	 * this method takes no parameters
	 * @return the currency object
	 */
	public Currency getCurrency() {
		return currency;
	}
	/**
	 * Sets the currency object to a new value.
	 * This is an instance method.
	 * Not presently invoked.
	 * @param currency: the currency amount retrieved
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	/**
	 * Gets the amount and returns it.
	 * This is an instance method.
	 * Invoked by convertAmount() in CurrencyExchangeProgram.
	 * This method takes no parameters.
	 * @return amount of type double
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * Sets the current amount value to a new value.
	 * This is an instance method.
	 * Not presently invoked.
	 * @param amount: a different value input from the user
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * Returns a converted new amount of money based on the otherCurrency parameter
	 * This is an instance method.
	 * Invoked by convertAmount() in CurrencyExchangeProgram.
	 * @param otherCurrency: used to convert the currency
	 * @return a converted value in currency
	 */
	public double getAmountIn(Currency otherCurrency) {
		return amount * currency.getExchangeRate() / otherCurrency.getExchangeRate();
	}

	public Amount getAmountIn(Currency otherCurrency, double amount) {
		Amount newAmount = new Amount(otherCurrency, amount * currency.getExchangeRate()/otherCurrency.getExchangeRate());
		return newAmount;
	}
}