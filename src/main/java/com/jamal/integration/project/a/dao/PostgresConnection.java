package com.jamal.integration.project.a.dao;

import com.jamal.integration.project.a.model.Questao;
import com.jamal.integration.project.a.model.Resposta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgresConnection {

    private final String url = "jdbc:postgresql://localhost:5432/questionario";
    private final String user = "postgres";
    private final String password = "admin";

    public Connection dbcon() {
        Connection dbcon = null;

        try {
            dbcon = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return dbcon;
    }

    public void insertQuestao(Questao questao) {
        String SQLinsert = "INSERT INTO questao(questao,formato) "
                + "VALUES(?,?)";

        try ( Connection dbcon = dbcon();) {

            PreparedStatement prepareStatement = dbcon.prepareStatement(SQLinsert);
            prepareStatement.setString(1, questao.getQuestao());
            prepareStatement.setString(2, questao.getFormato());

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertResposta(Resposta resposta) {
        String SQLinsert = "INSERT INTO resposta(resposta,resposta_correta, id_questao) "
                + "VALUES(?,?,?)";

        try ( Connection dbcon = dbcon();) {

            PreparedStatement prepareStatement = dbcon.prepareStatement(SQLinsert);
            prepareStatement.setString(1, resposta.getResposta());
            prepareStatement.setBoolean(2, resposta.isResposta_correta());
            prepareStatement.setInt(3, resposta.getId_questao());

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
