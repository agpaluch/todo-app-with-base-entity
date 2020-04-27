package io.github.agpaluch.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseTask{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Description must not be empty")
    private String description;
    private boolean done;

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(final boolean done) {
        this.done = done;
    }

    LocalDateTime getCreatedOn() {
        return createdOn;
    }

    void setCreatedOn(final LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    void setUpdatedOn(final LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    @PrePersist
    void prePersist() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    void preUpdate() {
        updatedOn = LocalDateTime.now();
    }



}
