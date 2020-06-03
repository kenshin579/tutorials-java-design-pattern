package gmlwjd9405.problem;

public class Client {
	public static void main(String[] args) {
		RoadDisplay road = new RoadDisplay();
		road.draw(); // 기본 도로만 표시

		RoadDisplay roadWithLane = new RoadDisplayWithLane();
		roadWithLane.draw(); // 기본 도로 표시 + 차선 표시

		//추가 객체 - 추가 기능을 add 하려면 점점 늘어나게 됨
		RoadDisplay roadWithTraffic = new RoadDisplayWithTraffic();
		roadWithTraffic.draw(); // 기본 도로 표시 + 차선 표시
	}
}
