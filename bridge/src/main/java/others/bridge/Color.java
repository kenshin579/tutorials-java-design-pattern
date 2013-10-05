package others.bridge;

/**
 * Implementor:구현의 클래스의 인터페이스를 정의한다.
 * - abstraction 인터페이스와 정확하게 일치할 필요는 없다.
 * - 일반적으로 implementor 인터페이스에서는 primitive 한 operation을 정의를 하고
 * abstraction에서 보다 higher-level한 operation을 primitive operation을 기반으로
 * 정의를 한다.
 */
public interface Color {
    public void applyColor();
}