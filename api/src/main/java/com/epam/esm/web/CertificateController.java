package com.epam.esm.web;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/certificates")
public class CertificateController {
    @RequestMapping(method=GET, produces = "application/json")
    public Map<Integer, String> getCertificates(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "привет");
        map.put(2, "пока");
        return map;
    }
}
