package com.codurance.training.tasks.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Project {
    private String projectName;
    private List<Task> tasks;

    public Project(String projectName) {
        this.projectName = projectName;
        this.tasks = new ArrayList<>();
    }

    public String getProjectName() {
        return projectName;
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public void Add(Task task) {
        tasks.add(task);
    }

    public int getTaskLength() {
        return tasks.size();
    }
}
