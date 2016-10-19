package MyTetris;

public class Line extends Point{

    Line(){
        length = 3;
        for (int i = 0; i < length; i++){
            pointX[i] = 4;
            pointY[i] = i;
        }
    }

    @Override
    public  void switchOrientation(){       //подумать над реализацией
        switch (orientation){
            case UPRIGHT:
                if(canMoveDown){
                    for (int i = 0; i < length; i++){
                        pointX[i] = pointX[1];
                        pointY[i] = pointY[i] +i - 1;
                    }
                }

                break;
            case HORIZONTALY:
                if(canMoveRight & canMoveLeft) {
                    for (int i = 0; i < length; i++) {
                        pointX[i] = pointX[i] + i - 1;
                        pointY[i] = pointY[1];
                    }

                }
                else orientation = Orientation.UPRIGHT;
//                else if (canMoveLeft){
//                    for (int i = 0; i < length; i++){
//                        pointX[i] = pointX[0]-i;
//                        pointY[i] = pointY[0];
//                    }
//                }

                break;
        }
    }

}
