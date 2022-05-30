package br.unigran.restaurante.app.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PratoPedido implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer quantidade;

  @Column(scale = 9, precision = 2)
  private Float valor;

  @ManyToOne
  @JoinColumn(name = "pratoId", nullable = false)
  private Prato prato;

  @ManyToOne
  @JoinColumn(name = "pedidoId", nullable = false)
  private Pedido pedido;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public Prato getPrato() {
    return prato;
  }

  public void setPrato(Prato prato) {
    this.prato = prato;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public Float getValor() {
    return valor;
  }

  public void setValor(Float valor) {
    this.valor = valor;
  }
}
