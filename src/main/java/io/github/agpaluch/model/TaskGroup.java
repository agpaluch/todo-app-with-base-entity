package io.github.agpaluch.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "task_groups")
public class TaskGroup extends BaseTask{

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    @JsonIgnore
    private Set<Task> tasks;

    public TaskGroup() {
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(final Set<Task> tasks) {
        this.tasks = tasks;
    }

}
