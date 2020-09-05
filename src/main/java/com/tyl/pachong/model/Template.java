package com.tyl.pachong.model;

public class Template {
    String template_id;
    String renderer_accelerate;

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getRenderer_accelerate() {
        return renderer_accelerate;
    }

    public void setRenderer_accelerate(String renderer_accelerate) {
        this.renderer_accelerate = renderer_accelerate;
    }

    @Override
    public String toString() {
        return "Template{" +
                "template_id='" + template_id + '\'' +
                ", renderer_accelerate='" + renderer_accelerate + '\'' +
                '}';
    }
}
