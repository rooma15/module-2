package com.epam.esm.web;

import com.epam.esm.model.Certificate;

import java.util.List;
import java.util.Map;

public interface CertificateRepository {
    List<Certificate> retrieveAll();
    Certificate retrieveOne(int id);
    List<Map<String, Object>> retrieveByQuery(String sql, Object...params);
    int create(Certificate certificate);

}
