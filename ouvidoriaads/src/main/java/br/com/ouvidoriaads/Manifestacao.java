package br.com.ouvidoriaads;

public class Manifestacao {
	
		private int codigo;
		private String autor;
		private String tipo;
		private String descricao;
		
		
		@Override
		public String toString() {
			return "\nCodigo: " + codigo + "\nAutor: " + autor + "\nTipo: " + tipo + "\nDescriçao: " + descricao
					;
		}

		public Manifestacao(int codigo, String autor, String tipo, String descricao) {
			super();
			this.codigo = codigo;
			this.autor = autor;
			this.tipo = tipo;
			this.descricao = descricao;
		}

		public Manifestacao(String autor, String tipo, String descricao) {
			super();
			this.autor = autor;
			this.tipo = tipo;
			this.descricao = descricao;
		}

		public Manifestacao() {
			super();
		}

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getAutor() {
			return autor;
		}

		public void setAutor(String autor) {
			this.autor = autor;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
			
			
		}
		
	}



