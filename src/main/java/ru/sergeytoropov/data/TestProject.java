package ru.sergeytoropov.data;

import java.util.Date;

/**
 * Created by sergeytoropov on 07.03.17.
 */
public class TestProject {
    private int ident = 0;
    private String code = "alpha";
    private String title = "Проект Альфа";
    private String description = "Секретный проект по поиску внеземной жизни";
    private Date date = new Date();

    public String getIdent() {
        return String.valueOf(ident);
    }

    public void setIdent(String ident) {
        this.ident = Integer.valueOf(ident);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TestProject (" + "id=" + ident + ", code=" + code + ", title=" + title +
                ", description=" + description + ", date=" + date + ")";
    }
}
