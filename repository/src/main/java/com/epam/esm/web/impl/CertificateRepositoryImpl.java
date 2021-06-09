package com.epam.esm.web.impl;

import com.epam.esm.model.Certificate;
import com.epam.esm.web.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public class CertificateRepositoryImpl implements CertificateRepository {

    private final String GET_ALL_CERTIFICATES = "SELECT * FROM certificate";
    private final String GET_CERTFICATE_BY_ID = "SELECT * FROM certificate where id=?";
    private final String CREATE_CERTIFICATE = "INSERT INTO certificate" +
            "(id, name, description, price, duration, create_date, last_update_date)" +
            "VALUES(null, ?, ?, ?, ?, ?, ?)";

    private JdbcOperations jdbcOperations;

    @Autowired
    public CertificateRepositoryImpl(JdbcOperations jdbcOperations){
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Certificate> retrieveAll() {
        return jdbcOperations.query(GET_ALL_CERTIFICATES, (rs, rowNum) -> new Certificate(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getDouble("price"),
                rs.getInt("duration"),
                rs.getString("create_date"),
                rs.getString("last_update_date")

        ));
    }

    @Override
    public Certificate retrieveOne(int id) {
        return jdbcOperations.queryForObject(GET_CERTFICATE_BY_ID, (rs, rowNum) -> new Certificate(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getDouble("price"),
                rs.getInt("duration"),
                rs.getString("create_date"),
                rs.getString("last_update_date")) , id);
    }

    @Override
    public List<Map<String, Object>> retrieveByQuery(String sql, Object... params) {
        return jdbcOperations.queryForList(sql, params);
    }

    @Override
    public int create(Certificate certificate) {
        return jdbcOperations.update(CREATE_CERTIFICATE,
                certificate.getName(),
                certificate.getDescription(),
                certificate.getPrice(),
                certificate.getDuration(),
                certificate.getCreateDate(),
                certificate.getLastUpdateDate());
    }


}
