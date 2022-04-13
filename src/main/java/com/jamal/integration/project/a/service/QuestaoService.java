package com.jamal.integration.project.a.service;

import com.jamal.integration.project.a.dao.PostgresConnection;
import com.jamal.integration.project.a.model.Questao;
import java.util.ArrayList;

public class QuestaoService {

    public void questaoActions() {

        ArrayList<Questao> questoes = new ArrayList<>();

        Questao questao1 = new Questao("As desigualdades raciais e sociais expressam oque recorrentemente?", "Multipla Escolha");
        Questao questao2 = new Questao("Em que ano foi criada a Lei Áurea?", "Multipla Escolha");
        Questao questao3 = new Questao("Como tecnologia exerce um papel para resolver o problema das desigualdades raciais e sociais?", "Multipla Escolha");
        Questao questao4 = new Questao("Em qual ano foi criada a Lei Áurea?", "Multipla Escolha");

        questoes.add(questao1);
        questoes.add(questao2);
        questoes.add(questao3);

        PostgresConnection app = new PostgresConnection();

        int countInserts = 0;

        for (int i = 0; i < questoes.size(); i++) {
            app.insertQuestao(questoes.get(i));
            countInserts++;
        }

        app.selectFullQuestao();

        app.updateQuestao(questao4, 2);

        app.selectFullQuestao();

        app.deleteQuestao(2);

        app.selectFullQuestao();

    }
}
