package com.jamal.integration.project.a.dao;

import com.jamal.integration.project.a.model.Questao;
import com.jamal.integration.project.a.model.Resposta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public void updateQuestao(Questao questao, int id) {
        String SQLupdate = "UPDATE questao "
                + "set questao = ?, formato = ? where id = ?";

        try ( Connection dbcon = dbcon();) {

            PreparedStatement prepareStatement = dbcon.prepareStatement(SQLupdate);
            prepareStatement.setString(1, questao.getQuestao());
            prepareStatement.setString(2, questao.getFormato());
            prepareStatement.setInt(3, id);

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteQuestao(int id) {
        String SQLdelete = " DELETE FROM questao where id = ?";

        try ( Connection dbcon = dbcon();) {

            PreparedStatement prepareStatement = dbcon.prepareStatement(SQLdelete);
            prepareStatement.setInt(1, id);

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void selectFullQuestao() {
        String SQLselect = " SELECT * FROM questao";

        try ( Connection dbcon = dbcon();) {

            Statement stmt = dbcon.createStatement();
            ResultSet rs = stmt.executeQuery(SQLselect);
            {
                while (rs.next()) {
                    System.out.println(rs.getString("id") + "\t"
                            + rs.getString("questao") + "\t"
                            + rs.getString("formato"));

                }
            }

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

    public void updateResposta(Resposta resposta, int id) {
        String SQLupdate = "UPDATE resposta "
                + "set resposta = ?, resposta_correta = ?, id_questao = ? where id = ?";

        try ( Connection dbcon = dbcon();) {

            PreparedStatement prepareStatement = dbcon.prepareStatement(SQLupdate);
            prepareStatement.setString(1, resposta.getResposta());
            prepareStatement.setBoolean(2, resposta.isResposta_correta());
            prepareStatement.setInt(3, resposta.getId_questao());
            prepareStatement.setInt(4, id);

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteResposta(int id) {
        String SQLdelete = " DELETE FROM resposta where id = ?";

        try ( Connection dbcon = dbcon();) {

            PreparedStatement prepareStatement = dbcon.prepareStatement(SQLdelete);
            prepareStatement.setInt(1, id);

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void selectFullResposta() {
        String SQLselect = " SELECT * FROM resposta";

        try ( Connection dbcon = dbcon();) {

            Statement stmt = dbcon.createStatement();
            ResultSet rs = stmt.executeQuery(SQLselect);
            {
                while (rs.next()) {
                    System.out.println(rs.getString("id") + "\t"
                            + rs.getString("resposta") + "\t"
                            + rs.getString("resposta_correta") + "\t"
                            + rs.getString("id_questao"));

                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
