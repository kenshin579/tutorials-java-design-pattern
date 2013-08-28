package freelec.prototype;

import java.io.*;

// Data 클래스 타입의 객체들이 가져야 할 메소드를 선언한 클래스
// 직렬화를 위해 Serializable을 상속 받음

// 영진책의 소스에서와 달리 여기에서는 Data 객체를 Serializable로 정의하여 객체를 복사할 수 있도록 함
public abstract class Data implements Serializable {

    public abstract void sort();

    public abstract int getSize();

    public abstract Address getAddress(int i);

    public abstract String getName(int i);

    // 객체 자신을 복사하여, 복사본을 반환하는 메소드
    public Object myClone() {

        Object obj = null;

        try {
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bao);
            oos.writeObject(this);
            ByteArrayInputStream bai = new ByteArrayInputStream(bao.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bai);
            obj = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return obj;

    }

}
