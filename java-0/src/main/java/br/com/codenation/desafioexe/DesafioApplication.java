package br.com.codenation.desafioexe;

import java.util.List;
import java.util.ArrayList;

public class DesafioApplication {

	public static int calcFibonacci(int num) {
		if (num < 2) {
			return num;
		} else {
			return calcFibonacci(num - 1) + calcFibonacci(num -2);
		}
	}

	public static List<Integer> fibonacci() {
		List<Integer> listFibonacci = new ArrayList<Integer>();

		int i = 0;
		boolean stop = false;

		while (!stop) {
			int numberFibonacci = calcFibonacci(i);
			listFibonacci.add(numberFibonacci);
			i++;

			if (numberFibonacci > 350) {
				stop = true;
			}
		}

		return listFibonacci;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}