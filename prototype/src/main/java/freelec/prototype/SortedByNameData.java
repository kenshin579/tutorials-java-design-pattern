package freelec.prototype;

import java.util.Arrays;
import java.util.Vector;

public class SortedByNameData extends SortedByAgeData {

    // 복사되어 참조될 Data 객체
    private Data data;

    // 객체를 복사한다.
    public SortedByNameData(Data data) {
        // 복사되는 객체
        this.data = (Data) data.myClone();
    }

    // 이름을 기준으로 주소록을 정렬
    public void sort() {

        Vector _addresses = new Vector();
        String names[] = new String[data.getSize()];

        for (int i = 0; i < data.getSize(); i++) {
            Address add = data.getAddress(i);
            names[i] = add.getName();
        }

        // 이름을 순으로 name을 정럴하여
        Arrays.sort(names);

        // 이를 기준으로 주소록을 재 정렬한다
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            for (int j = 0; j < names.length; j++) {
                Address add = data.getAddress(j);
                String _name = add.getName();
                if (name.equals(_name)) {
                    _addresses.add(i, add);
                }
            }
        }

        addresses = _addresses;

    }

}

