package com.jamal.integration.project.a.dao;

import com.jamal.integration.project.a.model.Paciente;
import com.jamal.integration.project.a.model.Paciente_Vacina;
import com.jamal.integration.project.a.model.Vacina;
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

    public void insertPaciente(Paciente paciente) {
        String SQLinsert = "INSERT INTO paciente(nome,idade,endereco) "
                + "VALUES(?,?,?)";

        try ( Connection dbcon = dbcon();) {

            PreparedStatement prepareStatement = dbcon.prepareStatement(SQLinsert);
            prepareStatement.setString(1, paciente.getNome());
            prepareStatement.setInt(2, paciente.getIdade());
            prepareStatement.setString(3, paciente.getEndereco());

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertVacina(Vacina vacina) {
        String SQLinsert = "INSERT INTO vacina(nome,ano,imunidade_duracao) "
                + "VALUES(?,?,?)";

        try ( Connection dbcon = dbcon();) {

            PreparedStatement prepareStatement = dbcon.prepareStatement(SQLinsert);
            prepareStatement.setString(1, vacina.getNome());
            prepareStatement.setInt(2, vacina.getAno());
            prepareStatement.setInt(3, vacina.getImunidade_duracao());

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertVinculos(Paciente_Vacina vinculo) {
        String SQLinsert = "INSERT INTO paciente_vacina(id_paciente,id_vacina,vacinacao_date) "
                + "VALUES(?,?,?::date)";

        try ( Connection dbcon = dbcon();) {

            PreparedStatement prepareStatement = dbcon.prepareStatement(SQLinsert);
            prepareStatement.setInt(1, vinculo.getId_paciente());
            prepareStatement.setInt(2, vinculo.getId_vacina());
            prepareStatement.setString(3, vinculo.getVacinacao_date());

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
