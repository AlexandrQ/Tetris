package MyTetris;


public class TFigure extends Point  {

    TFigure(){
        length = 4;
        for (int d = 0; d < length; d++ ){
            if (d < 3) {
                pointX[d] = 4;
                pointY[d] = d;
            }
            else {
                pointX[d] = 5;
                pointY[d] = d - 2;
            }
        }
    }

    @Override
    public  void switchOrientation() {
        switch (orientation){
            case UPRIGHT:
                if (canMoveDown) {
                    for (int d = 0; d < length; d++ ){
                        if (d < 3){
                            pointX[d] = pointX[3];
                            pointY[d] = pointY[3]+d;
                        }
                        else {
                            pointX[d] = pointX[1]+1;
                            pointY[d] = pointY[1];
                        }
                    }
                }
                else orientation = Orientation.SPECULARHORIZONTALY;
                break;
            case HORIZONTALY:
                if (canMoveLeft) {
                    for (int d = 0; d < length; d++ ){
                        if (d < 3) {
                            pointX[d] = pointX[3] - d ;
                            pointY[d] = pointY[3];
                        }
                        else {
                            pointX[d] = pointX[1];
                            pointY[d] = pointY[1]+1;
                        }
                    }
                }
                else orientation = Orientation.UPRIGHT;
                break;
            case SPECULARUPRIGHT:
                for (int d = 0; d < length; d++ ){
                    if (d < 3){
                        pointX[d] = pointX[3];
                        pointY[d] = pointY[3]+d-2;
                    }
                    else {
                        pointX[d] = pointX[1]-1;
                        pointY[d] = pointY[1];
                    }
                }
                break;
            case SPECULARHORIZONTALY:
                if (canMoveRight) {
                    for (int d = 0; d < length; d++ ){
                        if (d < 3) {
                            pointX[d] = pointX[3]-d+2;
                            pointY[d] = pointY[3];
                        }
                        else {
                            pointX[d] = pointX[1];
                            pointY[d] = pointY[1]-1;
                        }
                    }
                }
                else orientation = Orientation.SPECULARUPRIGHT;
                break;
        }
    }
}
