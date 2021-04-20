package ru.sbt.mipt.oop;

public class Signalization {
    private State state;
    private String code;

    public Signalization(State state, String code) {
        this.state = state;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void activate(String code) {
        this.state.activate(code);
    }

    public void deactivate(String code) {
        this.state.deactivate(code);
    }
}
