package com.tyl.pachong.mapper;

import com.tyl.pachong.model.Template;

import java.util.List;

public interface TemplateMapper {
    void insert(Template template);

    List<Template> findAll();
}
