package signalization;

public class SignalizationDeactivated implements State{
    private final Signalization signalization;

    public SignalizationDeactivated(Signalization signalization) {
        this.signalization = signalization;
    }

    @Override
    public void activate(String code) {
        this.signalization.changeState(new SignalizationActivated(this.signalization, code));
    }

    @Override
    public void deactivate(String code) {}

    @Override
    public void alarm() {this.signalization.changeState(new SignalizationAlarmed(this.signalization));}
}
