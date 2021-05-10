package rc;

public class RemoteControleRegistruImpl implements RemoteControleRegistry{
    @Override
    public void registerRemoteControl(RemoteControle remoteControle, String rcId) {
        remoteControle.setRcId(rcId);
    }
}
