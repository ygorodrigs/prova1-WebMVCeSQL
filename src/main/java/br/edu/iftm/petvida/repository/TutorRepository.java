package br.edu.iftm.petvida.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.iftm.petvida.model.Tutor;

@Repository
public class TutorRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void salvar(Tutor tutor) {
        String sql = "INSERT INTO tutor (id_tutor, nome, telefone) VALUES (?, ?, ?)";
        jdbc.update(sql, tutor.getId(), tutor.getNome(), tutor.getTelefone());
    }

    public int contarAnimaisDoTutor(int idTutor) {
        String sql = "SELECT COUNT(*) FROM animal WHERE tutor_id_tutor = ?";
        Integer total = jdbc.queryForObject(sql, Integer.class, idTutor);
        return total != null ? total : 0;
    }
}