package com.jamal.integration.project.a.service;

import com.jamal.integration.project.a.dao.PostgresConnection;
import com.jamal.integration.project.a.model.Questao;
import java.util.ArrayList;

public class QuestaoInsert {

    public void insertQuestao() {

        ArrayList<Questao> questoes = new ArrayList<>();

        Questao questao1 = new Questao("Questao1", "Multipla Escolha");
        Questao questao2 = new Questao("Questao2", "Multipla Escolha");
        Questao questao3 = new Questao("Questao3", "Multipla Escolha");
        Questao questao4 = new Questao("Questao4", "Multipla Escolha");

        questoes.add(questao1);
        questoes.add(questao2);
        questoes.add(questao3);
        questoes.add(questao4);

        PostgresConnection app = new PostgresConnection();

        int countInserts = 0;

        for (int i = 0; i < questoes.size(); i++) {
            app.insertPaciente(questoes.get(i));
            countInserts++;
        }

        System.out.println(countInserts + " Questões inseridas.");
    }
}
