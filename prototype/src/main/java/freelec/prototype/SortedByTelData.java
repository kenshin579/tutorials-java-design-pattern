package freelec.prototype;

import java.util.Arrays;
import java.util.Vector;

public class SortedByTelData extends SortedByAgeData {

    // 복사되어 참조될 Data 객체
    private Data data;

    // 객체를 복사하여 생성한다.
    public SortedByTelData(Data data) {
        // 복사되는 객체
        this.data = (Data) data.myClone();
    }

    // 전화 번호 순으로 정렬
    public void sort() {

        Vector _addresses = new Vector();
        String tels[] = new String[data.getSize()];

        for (int i = 0; i < data.getSize(); i++) {
            Address add = data.getAddress(i);
            tels[i] = add.getTel();
        }

        // 전화 번호를 기준으로 tel을 정렬하여
        Arrays.sort(tels);

        // 이를 기준으로 주소록을 재 정렬한다.
        for (int i = 0; i < tels.length; i++) {
            String tel = tels[i];
            for (int j = 0; j < tels.length; j++) {
                Address add = data.getAddress(j);
                String _tel = add.getTel();
                if (tel.equals(_tel)) {
                    _addresses.add(i, add);
                }
            }
        }

        addresses = _addresses;

    }

}
