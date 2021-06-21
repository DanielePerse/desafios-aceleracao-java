package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.print.attribute.DateTimeSyntax;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.model.Jogador;
import br.com.codenation.model.Time;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
	
	// incluir variável na memória através de uma lista
	private List<Time> times = new ArrayList<Time>();
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	
	private Time buscarTime(Long id) {
		Time time = null;
		
		for (int i = 0; i < times.size(); i++) {
			if (times.get(i).getId() == id) {
				time = times.get(i);
			}
		}
		
		return time;
	}
	
	
	private Jogador buscarJogador(Long id) {
		Jogador jogador = null;
		
		for (int i = 0; i < jogadores.size(); i++) {
			if (jogadores.get(i).getId() == id) {
				jogador = jogadores.get(i);
			}
		}
		
		return jogador;
	}
	

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		
		if (buscarTime(id) != null) {
			throw new IdentificadorUtilizadoException();
		}
		
		times.add(time);

	} 


	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		
		if (buscarJogador(id) != null) {
			throw new IdentificadorUtilizadoException();	
		} else if (buscarTime(idTime) == null) {
			throw new TimeNaoEncontradoException();	
		}
		
		jogadores.add(jogador);
	}


	public void definirCapitao(Long idJogador) {
		Jogador jogador = buscarJogador(idJogador);
		
		if (jogador == null) {
			throw new JogadorNaoEncontradoException();
		}
		
		jogadores.forEach(item -> {
			if (item.isCapitao() && item.getIdTime() == jogador.getIdTime()) {
				item.setCapitao(false);
			}
		});

		jogador.setCapitao(true);
	}


	public Long buscarCapitaoDoTime(Long idTime) {
		Jogador jogador = null;

		if (buscarTime(idTime) == null) {
			throw new TimeNaoEncontradoException();
		}
		
		for (Jogador item : jogadores) {
			if (item.getIdTime() == idTime && item.isCapitao()) {
				jogador = item;
			}
		};
		
		if (jogador == null) {
			throw new CapitaoNaoInformadoException();
		}
		
		return jogador.getId();
	}

	
	public String buscarNomeJogador(Long idJogador) {
		Jogador jogador = buscarJogador(idJogador);

		if (jogador == null) {
			throw new JogadorNaoEncontradoException();
		}
		
		return jogador.getNome();

	}


	public String buscarNomeTime(Long idTime) {
		Time time = buscarTime(idTime);
		
		if (time == null) {
			throw new TimeNaoEncontradoException();
		}
		
		return time.getNome();
	}


	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if (buscarTime(idTime) == null) {
			throw new TimeNaoEncontradoException();
		}

		List<Jogador> jogadoresDoTime = jogadores
			.stream()
			.filter(j -> j.getIdTime() == idTime)
			.collect(Collectors.toList());
		
		jogadoresDoTime.sort(Comparator.comparing(Jogador::getId));
		
		List<Long> listaIdJogadores = new ArrayList<Long>();
		
		jogadoresDoTime.forEach(j -> {
			listaIdJogadores.add(j.getId());
		});
		
		return listaIdJogadores;
	}	


	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if (buscarTime(idTime) == null) {
			throw new TimeNaoEncontradoException();
		}
		
		List<Jogador> jogadoresDoTime = jogadores
				.stream()
				.filter(j -> j.getIdTime() == idTime)
				.collect(Collectors.toList());
		jogadoresDoTime.sort(Comparator.comparing(Jogador::getNivelHabilidade));
		
		return jogadoresDoTime.get(jogadoresDoTime.size() - 1).getId();
	}
	
//	Retorna o identificador do jogador mais velho do time. Usar o menor identificador como critério de desempate.	
	public Long buscarJogadorMaisVelho(Long idTime) {
		if (buscarTime(idTime) == null) {
			throw new TimeNaoEncontradoException();
		}
		List<Jogador> jogadoresDoTime = jogadores
				.stream()
				.filter(j -> j.getIdTime() == idTime)
				.collect(Collectors.toList());
		jogadoresDoTime.sort(Comparator.comparing(Jogador::getDataNascimento));
		
		return jogadoresDoTime.get(jogadoresDoTime.size() - 2).getId();
	}
	

	public List<Long> buscarTimes() {
		times.sort(Comparator.comparing(Time::getId));
		
		List<Long> idTimesCadastrados = new ArrayList<Long>();
		
		times.forEach(time -> idTimesCadastrados.add(time.getId()));
		
		return idTimesCadastrados;
	}


	public Long buscarJogadorMaiorSalario(Long idTime) {
		if (buscarTime(idTime) == null) {
			throw new TimeNaoEncontradoException();
		}
		
		List<Jogador> jogadoresDoTime = jogadores
				.stream()
				.filter(j -> j.getIdTime() == idTime)
				.collect(Collectors.toList());
		jogadoresDoTime.sort(Comparator.comparing(Jogador::getSalario));
		
		return jogadoresDoTime.get(jogadoresDoTime.size() - 1).getId();
	}


	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if (buscarJogador(idJogador) == null) {
			throw new JogadorNaoEncontradoException();
		}
		
		List<Jogador> salarioJogador = jogadores
				.stream()
				.filter(j -> j.getId() == idJogador)
				.collect(Collectors.toList());
		
		return salarioJogador.get(0).getSalario();
	}


	public List<Long> buscarTopJogadores(Integer top) {
		jogadores.sort(Comparator.comparing(Jogador::getNivelHabilidade));
		
		List<Long> idTop = new ArrayList<Long>();
		if (jogadores.size() > 0) {
			for (int i = jogadores.size() - 1; i >= (jogadores.size() - top); i--) {
				idTop.add(jogadores.get(i).getId());
			}	
		}
		
		return idTop;
	}

}
