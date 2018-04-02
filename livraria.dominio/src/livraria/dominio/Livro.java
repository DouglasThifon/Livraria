package livraria.dominio;

import java.util.ArrayList;
import java.util.Date;

public class Livro extends EntidadeDominio {
	private String ano, titulo, edicao, ISBN, numPag, sinopse;
	private boolean status;
	private double custo;
	private Date dataCriacao;
	private Autor autor;
	private Editora editora;
	private Dimensoes dimensoes;
	private GrupoPrecificacao grupoPrecificacao;
	private Condicao condicao;
	private ArrayList<Categoria> categorias = new ArrayList();
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getNumPag() {
		return numPag;
	}
	public void setNumPag(String numPag) {
		this.numPag = numPag;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public Dimensoes getDimensoes() {
		return dimensoes;
	}
	public void setDimensoes(Dimensoes dimensoes) {
		this.dimensoes = dimensoes;
	}
	public GrupoPrecificacao getGrupoPrecificacao() {
		return grupoPrecificacao;
	}
	public void setGrupoPrecificacao(GrupoPrecificacao grupoPrecificacao) {
		this.grupoPrecificacao = grupoPrecificacao;
	}
	public Condicao getCondicao() {
		return condicao;
	}
	public void setCondicao(Condicao condicao) {
		this.condicao = condicao;
	}
	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}

}
