package aplicacao;

import java.util.Date;

import negocio.entidades.Departamento;
import negocio.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {

		Departamento obj = new Departamento(1, "Livros");
		System.out.println(obj);
		
		Vendedor vendedor = new Vendedor(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		System.out.println(vendedor);
	}

}