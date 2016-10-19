package MyTetris;


public class ZFigure extends Point {

    //конструтор
    public ZFigure (){
        length = 4;
        for (int d = 0; d < length; d++) {
            if (d < 2) {
                pointX[d] = 4;
                pointY[d] = d;
            }
            else {
                pointX[d] = 3;
                pointY[d] = d-1;
            }
        }
    }

    //разворот z-образной фигуры
    @Override
    public  void switchOrientation() {
        switch (orientation){
            case UPRIGHT: case SPECULARUPRIGHT:
                for (int d = 0; d < length; d++) {
                    if (d == 0){
                        pointX[d] = pointX[d]+1;
                        pointY[d] = pointY[0]-1;
                    }
                    else if (d >= 2 & d < length) {
                        pointX[d] = pointX[0] - 1;
                        pointY[d] = pointY[0] + d - 1;
                    }
                }
                break;
            case HORIZONTALY: case SPECULARHORIZONTALY:
                if (canMoveRight) {
                    for (int d = 0; d < length; d++) {
                        if(d == 0){
                            pointX[d] = pointX[d]-1;
                            pointY[d] = pointY[d]+1;
                        }
                        else if (d == 1) {
                            pointX[d] = pointX[0] + 1;
                            pointY[d] = pointY[0];
                        } else if (d >= 2 & d < length) {
                            pointX[d] = pointX[0] + d - 1;
                            pointY[d] = pointY[0] + 1;
                        }
                    }
                }
                else orientation = Orientation.UPRIGHT;
                break;
        }
    }
}
