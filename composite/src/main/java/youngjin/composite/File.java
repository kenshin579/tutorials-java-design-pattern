package youngjin.composite;

public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    /**
     * 아래 모두 동일한 코드입니다.
     * 1.prefix + "/" + this (문자열과 object를 더하면 자동적으로 그 object의 toString 메서드를 호출하게 됨)
     * 2.prefix + "/" + this.toString()
     * 3.prefix + "/" + toString()
     *
     * @param prefix
     */
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}
