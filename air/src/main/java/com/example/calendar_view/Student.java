package com.example.calendar_view;

public class Student {
    private final String name;
    private final int age;
    private final String graph;

    public Student(String name, int age, String graph) {
        this.name = name;
        this.age = age;
        this.graph = graph;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGraph() {
        return graph;
    }
}
