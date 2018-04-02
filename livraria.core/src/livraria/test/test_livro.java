package livraria.test;

import livraria.dominio.*;
import livraria.core.impl.dao.LivroDAO;

public class test_livro {
	public static void main (String[] args) {
		Livro livro = new Livro();
		Autor autor = new Autor();
		Editora edit = new Editora();
		Dimensoes dim = new Dimensoes();
		GrupoPrecificacao gpc = new GrupoPrecificacao();
		
		livro.setAno("1500");
		autor.setId(1);
		livro.setAutor(autor);
		livro.setTitulo("Lord of the rings");
		livro.setEdicao("Segunda");
		livro.setISBN("1212323");
		livro.setNumPag("1000");
		livro.setSinopse("Tinha um cabra muito macho, que forjou um anel");
		edit.setId(1);
		livro.setEditora(edit);
		dim.setId(1);
		livro.setDimensoes(dim);
		gpc.setId(1);
		livro.setGrupoPrecificacao(gpc);
		LivroDAO ldao = new LivroDAO();
		ldao.salvar(livro);
		
	}
}