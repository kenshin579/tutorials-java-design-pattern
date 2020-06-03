package gmlwjd9405.decorator;

/**
 * https://gmlwjd9405.github.io/2018/07/09/decorator-pattern.html
 */
public class Client {
	public static void main(String[] args) {
		Display road = new RoadDisplay();

		road.draw(); // 기본 도로 표시

		Display roadWithLane = new LaneDecorator(new RoadDisplay());
		roadWithLane.draw(); // 기본 도로 표시 + 차선 표시

		Display roadWithTraffic = new TrafficDecorator(new RoadDisplay());
		roadWithTraffic.draw(); // 기본 도로 표시 + 교통량 표시
	}
}
