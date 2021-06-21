package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
    	// https://www.devmedia.com.br/a-classe-stringbuilder-em-java/25609
    	// https://www.devmedia.com.br/entendendo-java-exceptions/29812
    	// https://www.devmedia.com.br/metodos-da-classe-character-string-em-java-parte-3/21811
    	if (texto == "") {
    		throw new IllegalArgumentException("O texto não pode ser vazio!");
    	}
    	if (texto == null) {
    		throw new NullPointerException("O texto não pode ser nulo!");
    	}
    	
    	texto = texto.toLowerCase();
    	StringBuilder textoCriptografado = new StringBuilder();
    	
    	for (int i = 0; i < texto.length(); i++) {
    		char c = texto.charAt(i);
    		int tabelaASCII = (int) c;

    		if (tabelaASCII >= 65) {
    			tabelaASCII += 3;
    		}
    		textoCriptografado.append((char)tabelaASCII);
    	}
    	
    	return textoCriptografado.toString();
    }

    @Override
    public String descriptografar(String texto) {
    	if (texto == "") {
    		throw new IllegalArgumentException("O texto não pode ser vazio!");
    	}
    	if (texto == null) {
    		throw new NullPointerException("O texto não pode ser nulo!");
    	}
    	
    	texto = texto.toLowerCase();
    	StringBuilder textoDescriptografado = new StringBuilder();
    	
    	for (int i = 0; i < texto.length(); i++) {
    		char c = texto.charAt(i);
    		int tabelaASCII = (int) c;
    		
    		if (tabelaASCII >= 65 ) {
    			tabelaASCII -= 3;
    		}
    		textoDescriptografado.append((char)tabelaASCII);
    	}
    	
    	return textoDescriptografado.toString();
    }
}
