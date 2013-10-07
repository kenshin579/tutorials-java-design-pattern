package youngjin.builder;

/**
 * 문서를 구성하기 위한 메서드를 결정하는 추상 클래스
 */
public abstract class Builder {
    public abstract void makeTitle(String title);

    public abstract void makeString(String str);

    public abstract void makeItems(String[] items);

    public abstract void close();
}
