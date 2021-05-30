package br.edu.unidep.webservice.model.dominio;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.unidep.webservice.model.utils.ETipoVenda;

@Entity
@Table(name = "venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_venda")
	private Long id;
	
	
	@Column(name = "valor_venda")
	@Size(max = 50)
	private double valorVenda;
	
	@Column(name = "data_venda")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dataVenda;
	
	@Column(name = "tipo_venda")
	private ETipoVenda tipoVenda;
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "codigo_pessoa")
    Pessoa pessoa;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "codigo_produto")
    Produto produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public ETipoVenda getTipoVenda() {
		return tipoVenda;
	}

	public void setTipoVenda(ETipoVenda tipoVenda) {
		this.tipoVenda = tipoVenda;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", valorVenda=" + valorVenda + ", dataVenda=" + dataVenda + ", tipoVenda="
				+ tipoVenda + ", pessoa=" + pessoa + ", produto=" + produto + "]";
	}
    
}
