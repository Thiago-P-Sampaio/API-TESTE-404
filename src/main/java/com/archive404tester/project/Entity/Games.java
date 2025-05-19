package com.archive404tester.project.Entity;


import jakarta.persistence.*;

@Entity
@Table (name = "tb_game")
public class Games {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String desenvolvedora;
    private String genero;
    private String lancamento;
    private String img;


    public Games() {
    }

    public Games(Long id, String nome, String descricao, String desenvolvedora, String genero, String lancamento, String img) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.desenvolvedora = desenvolvedora;
        this.genero = genero;
        this.lancamento = lancamento;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
