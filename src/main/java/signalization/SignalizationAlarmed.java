package signalization;

public class SignalizationAlarmed implements State {
    private final Signalization signalization;
    private final String message = "Signalization alarmed!";

    public SignalizationAlarmed(Signalization signalization) {
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
