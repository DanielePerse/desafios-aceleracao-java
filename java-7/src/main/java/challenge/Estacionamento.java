package challenge;

import java.util.ArrayList;

public class Estacionamento {
	
	ArrayList<Carro> listaCarrosEstacionados = new ArrayList<Carro>();

    public void estacionar(Carro carro) {
    	// naoDeveTerCarroAutonomo
    	if (carro.getMotorista() == null) {
    		throw new EstacionamentoException("Motorista deve ser informado!");
    	}
    	
    	// naoDeveTerMotoristaDeMenor
    	if (carro.getMotorista().getIdade() < 18) {
    		throw new EstacionamentoException("Motorista deve ser de maior!");
    	}
    	
    	// naoDeveEstacionarMotoristaSemPontos
    	if (carro.getMotorista().getPontos() > 20) {
    		throw new EstacionamentoException("Motorista com mais de 20 pontos não pode estacionar!");
    	}
    	
    	int totalCarros = carrosEstacionados();
    	if (totalCarros < 10) {
    		listaCarrosEstacionados.add(carro);
    	} else {

    		boolean todosIdosos = true;
  
    		if (listaCarrosEstacionados.get(0).getMotorista().getIdade() < 55) {
    			listaCarrosEstacionados.remove(0);
				listaCarrosEstacionados.add(carro);
				todosIdosos = false;
    		} else {
    			
    			for (int i = 1; i < totalCarros; i++) {
    				if (listaCarrosEstacionados.get(i).getMotorista().getIdade() < 55) {
    					listaCarrosEstacionados.remove(i);
    					listaCarrosEstacionados.add(carro);
    					todosIdosos = false;
    					break;
    				}
    			}
    		}
    		
    		if (todosIdosos) {
    			throw new EstacionamentoException("Estacionamento lotado!");
    		}
    	}
    	
    }
    // Chegue mais um novo carro, o primeiro que estacionou deverá sair
    // Caso o motorista do primeiro carro estacionado tenha uma idade superior a 55 anos, será escolhido o próximo motorista abaixo dos 55 anos.
    // Caso todos os motoristas, dentro do estacionamento, tenham mais de 55 anos e chegue um motorista, ele não conseguirá estacionar.
    
    // deveEstacionar
    // naoDeveUltrapassarEstacionamento
    // casoPrimeiroMotoristaSejaSeniorEleNaoDeveSair
    // casoTodosSejamSeniorONovoMotoristaNaoTeraVaga
    public int carrosEstacionados() {
        return listaCarrosEstacionados.size();
    }
    
    // naoDeveUltrapassarEstacionamento
    // casoPrimeiroMotoristaSejaSeniorEleNaoDeveSair
    public boolean carroEstacionado(Carro carro) {
        return listaCarrosEstacionados.contains(carro);
    }
}
