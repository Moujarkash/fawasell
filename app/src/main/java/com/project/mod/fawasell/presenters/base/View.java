package com.project.mod.fawasell.presenters.base;

public interface View {

    void displayLoadView();

    void removeLoadView();

    void displayErrorMessageDialog(String errorMessage);
}
