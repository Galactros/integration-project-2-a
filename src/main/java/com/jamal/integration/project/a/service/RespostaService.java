package com.jamal.integration.project.a.service;

import com.jamal.integration.project.a.dao.PostgresConnection;
import com.jamal.integration.project.a.model.Resposta;
import java.util.ArrayList;

public class RespostaService {

    public void respostaActions() {

        ArrayList<Resposta> respostas = new ArrayList<>();

        Resposta resposta1 = new Resposta("A negligenciação a qual homens e mulheres, identificados como pretos ou pardos são submetidos ao longo da vida.", true, 1);
        Resposta resposta2 = new Resposta("1888", true, 2);
        Resposta resposta3 = new Resposta("A tecnologia exerce um papel muito importante na comunicação, propagação da informação e na forma como aprendemos.", true, 3);
        Resposta resposta4 = new Resposta("1889", false, 2);

        respostas.add(resposta1);
        respostas.add(resposta2);
        respostas.add(resposta3);

        PostgresConnection app = new PostgresConnection();

        for (int i = 0; i < respostas.size(); i++) {
            app.insertResposta(respostas.get(i));
        }

        app.selectFullResposta();

        app.updateResposta(resposta4, 2);

        app.selectFullResposta();

        app.deleteResposta(2);

        app.selectFullResposta();
    }

}
