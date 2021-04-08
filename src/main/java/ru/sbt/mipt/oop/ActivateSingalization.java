package ru.sbt.mipt.oop;

public class ActivateSingalization implements Command {
    private final Signalization signalization;
    private final String code;

    public ActivateSingalization(Signalization signalization, String code) {
        this.code = code;
        this.signalization = signalization;
    }

    public void execute() {
        signalization.activate(code);
    }

}
