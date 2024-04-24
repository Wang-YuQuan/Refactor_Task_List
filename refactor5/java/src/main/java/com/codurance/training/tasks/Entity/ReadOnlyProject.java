package com.codurance.training.tasks.Entity;

import java.util.ArrayList;
import java.util.List;

public class ReadOnlyProject extends Project{
    public ReadOnlyProject(String projectName, List<Task> tasks) {
        super(projectName, tasks);
    }

    @Override
    public void Add(Task task) {
        throw new RuntimeException();
    }

    @Override
    public void setDone(String idString, boolean done) {
        throw new RuntimeException();
    }
}
