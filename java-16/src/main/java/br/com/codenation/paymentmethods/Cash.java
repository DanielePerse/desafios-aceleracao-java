package br.com.codenation.paymentmethods;

public class Cash implements PriceStrategy {

	@Override
	public Double calculate(Double price) {
		// TODO Auto-generated method stub
		return price * 0.9;
	}

}
