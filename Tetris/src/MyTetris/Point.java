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

    //разворот z-образной фигуры
    public  void switchOrientation() {
        if (orientation2 != orientation1){
            switch (orientation2){
                case UPRIGHT:
                    for (int d = 0; d < length; d++) {

                        if (d == 1) {
                            pointX[d] = pointX[0];
                            pointY[d] = pointY[0]+1;
                        }
                        else if (d >= 2 & d < length){
                            pointX[d] = pointX[0]-1;
                            pointY[d] = pointY[0]+d-1;
                        }
                    }
                    orientation1 = orientation2;
                    break;
                case HORIZONTALY:
                    for (int d = 0; d < length; d++) {

                        if (d == 1) {
                            pointX[d] = pointX[0]+1;
                            pointY[d] = pointY[0];
                        }
                        else if (d >= 2 & d < length){
                            pointX[d] = pointX[0]+d-1;
                            pointY[d] = pointY[0]+1;
                        }
                    }
                    orientation1 = orientation2;
                    break;
            }
        }
    }
}
