package br.com.codenation.paymentmethods;

public class CreditCard implements PriceStrategy {

	@Override
	public Double calculate(Double price) {
		// TODO Auto-generated method stub
		return price * 0.98;
	}

}
