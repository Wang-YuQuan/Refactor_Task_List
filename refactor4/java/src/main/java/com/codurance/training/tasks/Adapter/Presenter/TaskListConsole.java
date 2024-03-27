package com.codurance.training.tasks.Adapter.Presenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public final class TaskListConsole {
    private final BufferedReader in;
    private final PrintWriter out;

    public TaskListConsole(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    public void getView(String result) {
        this.out.print(result);
    }
}