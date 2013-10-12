## 연습문제 (책: Java 언어로 배우는 패턴 입문)
------------------
**직렬화(serialization)의 기능을 사용하면 작성한 Memento의 인스턴스를 파일로 저장할 수 있습니다. 다음과 같은 기능을 만족하도록 예제 프로그램을 변경해 주십시오.**

1. 파일 game.dat가 존재하지 않을 때에는 소지금 100원부터 시작한다.
2. 소지금이 많이 증가하면 Memento의 인스턴스를 파일 game.dat로 저장한다.
3. 프로그램 실행시 파일 game.dat가 존재하면 그 파일에 저장되어 있는 상태에서 시작한다.

**직렬화(serialization)의 기능을 실행하기 위한 정보는 다음을 참조해 주십시오.**

1. 저장할 Memento 클래스는 java.io.Serializable 인스턴스를 구현한다.
2. 저장할 경우 ObjectOutputStream 클래스의 writeObject 메서드를 이용한다.
3. 복원할 경우 ObjectInputStream 클래스의 readObject 메서드를 이용한다.
4. 자세한 사항은 Java의 API reference의 다음 함목을 참고한다.

	* java.io.ObjectOutputStream 클래스
	* java.io.ObjectInputStream 클래스
	* java.io.ObjectOutput 인터페이스
	* java.io.ObjectInput 인터페이스