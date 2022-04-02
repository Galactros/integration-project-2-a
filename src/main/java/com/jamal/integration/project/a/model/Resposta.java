package com.jamal.integration.project.a.model;

public class Resposta {

    private int id;
    private String resposta;
    private boolean resposta_correta;
    private int id_questao;

    public Resposta(String resposta, boolean resposta_correta, int id_questao) {
        this.resposta = resposta;
        this.resposta_correta = resposta_correta;
        this.id_questao = id_questao;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public boolean isResposta_correta() {
        return resposta_correta;
    }

    public void setResposta_correta(boolean resposta_correta) {
        this.resposta_correta = resposta_correta;
    }

    public int getId_questao() {
        return id_questao;
    }

    public void setId_questao(int id_questao) {
        this.id_questao = id_questao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
