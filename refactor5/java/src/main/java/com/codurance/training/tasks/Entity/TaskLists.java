package com.codurance.training.tasks.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskLists {
    public static TaskLists instance = null;
    public List<Project> projects;

    private TaskLists() {
        projects = new ArrayList<Project>();
    }

    public static TaskLists instance() {
        if (instance == null) {
            instance = new TaskLists();
        }
        return instance;
    }

    public List<Project> getAllProject() {
        List<Project> readOnlyProjects = new ArrayList<>();
        for(Project project : projects) {
            ReadOnlyProject readOnlyProject = new ReadOnlyProject(project.getProjectName(), project.getTasks());
            readOnlyProjects.add(readOnlyProject);
        }
        return readOnlyProjects;
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
            projects.add(new Project(projectName, new ArrayList<>()));
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

    public boolean setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        Project targetProject = null;
        for (Project project : projects) {
            for (Task task : project.getTasks()) {
                if (task.getId() == id) {
                    targetProject = project;
                }
            }
        }
        if(targetProject != null) {
            targetProject.setDone(idString, done);
            return true;
        }
        return false;
    }
}