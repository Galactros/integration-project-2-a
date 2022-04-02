package com.jamal.integration.project.a.model;

public class Questao {

    private int id;
    private String questao;
    private String formato;

    public Questao(String questao, String formato) {
        this.questao = questao;
        this.formato = formato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

}
