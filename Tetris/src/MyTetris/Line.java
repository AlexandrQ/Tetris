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
            case UPRIGHT: case SPECULARUPRIGHT:
                if(canMoveDown){
                    for (int i = 0; i < length; i++){
                        pointX[i] = pointX[1];
                        pointY[i] = pointY[i] +i - 1;
                    }
                }
                break;
            case HORIZONTALY: case SPECULARHORIZONTALY:
                if(canMoveRight & canMoveLeft) {
                    for (int i = 0; i < length; i++) {
                        pointX[i] = pointX[i] + i - 1;
                        pointY[i] = pointY[1];
                    }
                }
                else orientation = Orientation.UPRIGHT;
                break;
        }
    }
}
