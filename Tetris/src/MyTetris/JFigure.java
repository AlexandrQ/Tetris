package MyTetris;
/*
 * класс описывает инициализацию
 * и поведение J-образной фигуры
 *
 */

public class JFigure extends Point {
    //конструктор
    JFigure(){
        length = 4;
        for (int d = 0; d < length; d++) {
            if (d < 3) {
                pointX[d] = 4;
                pointY[d] = d;
            } else {
                pointX[d] = 3;
                pointY[d] = 2;
            }
        }
    }
    //изменение координат фигуры
    //в соответствии с заданной ориентацией
    @Override
    public void switchOrientation() {
        switch (orientation) {
            case UPRIGHT:
                if(canMoveDown) {
                    for (int d = 0; d < length; d++) {
                        if (d < 3) {
                            pointX[d] = pointX[3] - 1;
                            pointY[d] = pointY[3] + d - 2;
                        } else {
                            pointX[d] = pointX[2] - 1;
                            pointY[d] = pointY[2];
                        }
                    }
                } else orientation = Orientation.SPECULARHORIZONTALY;
                break;
            case HORIZONTALY:
                if (canMoveRight) {
                    for (int d = 0; d < length; d++) {
                        if (d < 3) {
                            pointX[d] = pointX[3] - d + 2;
                            pointY[d] = pointY[3];
                        } else {
                            pointX[d] = pointX[2];
                            pointY[d] = pointY[2] - 1;
                        }
                    }
                } else orientation = Orientation.UPRIGHT;
                break;
            case SPECULARUPRIGHT:
                    for (int d = 0; d < length; d++) {
                        if (d < 3) {
                            pointX[d] = pointX[3] + 1;
                            pointY[d] = pointY[3] - d;
                        } else {
                            pointX[d] = pointX[2] + 1;
                            pointY[d] = pointY[2];
                        }
                    }
                break;
            case SPECULARHORIZONTALY:
                if (canMoveLeft) {
                    for (int d = 0; d < length; d++) {
                        if (d < 3) {
                            pointX[d] = pointX[3] + d - 2;
                            pointY[d] = pointY[3] + 1;
                        } else {
                            pointX[d] = pointX[2];
                            pointY[d] = pointY[2] + 1;
                        }
                    }
                } else orientation = Orientation.SPECULARUPRIGHT;
                break;
        }
    }

}
