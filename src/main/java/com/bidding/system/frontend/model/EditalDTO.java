/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bidding.system.frontend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

/**
 *
 * @author Usuario
 */
// Classe de transferência de dados (Data Transfer Object) para editais
// DTO é usado para transferir dados entre camadas da aplicação (Controller -> Service -> Repository)
public class EditalDTO {
    // Identificador único do edital no banco de dados
    private Long id;
    // Título do edital (nome do processo de compra)
    private String titulo;
    // Descrição detalhada do edital
    private String descricao;
    // Data e hora de fechamento do edital (quando não mais aceita lances)
    @JsonProperty("data_fechamento")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataFechamento;
    // Status do edital ("ABERTO" = aceitando lances, "FECHADO" = não aceita mais lances)
    private String status;

    // Construtor vazio (padrão do JavaBeans)
    public EditalDTO() {
    }

    // Construtor com todos os parâmetros
    // Permite criar um edital completamente inicializado em uma única chamada
    public EditalDTO(Long id, String titulo, String descricao, LocalDateTime dataFechamento, String status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataFechamento = dataFechamento;
        this.status = status;
    }

    // Método getter - retorna o id do edital
    public Long getId() {
        return id;
    }

    // Método setter - define o id do edital
    public void setId(Long id) {
        this.id = id;
    }

    // Método getter - retorna o título do edital
    public String getTitulo() {
        return titulo;
    }

    // Método setter - define o título do edital
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Método getter - retorna a descrição do edital
    public String getDescricao() {
        return descricao;
    }

    // Método setter - define a descrição do edital
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Método getter - retorna a data de fechamento do edital
    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    // Método setter - define a data de fechamento do edital
    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    // Método getter - retorna o status do edital
    public String getStatus() {
        return status;
    }

    // Método setter - define o status do edital
    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public String getDataFechamentoFormatada() {
        if (dataFechamento == null) return "-";
        return dataFechamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
    
    
}
