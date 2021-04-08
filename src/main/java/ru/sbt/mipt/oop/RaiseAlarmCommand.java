package ru.sbt.mipt.oop;

public class RaiseAlarmCommand implements Command{
    private final Signalization signalization;

    public RaiseAlarmCommand(Signalization signalization) {
        this.signalization = signalization;
    }

    public void execute() {
        signalization.changeState(new SignalizationAlarm(signalization));
    }

}
