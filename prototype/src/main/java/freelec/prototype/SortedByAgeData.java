package freelec.prototype;

import java.util.Arrays;
import java.util.Vector;

// 주소록을 나이 순으로 정렬하기 위한 클래스
public class SortedByAgeData extends Data {

    // 복사되어 참조될 Data 객체
    private Data data;

    // 생성된 객체가 원본인지 아니면 복사본이지 구별하기 위한 신호 값
    boolean flag = false;

    // 주소록 객체를 저장하기 위한 Vector
    protected Vector addresses;

    // 하위 클래스를 위한 Default 생성자
    public SortedByAgeData() {
    }

    // DB에서 가져온 데이터를 addresses에 저장함
    public SortedByAgeData(Address _addresses[]) {
        addresses = new Vector();
        for (int i = 0; i < _addresses.length; i++) {
            addresses.addElement(_addresses[i]);
        }
    }

    // 원본을 이용하여 객체를 생성한다
    public SortedByAgeData(Data data) {
        // 복사되는 객체
        this.data = (Data) data.myClone();
        flag = true;
    }

    // 나이 순으로 주소록을 정렬
    public void sort() {
        Vector _addresses = new Vector();
        int size = 0;

        if (flag) {
            size = data.getSize();
        } else {
            size = addresses.size();
        }

        String ssns[] = new String[size];

        for (int i = 0; i < size; i++) {
            Address add = getAddress(i);
            String ssn = add.getSsn();
            ssns[i] = ssn;
        }

        // 나이 순으로 ssn을 정렬하여
        Arrays.sort(ssns);

        // 정렬된 ssn을 기준으로 주소록을 정렬을 시킴
        for (int i = 0; i < size; i++) {
            String ssn = ssns[i];

            for (int j = 0; j < size; j++) {
                Address add = getAddress(j);
                String _ssn = add.getSsn();

                if (ssn.equals(_ssn)) {
                    _addresses.add(i, add);
                }
            }
        }

        addresses = _addresses;
        flag = false;
    }

    public int getSize() {
        int size = 0;

        if (flag) {
            size = data.getSize();
        } else {
            size = addresses.size();
        }

        return size;
    }

    public Address getAddress(int index) {
        Address add = null;

        if (flag) {
            add = data.getAddress(index);
        } else {
            add = (Address) addresses.elementAt(index);
        }

        return add;
    }

    public String getName(int index) {
        Address add = null;

        if (flag) {
            add = data.getAddress(index);
        } else {
            add = (Address) addresses.elementAt(index);
        }

        String name = add.getName();

        return name;
    }
}
