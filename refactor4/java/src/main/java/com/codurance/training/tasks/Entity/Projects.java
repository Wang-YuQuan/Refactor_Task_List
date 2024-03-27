package com.codurance.training.tasks.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Projects {
    public static Projects instance = null;
    public List<Project> projects;

    private Projects() {
        projects = new ArrayList<Project>();
    }

    public static Projects instance() {
        if (instance == null) {
            instance = new Projects();
        }
        return instance;
    }

    public List<Project> getAllProject() {
        return Collections.unmodifiableList(projects);
    }

    private Project getProject(String projectName) {
        for(Project project : projects) {
            if(project.getProjectName().equals(projectName)) {
                return project;
            }
        }
        return null;
    }

    public int getNextID() {
        int result = 0;
        for(Project project : projects) {
            result += project.getTaskLength();
        }
        return result;
    }

    public void addProject(String projectName) {
        if(getProject(projectName) == null) {
            projects.add(new Project(projectName));
        }
    }

    public int addTask(String projectName, String taskDesc) {
        Project project = getProject(projectName);
        if (project == null) {
            return -1;
        }
        project.Add(new Task(getNextID()+1, taskDesc, false));
        return 0;
    }
}