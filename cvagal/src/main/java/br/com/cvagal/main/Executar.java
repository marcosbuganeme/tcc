package br.com.cvagal.main;

import br.com.cvagal.utilitarios.criptografia.UtilCriptografia;


public class Executar {
	
	public static void main(String[] args) {

		System.out.println(UtilCriptografia.obterStringMD5("123"));
	}
}
