package MyTetris;
/*
 * класс описывает инициализацию фигуры - квадрат
 *
 */

public class Square extends Point {
    //конструктор
    Square() {
        length = 4;
        pointX[0] = 4;  pointY[0] = 0;
        pointX[1] = 5;  pointY[1] = 0;
        pointX[2] = 5;  pointY[2] = 1;
        pointX[3] = 4;  pointY[3] = 1;

    }
}
