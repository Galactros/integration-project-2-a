package com.jamal.integration.project.a.service;

import com.jamal.integration.project.a.dao.PostgresConnection;
import com.jamal.integration.project.a.model.Questao;
import com.jamal.integration.project.a.model.Resposta;
import java.util.ArrayList;

public class QuestionarioService {

    public void questionarioActions() {

        ArrayList<Questao> questoes = new ArrayList<>();
        ArrayList<Resposta> respostas = new ArrayList<>();

        Questao questao1 = new Questao("As desigualdades raciais e sociais expressam oque recorrentemente?", "Multipla Escolha");
        Questao questao2 = new Questao("Em que ano foi criada a Lei Áurea?", "Multipla Escolha");
        Questao questao3 = new Questao("Como tecnologia exerce um papel para resolver o problema das desigualdades raciais e sociais?", "Multipla Escolha");
        Questao questao4 = new Questao("Qual processo que a educação desenvolve?", "Multipla Escolha");
        Questao questao5 = new Questao("Porque mesmo com a abolição da escravidão os direitos nao continuam igual?", "Multipla Escolha");
        Questao questao6 = new Questao("Em qual ano foi criada a Lei Áurea?", "Multipla Escolha");

        Resposta resposta1 = new Resposta("A negligenciação a qual homens e mulheres, identificados como pretos ou pardos são submetidos ao longo da vida.", true, 1);
        Resposta resposta2 = new Resposta("1888", true, 2);
        Resposta resposta3 = new Resposta("A tecnologia exerce um papel muito importante na comunicação, propagação da informação e na forma como aprendemos.", true, 3);
        Resposta resposta4 = new Resposta("1889", false, 2);

        questoes.add(questao1);
        questoes.add(questao2);
        questoes.add(questao3);
        questoes.add(questao4);
        questoes.add(questao5);

        respostas.add(resposta1);
        respostas.add(resposta2);
        respostas.add(resposta3);

        PostgresConnection app = new PostgresConnection();

        for (int i = 0; i < questoes.size(); i++) {
            app.insertQuestao(questoes.get(i));
        }

        for (int i = 0; i < respostas.size(); i++) {
            app.insertResposta(respostas.get(i));
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");

        app.selectFullQuestao();

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");

        app.selectFullResposta();

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");

        app.updateQuestao(questao6, 2);
        app.selectFullQuestao();

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");

        app.updateResposta(resposta4, 2);
        app.selectFullResposta();

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");

        app.deleteResposta(3);
        app.selectFullResposta();

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");

        app.deleteQuestao(3);
        app.selectFullQuestao();

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

}
