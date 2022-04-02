package com.jamal.integration.project.a;

import com.jamal.integration.project.a.service.QuestaoInsert;
import com.jamal.integration.project.a.service.RespostaInsert;

public class Main {

    public static void main(String[] args) {

        QuestaoInsert insertQuestao = new QuestaoInsert();

        RespostaInsert insertResposta = new RespostaInsert();

        insertQuestao.insertQuestao();
        insertResposta.insertResposta();
    }
}
