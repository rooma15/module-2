package com.epam.esm.model;

import com.epam.esm.dto.CertificateDto;
import com.epam.esm.dto.TagDto;

import java.util.List;

public class Certificate {
    private final Integer id;
    private final String name;
    private final String description;
    private final Double price;
    private final Integer duration;
    private final String createDate;
    private final String lastUpdateDate;

    public Certificate(Integer id, String name, String description, Double price, Integer duration,
                       String createDate, String lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public CertificateDto convertToDto(List<TagDto> tags){
        return new CertificateDto(id, name, description, price, duration, createDate, lastUpdateDate, tags);
    }
}
