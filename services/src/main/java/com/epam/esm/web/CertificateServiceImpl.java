package com.epam.esm.web;

import com.epam.esm.dto.CertificateDto;
import com.epam.esm.dto.TagDto;
import com.epam.esm.model.Certificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService{

    private final CertificateRepository certificateRepository;


    @Autowired
    public CertificateServiceImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    public int create(CertificateDto certificateDto) {
        Certificate certificate = certificateDto.convertToCertificateModel();
        List<TagDto> tagDtos = certificateDto.getTags();
        return 1;
    }

    @Override
    public List<CertificateDto> retrieveAll() {
        return null;
    }

    @Override
    public CertificateDto retrieveOne(int id) {
        return null;
    }
}
