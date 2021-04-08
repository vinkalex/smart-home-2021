package rc;

public interface RemoteControleRegistry {

    /**
     * Register remote control with id rcId.
     * When button on a real remote control device is pressed this library will call remoteControl.onButtonPressed(...).
     * @param remoteControle
     * @param rcId
     */
    public void registerRemoteControl(RemoteControle remoteControle, String rcId);
        // here goes some library code which registers our remote control with given ID (rcId)


}