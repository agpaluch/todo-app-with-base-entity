package io.github.agpaluch.model;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "tasks")
public class Task extends BaseTask {

    private LocalDateTime deadline;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_group_id")
    private TaskGroup group;


    public Task() {
    }


    void setDeadline(final LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public TaskGroup getGroup() {
        return group;
    }

    public void setGroup(final TaskGroup group) {
        this.group = group;
    }

    public void updateFrom(final Task source) {
        this.setDescription(source.getDescription());
        this.setDone(source.isDone());
        deadline = source.deadline;
        group = source.group;
    }





}
