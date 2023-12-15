package com.example.tatarestapitest.DataTransferObjects.CreateDTO;

import javax.validation.constraints.NotNull;
public class TaskCreationDTO {
    @NotNull(message = "Title is Required.")
    private String title;
    @NotNull(message = "Description is Required.")
    private String Description;

    @NotNull(message = "Completion status is required.")
    private Boolean completed;

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
