package signalization;

public class Signalization {
    private State state;

    public Signalization() {
        this.state = new SignalizationDeactivated(this);
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

    public void alarm() {this.state.alarm();}

    public boolean isActivated() {
        return this.state instanceof SignalizationActivated;
    }

    public boolean isAlarmed() {
        return this.state instanceof SignalizationAlarmed;
    }
}
