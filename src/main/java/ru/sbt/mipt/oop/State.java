package ru.sbt.mipt.oop;

public interface State {
    public void activate(String code);

    public void deactivate(String code);
}
