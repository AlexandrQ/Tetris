package MyTetris;
/*
* Это родительский класс для классов, которые описывают фигуры в игре
* В данном классе описан метод, который реализует движение фигур,
* а так же методы для определения столкновения фигуры с границами игрового поля
* и с "недвижимыми" объектами (класс GameField
*
 */

public class Point {

    protected Direction direct = Direction.DOWN;   //Направление движения
    protected Orientation orientation = Orientation.UPRIGHT; //ориентация фигуры
    protected Orientation orientation2 = Orientation.UPRIGHT;
    protected boolean canMoveDown = true,
            canMoveLeft,
            canMoveRight,
            crashDownField,
            crashRightField,
            crashLeftField;
    protected int length;

    //массивы для записи координат фигуры
    protected int pointX[] = new int[5];
    protected int pointY[] = new int[5];

    //Коструктор
    public Point() {}

    public int getLength() {
        return length;
    }

    public void setDirection(Direction d) {
        direct = d;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orient) {
        orientation = orient;
    }

    public int getPointX(int i) {
        return pointX[i];
    }

    public int getPointY(int i) {
        return pointY[i];
    }

    public  boolean getCanMoveDown(){return canMoveDown; };

    //двигаем фигуру
    public void move() {
        canMoveDown = canMoveLeft = canMoveRight = true;
        //проверяем можно ли двигаться дальше
        canIMove();
        //если игрок сменил ориентацию фигуры,
        //то поварачиваем объект
        if (orientation2 != orientation){
            switchOrientation();
            orientation2 = orientation;
            //проверяем может ли фигура двигаться дальше из нового положения
            canIMove();
        }

        //меняем координаты фигуры согласно направлению
        switch (direct) {
            case RIGHT:
                for (int d = length; d >= 0; d--) {
                    if (canMoveRight) pointX[d]++;
                }
                direct = Direction.DOWN;
                break;
            case LEFT:
                for (int d = length; d >= 0; d--) {
                    if (canMoveLeft) pointX[d]--;
                }
                direct = Direction.DOWN;
                break;
            default:
                for (int d = length; d >= 0; d--) {
                    if (canMoveDown) pointY[d]++;
                }
                break;
        }
    }

    //разворачиваем фигуру
    public void switchOrientation() {
    }

    //проверяем можно ли двигаться дальше
    public void canIMove() {
        crashDownField = crashRightField = crashLeftField = true;
        //проверяем, врезается ли наша фигура в "недвижимые" объекты (в класс GameField)
        figureCrashGameField();
        //так же проверяем на столкновения с границей игрового поля
        for (int d = 0; d < length; d++) {
            if (pointY[d] + 1 > 19 || !crashDownField ) {
                canMoveDown = false;                        //когда фигура не может больше снижаться
                for (int i = 0; i < length; i++ ){
                    GameField.gameFieldX.add(pointX[i]);    //она передает свои координаты в GameField
                    GameField.gameFieldY.add(pointY[i]);
                }
                Main.canCreate = true;                      //программа может создать новую фигуру
                break;
            }
            //если при движении влево нет "стены" и GameField
            if (pointX[d] - 1 < 0 || !crashLeftField){
                canMoveLeft = false;
            }
            //если при движении вправо нет "стены" и GameField
            if (pointX[d] + 1 > 9 || !crashRightField){
                canMoveRight = false;
            }
        }
    }

    //проверка на столкновение с GameField
    public void figureCrashGameField(){
        for (int i = 0; i < length; i++){
            for (int k = 0; k < GameField.gameFieldX.size(); k++){
                //проверка на столкновение с GameField при движении вниз
                if ((pointX[i] == GameField.gameFieldX.get(k)) & (pointY[i]+1 == GameField.gameFieldY.get(k))){
                    crashDownField = false;
                }
                //проверка на столкновение с GameField при движении вправо
                if ((pointX[i]+1 == GameField.gameFieldX.get(k)) & (pointY[i] == GameField.gameFieldY.get(k))){
                    crashRightField = false;
                }
                //проверка на столкновение с GameField при движении влево
                if ((pointX[i]-1 == GameField.gameFieldX.get(k)) & (pointY[i] == GameField.gameFieldY.get(k))){
                    crashLeftField = false;
                }
            }
        }
    }
}
