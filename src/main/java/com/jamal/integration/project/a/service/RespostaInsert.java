package com.jamal.integration.project.a.service;

import com.jamal.integration.project.a.dao.PostgresConnection;
import com.jamal.integration.project.a.model.Resposta;
import java.util.ArrayList;

public class RespostaInsert {

    public void insertResposta() {

        ArrayList<Resposta> respostas = new ArrayList<>();

        Resposta resposta1 = new Resposta("Resposta1", true, 1);
        Resposta resposta2 = new Resposta("Resposta2", false, 2);
        Resposta resposta3 = new Resposta("Resposta3", true, 3);
        Resposta resposta4 = new Resposta("Resposta4", false, 4);

        respostas.add(resposta1);
        respostas.add(resposta2);
        respostas.add(resposta3);
        respostas.add(resposta4);

        PostgresConnection app = new PostgresConnection();

        int countInserts = 0;

        for (int i = 0; i < respostas.size(); i++) {
            app.insertPaciente(respostas.get(i));
            countInserts++;
        }

        System.out.println(countInserts + " respostas inseridas.");
    }

}
