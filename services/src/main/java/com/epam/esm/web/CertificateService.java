package com.epam.esm.web;

import com.epam.esm.dto.CertificateDto;

import java.util.List;

public interface CertificateService {
    int create(CertificateDto certificateDto);
    List<CertificateDto> retrieveAll();
    CertificateDto retrieveOne(int id);
}
