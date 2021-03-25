package ru.sbt.mipt.oop;

public class SignalizationAlarm implements State {
    private final Signalization signalization;
    private final String message = "ALARM! There is someone in the house!";

    public SignalizationAlarm(Signalization signalization) {
        this.signalization = signalization;
        System.out.println(this.message);
    }

    @Override
    public void activate(String code) {
        System.out.println(this.message);
    }

    @Override
    public void deactivate(String code) {
        System.out.println(this.message);
    }
}
