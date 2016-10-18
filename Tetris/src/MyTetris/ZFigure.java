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
            case UPRIGHT:
                for (int d = 0; d < length; d++) {
                    if (pointX[3] == 0) {
                        if (d == 1) {
                            pointX[d] = pointX[0];
                            pointY[d] = pointY[0] + 1;
                        } else if (d >= 2 & d < length) {
                            pointX[d] = pointX[0] - 1;
                            pointY[d] = pointY[0] + d - 1;
                        }
                    }
                    else {
                        if (d == 0) {
                            pointX[d] = pointX[d+1];
                            pointY[d] = pointY[d+1];
                        }
                        else if (d == 1) {
                            pointX[d] = pointX[0];
                            pointY[d] = pointY[0] + 1;
                        }
                        else if (d >= 2 & d < length) {
                            pointX[d] = pointX[0] - 1;
                            pointY[d] = pointY[0] + d - 1;
                        }
                    }
                }
                break;
            case HORIZONTALY:
                if (pointX[0] < 8) {
                    for (int d = 0; d < length; d++) {
                        if (d == 1) {
                            pointX[d] = pointX[0] + 1;
                            pointY[d] = pointY[0];
                        } else if (d >= 2 & d < length) {
                            pointX[d] = pointX[0] + d - 1;
                            pointY[d] = pointY[0] + 1;
                        }
                    }
                }
                else {
                    for (int d = 0; d < length; d++) {
                        if (d == 0) {
                            pointX[d] -=2;
                        }
                        if (d == 1) {
                            pointX[d] = pointX[0] + 1;
                            pointY[d] = pointY[0];
                        } else if (d >= 2 & d < length) {
                            pointX[d] = pointX[0] + d - 1;
                            pointY[d] = pointY[0] + 1;
                        }
                    }
                }
                    break;

        }
    }
}
