package br.com.codenation.calculadora;


public class CalculadoraSalario {
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		double salarioDescontoInss = 0.0;

		if (salarioBase <= 1500) {
			salarioDescontoInss = salarioBase * 0.92;
		} else if (salarioBase > 1500 && salarioBase <= 4000) {
			salarioDescontoInss = salarioBase * 0.91;
		} else {
			salarioDescontoInss = salarioBase * 0.89;
		}

		return salarioDescontoInss;
	}

	public long calcularSalarioLiquido(double salarioBase) {
		double salarioFinal = 0.0;
		
		if (salarioBase < 1039) {
			return 0l;
		}
		
		double salarioDescInss = calcularInss(salarioBase);
		
		if (salarioDescInss <= 3000) {
			salarioFinal = salarioDescInss;
		} else if (salarioDescInss > 3000 && salarioDescInss <= 6000) { 
			salarioFinal = salarioDescInss * 0.925;
		} else {
			salarioFinal = salarioDescInss * 0.85;
		}
		
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		return Math.round(salarioFinal);
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/