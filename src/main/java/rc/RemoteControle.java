package rc;

public interface RemoteControle {
    /**
     * This method will be called when a button buttonCode is pressed on a remote control with id rcId
     * @param buttonCode button letter: “A”, “B”, “C”, “D”, “1”, “2”, “3”, “4”
     * @param rcId remote control id
     */
    public void onButtonPressed(String buttonCode, String rcId);

    public void setRcId(String rcId);
}
