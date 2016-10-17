package MyTetris;

public class Point {

    public Direction direct = Direction.DOWN;
    public Orientation orientation1 = Orientation.UPRIGHT;
    public Orientation orientation2 = Orientation.UPRIGHT;
    public int length = 1;

    public int pointX[] = new int[5];
    public int pointY[] = new int[5];

    public Point() {
        pointX[0] = 4;
        pointY[0] = 0;
        pointX[1] = 5;
        pointY[1] = 1;
    }

    public void move() {
        switchOrientation();
        switch (direct) {
            case RIGHT:
                for (int d = length; d >= 0; d--) {
                    pointX[d]++;
                }
                direct = Direction.DOWN;
                break;
            case LEFT:
                for (int d = length; d >= 0; d--) {
                    pointX[d]--;
                }
                direct = Direction.DOWN;
                break;
            default:
                for (int d = length; d >= 0; d--) {
                    pointY[d]++;
                }
                direct = Direction.DOWN;
                break;
        }
    }

    //разворот фигуры
    public  void switchOrientation() {}
}
