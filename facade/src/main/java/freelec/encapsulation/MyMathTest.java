package freelec.encapsulation;

class MyMathTest {
    public static void main(String[] args) {
        MyMath m = new MyMath();
        m.setA(1);
        m.setB(-4);
        m.setC(3);
        double x[] = new double[2];
        m.setX(x);

        x[0] = (-m.getB() + Math.sqrt(Math.abs(m.getB() * m.getB() - 4 * m.getA() * m.getC()))) / (2 * m.getA());
        x[1] = (-m.getB() - Math.sqrt(Math.abs(m.getB() * m.getB() - 4 * m.getA() * m.getC()))) / (2 * m.getA());

        for (int i = 0; i < x.length; i++) {
            System.out.println("x[" + i + "] ? " + x[i]);
        }

    }
}
  