package com.project.mod.fawasell.presenters.base;

public interface View {

    void displayLoadView();

    void removeLoadView();

    void displayRetryView();

    void removeRetryView();

    void displayErrorMessageDialog(String errorMessage);
}
