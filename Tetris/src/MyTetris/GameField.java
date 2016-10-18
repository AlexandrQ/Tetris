package MyTetris;

import java.util.ArrayList;


public class GameField {


    public static ArrayList<Integer> gameFieldX = new ArrayList<Integer>();
    public static ArrayList<Integer> gameFieldY = new ArrayList<Integer>();

    private static int count = 0;
    private ArrayList<Integer> buff = new ArrayList<Integer>();

    GameField() {}


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
            }
            else count = 0;
        }
    }
}
