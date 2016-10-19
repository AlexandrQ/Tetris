package MyTetris;

import java.util.ArrayList;

/*
 *Данный класс используется для создания объекта,
 * в который будут записаны координаты фигур,
 * которые не могут больше двигаться вниз.
 * Так же в данном классе реализован метод, который
 * удаляет заполненные строчки игрового поля
 *
 */

public class GameField {

    public static ArrayList<Integer> gameFieldX = new ArrayList<Integer>(); //массив Х-координат "недвижымих" объектов
    public static ArrayList<Integer> gameFieldY = new ArrayList<Integer>(); //массив Y-координат "недвижымих" объектов

    private static int count = 0;                                           //счетчик элементов в одной "линии"
    private static int score = 0;                                           //игровой счет

    //конструктор
    GameField() {}

    public static int getScore(){return score;}

    public static void setScore(int z) { score = z; }

    //проверяем GameField на наличие "полных" строк
    public static void findFullLine(){
        int p;
        for (int i = 0; i < 20; i++){                           //берем координату по y
            for (int k = 0; k < gameFieldY.size(); k++){        //и каждый элемент в gameFieldY сравниваем с координатой
                if (gameFieldY.get(k) == i) count++;
            }
            if (count >= 10) {                                  //если 10 совпадений
                for (int j = 0; j < gameFieldY.size(); j++){
                    if (gameFieldY.get(j) == i){
                        gameFieldX.remove(j);                   //удаляем все элементы с данной координатой
                        gameFieldY.remove(j);
                        j = 0;
                    }
                }
                //элементы, которые находятся выше удаленной строки
                //смещаем на одну клетку вниз
                for (int j = 0; j<gameFieldY.size(); j++){
                    for (int z = i-1; z > 0; z--){
                        if (gameFieldY.get(j) == z) {
                            p = gameFieldY.get(j);
                            p++;
                            gameFieldY.set(j, p);
                        }
                    }
                }
                count = 0;
                score += 10;
            }
            else count = 0;
        }
    }

    //очистка игрового поля
    public static void clearGameField() {
        gameFieldX.clear();
        gameFieldY.clear();
    }
}
