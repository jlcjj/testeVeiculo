package com.axios.Veiculos.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 150)
	private String veiculo;
	@Column(nullable = false, length = 150)
	private String marca;
	private Integer ano;
	@Column(nullable = false, length = 250)
	private String descricao;
	private Boolean vendido;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate created;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate updated;
	@Column(nullable = false, unique = true)
	private String chassi;
	private BigDecimal preco;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getVendido() {
		return vendido;
	}
	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}
	
	
	public LocalDate getCreated() {
		return created;
	}
	public void setCreated(LocalDate created) {
		this.created = created;
	}
	public LocalDate getUpdated() {
		return updated;
	}
	public void setUpdated(LocalDate updated) {
		this.updated = updated;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public void prePersist() {
		setCreated(LocalDate.now());
	}

}
