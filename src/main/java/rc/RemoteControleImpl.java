package rc;

import command.Command;

import java.util.Map;

public class RemoteControleImpl implements RemoteControle{
    private String rcId;
    private final RemoteControle nextRemoteControle;
    private final Map<String, Command> controle;

    public RemoteControleImpl(String rcId, RemoteControle nextRemoteControle, Map<String, Command> controle) {
        this.rcId = rcId;
        this.nextRemoteControle = nextRemoteControle;
        this.controle = controle;
    }
    @Override
    public void setRcId(String rcId) {
        this.rcId = rcId;
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        if (this.rcId == rcId) {
            Command command = this.controle.get(buttonCode);
            command.execute();
        } else {
            this.nextRemoteControle.onButtonPressed(buttonCode, rcId);
        }
    }
}
