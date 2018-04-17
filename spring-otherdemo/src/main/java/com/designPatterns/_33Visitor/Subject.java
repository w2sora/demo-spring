package com.designPatterns._33Visitor;

public interface Subject {
    void accept(Visitor visitor);

    String getSubject();
}
