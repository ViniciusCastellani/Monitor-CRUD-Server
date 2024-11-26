package com.example.monitor_service.dao;

import com.example.monitor_service.model.Monitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MonitorDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Inserir Monitor
    public Monitor incluir(Monitor monitor) {
        String sql = "INSERT INTO Monitor (nome, tipo, tamanho, preco) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, monitor.getNome(), monitor.getTipo(), monitor.getTamanho(), monitor.getPreco());
        return monitor;
    }

    // Listar Monitores
    public List<Monitor> listar() {
        String sql = "SELECT * FROM Monitor";
        return jdbcTemplate.query(sql, new MonitorRowMapper());
    }

    // Obter Monitor por ID
    public Monitor obter(int id) {
        String sql = "SELECT * FROM Monitor WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new MonitorRowMapper(), id);
    }

    // Excluir Monitor
    public void excluir(int id) {
        String sql = "DELETE FROM Monitor WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Monitor alterar(Monitor m) {
        String sql = "UPDATE Monitor SET nome = ?, tipo = ?, tamanho = ?, preco = ? " +
                     "WHERE id = ?";
        jdbcTemplate.update(sql, m.getNome(), m.getTipo(), m.getTamanho(), m.getPreco(), m.getId());
        return m;
    }

    // RowMapper para mapear o ResultSet para o objeto Monitor
    private static class MonitorRowMapper implements RowMapper<Monitor> {
        @Override
        public Monitor mapRow(ResultSet rs, int rowNum) throws SQLException {
            Monitor monitor = new Monitor();
            monitor.setId(rs.getInt("id"));
            monitor.setNome(rs.getString("nome"));
            monitor.setTipo(rs.getString("tipo"));
            monitor.setTamanho(rs.getFloat("tamanho"));
            monitor.setPreco(rs.getFloat("preco"));
            return monitor;
        }
    }
}