package freelec.chainofresponsibility.server;

// 서버 측에서 구현

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Market extends Remote {

    // 클라이언트 객체를 서버 측에 등록하는 메소드로서
    // 클라이언트 측에서 호출할 수 있도록 제공되는 서비스 메소드가 된다.
    public void regist(Client c) throws RemoteException;

    // 서버 측에서 이벤트가 발생하게 되면, 이를 인지하도록
    // 클라이언트에게 이를 통보하는 메소드
    public void sendMessageToClient(Object[] obj, String msg)
            throws RemoteException;

}
