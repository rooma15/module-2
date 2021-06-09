package com.epam.esm.model;

import com.epam.esm.dto.TagDto;

public class Tag {
    private final Integer id;
    private final String name;

    public Tag(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TagDto convertToDto(){
        return new TagDto(id, name);
    }
}
