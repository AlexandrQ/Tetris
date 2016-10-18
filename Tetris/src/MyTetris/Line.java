package MyTetris;

public class Line extends Point{

    Line(){
        length = 4;
        for (int i = 0; i < length; i++){
            pointX[i] = length;
            pointY[i] = i;
        }
    }

    @Override
    public  void switchOrientation(){       //подумать над реализацией
        switch (orientation){
            case UPRIGHT:
                if(canMoveDown){
                    for (int i = 0; i < length; i++){
                        pointX[i] = pointX[0];
                        pointY[i] = pointY[0] + i;
                    }
                }

                break;
            case HORIZONTALY:
                if(pointX[0] < 7)
                    for (int i = 0; i < length; i++){
                        pointX[i] = pointX[0]+i;
                        pointY[i] = pointY[0];
                    }
                else{
                    for (int i = 0; i < length; i++){
                        pointX[i] = pointX[0]-i;
                        pointY[i] = pointY[0];
                    }
                }

                break;
        }
    }

}
