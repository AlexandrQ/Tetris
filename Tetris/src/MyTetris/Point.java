package MyTetris;

public class Point {

    protected Direction direct = Direction.DOWN;   //Направление движения
    protected Orientation orientation = Orientation.UPRIGHT; //ориентация фигуры
    protected boolean canMoveDown, canMoveLeft, canMoveRight;
    protected int length;

    //массивы для записи координат фигуры
    protected int pointX[] = new int[5];
    protected int pointY[] = new int[5];

    //Коструктор
    public Point() {
        length = 1;
        pointX[0] = 4;
        pointY[0] = 0;
        pointX[1] = 5;
        pointY[1] = 1;
    }

    public int getLength() {
        return length;
    }

    public Direction getDirection() {
        return direct;
    }

    public void setDirection(Direction d) {
        direct = d;
    }

    public Orientation getOrientation(){
        return orientation;
    }

    public void setOrientation(Orientation orient){
        orientation = orient;
    }

    public int getPointX(int i){
        return pointX[i];
    }

    public int getPointY(int i){
        return pointY[i];
    }

    //двигаем фигуру
    public void move() {
        canIMove();
        if (canMoveDown == true) {
            switchOrientation();
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
                        pointY[d]++;
                    }
                    direct = Direction.DOWN;
                    break;
            }
        }
    }

    //разворачиваем фигуру
    public  void switchOrientation() {}

    //проверяем можно ли двигаться дальше
    public void canIMove(){
        for (int d = 0; d < length; d++) {
            if (pointY[d]+1 <= 19)
                canMoveDown = true;
            else {
                canMoveDown = false;
                Main.canCreate = true;
                Main.index++;
                break;
            }

            if (pointX[d]-1 >= 0 )
                canMoveLeft = true;
            else{
                canMoveLeft = false;
                break;
            }

            if (pointX[d]+1 <= 9)
                canMoveRight = true;
            else{
                canMoveRight = false;
                break;
            }
        }
    }
}
