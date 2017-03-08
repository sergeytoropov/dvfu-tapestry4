package ru.sergeytoropov.pages;

import org.apache.tapestry.IRequestCycle;
import org.apache.tapestry.html.BasePage;
import ru.sergeytoropov.data.TestProject;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sergeytoropov on 07.03.17.
 */
public abstract class Home extends BasePage {
    public final TestProject testProject = new TestProject();

    public void setIdent(String ident) {
        testProject.setIdent(ident);
    }

    public void setCode(String code) {
        testProject.setCode(code);
    }

    public void setTitle(String title) {
        testProject.setTitle(title);
    }

    public void setDescription(String description) {
        testProject.setDescription(description);
    }

    public void setDate(Date date) {
        testProject.setDate(date);
    }

    public String getIdent() {
        return testProject.getIdent();
    }

    public String getCode() {
        return testProject.getCode();
    }

    public String getTitle() {
        return testProject.getTitle();
    }

    public String getDescription() {
        return testProject.getDescription();
    }

    public Date getDate() {
        return testProject.getDate();
    }

    public Format getDateFormat() {
        return new SimpleDateFormat("dd-MM-yyyy");
    }

    public void actionOnEdit(IRequestCycle cycle) {
        System.out.println("Listener called. TestProject is: " + testProject);

        Edit editPage = (Edit) cycle.getPage("Edit");
        editPage.setIdent(testProject.getIdent());
        editPage.setCode(testProject.getCode());
        editPage.setTitle(testProject.getTitle());
        editPage.setDescription(testProject.getDescription());
        editPage.setDate(testProject.getDate());
        cycle.activate("Edit");
    }
}
