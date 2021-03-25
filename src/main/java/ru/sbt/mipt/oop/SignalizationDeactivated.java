package ru.sbt.mipt.oop;

public class SignalizationDeactivated implements State{
    private Signalization signalization;

    public SignalizationDeactivated(Signalization signalization) {
        this.signalization = signalization;
    }

    @Override
    public void activate(String code) {
        this.signalization = new Signalization(new SignalizationActivated(this.signalization), code);
    }

    @Override
    public void deactivate(String code) {}
}
