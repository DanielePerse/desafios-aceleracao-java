package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		int sumElements = 0;
		
		for(int i = 0; i < elements.length; i++) {
			sumElements += elements[i];
		}
	
		return sumElements/elements.length;
	}


	public static int mode(int[] elements) {
		int comparacao = 0;
		int moda = 0;
		
		for(int i = 0; i < elements.length; i++) {
			int ocorrencia = 0;
			
			for(int j = 0; j < elements.length; j++) {
				if(elements[i] == elements[j]) {
					ocorrencia++;
				}
			}
			if (ocorrencia > comparacao) {
				moda = elements[i];
				comparacao = ocorrencia;
			}
		}

		return moda;
	}
	

	public static int median(int[] elements) {
		
		Arrays.sort(elements);
		
		if (elements.length % 2 == 1) {
			int calcImpar = (elements.length / 2);
			return elements[calcImpar];
		}

		int calcPar1 = ((elements.length / 2) - 1);
		int calcPar2 = (elements.length / 2);
		return (elements[calcPar1] + elements[calcPar2]) / 2;
	}
}