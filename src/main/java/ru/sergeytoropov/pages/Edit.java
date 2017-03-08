package ru.sergeytoropov.pages;

import org.apache.tapestry.IRequestCycle;
import org.apache.tapestry.form.IFormComponent;
import org.apache.tapestry.html.BasePage;
import org.apache.tapestry.valid.ValidationConstraint;
import org.apache.tapestry.valid.ValidationDelegate;

import java.util.Date;

/**
 * Created by sergeytoropov on 07.03.17.
 */
public abstract class Edit extends BasePage {
    private String ident;
    private String code;
    private String title;
    private String description;
    private Date date;

    private ValidationDelegate delegate = new ValidationDelegate();

    public ValidationDelegate getDelegate() {
        return delegate;
    }

    private String buttonClicked;

    public void setButtonClicked(String buttonClicked) {
        this.buttonClicked = buttonClicked;
    }

    public void actionOnSave(IRequestCycle cycle) {
        if (buttonClicked.equals("SAVE")) {
            delegate = (ValidationDelegate) getBeans().getBean("delegate");
            try {
                int id = Integer.parseInt(ident);
            } catch (NumberFormatException e) {
                delegate.setFormComponent((IFormComponent) getComponent("editIdent"));
                delegate.recordFieldInputValue(ident);
                delegate.record("Идентификатор: не является числом.", ValidationConstraint.NUMBER_FORMAT);
            }

            if (code.length() > 10) {
                delegate.setFormComponent((IFormComponent) getComponent("editCode"));
                delegate.recordFieldInputValue(code);
                delegate.record("Длина поля Код: не может быть больше 10.", ValidationConstraint.MAXIMUM_WIDTH);
            }

            if (title.length() > 30) {
                delegate.setFormComponent((IFormComponent) getComponent("editTitle"));
                delegate.recordFieldInputValue(title);
                delegate.record("Длина поля Название: не может быть больше 30.", ValidationConstraint.MAXIMUM_WIDTH);
            }

            if (description.length() > 100) {
                delegate.setFormComponent((IFormComponent) getComponent("editDescription"));
                delegate.recordFieldInputValue(title);
                delegate.record("Длина поля Описание: не может быть больше 100.", ValidationConstraint.MAXIMUM_WIDTH);
            }

            if (delegate.getHasErrors()) {
                cycle.activate(this);
                return;
            }

            Home homePage = (Home) cycle.getPage("Home");
            homePage.setIdent(ident);
            homePage.setCode(code);
            homePage.setTitle(title);
            homePage.setDescription(description);
            homePage.setDate(date);
        }
        if (buttonClicked.equals("CANCEL")) {
        }
        cycle.activate("Home");
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
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
}
