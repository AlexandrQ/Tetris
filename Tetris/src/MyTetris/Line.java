package MyTetris;

/*
 * класс описывает инициализацию
 * и поведение фигуры - линия
 *
 */

public class Line extends Point{

    //конструктор
    Line(){
        length = 3;
        for (int i = 0; i < length; i++){
            pointX[i] = 4;
            pointY[i] = i;
        }
    }
    //изменение координат фигуры
    //в соответствии с заданной ориентацией
    @Override
    public  void switchOrientation(){
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
