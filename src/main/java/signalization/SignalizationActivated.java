package signalization;

public class SignalizationActivated implements State{
    private final Signalization signalization;
    private final String code;

    public SignalizationActivated(Signalization signalization, String code) {
        this.code = code;
        this.signalization = signalization;
    }

    @Override
    public void activate(String code) {}

    @Override
    public void deactivate(String code) {
        if (!this.code.equals(code)) {
            this.signalization.changeState(new SignalizationAlarmed(this.signalization));
        } else this.signalization.changeState(new SignalizationDeactivated(this.signalization));
    }
}
