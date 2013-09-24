package youngjin.composite;

/**
 * File과 Directory를 동일시하는 추상 클래스
 */
public abstract class Entry {
    public abstract String getName();

    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    /**
     * 왜 굳이 printList를 또 만들었는지 잘 모르겠음?
     * - prefix가 add될 수 있도록 하기 위해서 (ex. /root/Kim/daily.html)
     */
    public void printList() {
        printList("");
    }

    /**
     * protected로 선언하여 Entry의 하위 클래스에서만 사용하도록 함
     */
    protected abstract void printList(String prefix);

    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
