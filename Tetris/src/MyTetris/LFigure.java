package MyTetris;


public class LFigure extends Point {
    LFigure() {
        length = 4;
        for (int d = 0; d < length; d++) {
            if (d < 3) {
                pointX[d] = 4;
                pointY[d] = d;
            } else {
                pointX[d] = 5;
                pointY[d] = 2;
            }
        }
    }

    @Override
    public void switchOrientation() {
        switch (orientation) {
            case UPRIGHT:
                for (int d = 0; d < length; d++) {
                    if (d < 3) {
                        pointX[d] = pointX[3] - 1;
                        pointY[d] = pointY[3] + d - 1;
                    } else {
                        pointX[d] = pointX[2] + 1;
                        pointY[d] = pointY[2];
                    }
                }
                break;
            case HORIZONTALY:
                if (canMoveLeft) {
                    for (int d = 0; d < length; d++) {
                        if (d < 3) {
                            pointX[d] = pointX[3] - d;
                            pointY[d] = pointY[3] - 1;
                        } else {
                            pointX[d] = pointX[2];
                            pointY[d] = pointY[2] + 1;
                        }
                    }
                } else orientation = Orientation.UPRIGHT;
                break;
            case SPECULARUPRIGHT:
                if (canMoveDown) {
                    for (int d = 0; d < length; d++) {
                        if (d < 3) {
                            pointX[d] = pointX[3] + 1;
                            pointY[d] = pointY[3] - d;
                        } else {
                            pointX[d] = pointX[2] - 1;
                            pointY[d] = pointY[3] - 2;
                        }
                    }
                } else orientation = Orientation.HORIZONTALY;
                break;
            case SPECULARHORIZONTALY:
                if (canMoveRight) {
                    for (int d = 0; d < length; d++) {
                        if (d < 3) {
                            pointX[d] = pointX[3] + d;
                            pointY[d] = pointY[3] + 2;
                        } else {
                            pointX[d] = pointX[2];
                            pointY[d] = pointY[2] - 1;
                        }
                    }
                } else orientation = Orientation.SPECULARUPRIGHT;
                break;
        }
    }
}
