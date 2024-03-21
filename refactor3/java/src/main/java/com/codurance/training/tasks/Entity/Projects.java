package com.codurance.training.tasks.Entity;

import java.util.ArrayList;
import java.util.List;

public class Projects {
    public static Projects instance = null;
    public ArrayList<Project> projects;

    private Projects() {
        projects = new ArrayList<Project>();
    }

    public static Projects instance() {
        if (instance == null) {
            instance = new Projects();
        }
        return instance;
    }

    public ArrayList<Project> getAllProject() {
        return projects;
    }

    public Project getProject(String projectName) {
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
        projects.add(new Project(projectName));
    }
}