package com.benasselmeier.redhawkrentals.models.forms;
import javax.validation.constraints.NotNull;

public class SearchForm {

    @NotNull
    private String searchTerm;

    public SearchForm () { }

    public SearchForm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getSearchTerm() {return searchTerm;}

    public void setSearchTerm(String searchTerm) { this.searchTerm = searchTerm; }
}

