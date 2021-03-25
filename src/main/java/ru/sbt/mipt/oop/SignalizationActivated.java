package ru.sbt.mipt.oop;

public class SignalizationActivated implements State{
    private final Signalization signalization;

    public SignalizationActivated(Signalization signalization) {
        this.signalization = signalization;
    }

    @Override
    public void activate(String code) {}

    @Override
    public void deactivate(String code) {
        if (!this.signalization.getCode().equals(code)) {
            this.signalization.changeState(new SignalizationAlarm(this.signalization));
        } else this.signalization.changeState(new SignalizationDeactivated(this.signalization));
    }
}
