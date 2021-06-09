package com.epam.esm.web;
import com.epam.esm.dto.CertificateDto;
import com.epam.esm.model.Certificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateService certificateService;

    @Autowired
    public CertificateController(CertificateService certificateService){
        this.certificateService = certificateService;
    }

    @RequestMapping(method=GET, produces = "application/json")
    public List<CertificateDto> getCertificates(){
        return certificateService.retrieveAll();
    }


    @RequestMapping(value = "update", method = POST, consumes = "application/json")
    public Set<?> update(@RequestBody HashMap<?, ?> map){
        return map.keySet();
    }

    @RequestMapping(value = "create", method = POST, consumes = "application/json")
    public CertificateDto update(@RequestBody CertificateDto certificate){
        if(certificateService.create(certificate) == 1){
            return certificate;
        }else {
            return null;
        }
    }
}
