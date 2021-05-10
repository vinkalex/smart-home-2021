package signalization;

public interface State {
    void activate(String code);

    void deactivate(String code);

    void alarm();
}
