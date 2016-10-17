package MyTetris;


public class ZFigure extends Point {
    public ZFigure (){
        length = 4;
        for (int d = 0; d < length; d++) {
            if (d < 2) {
                pointX[d] = 4;
                pointY[d] = d;
            }
            else {
                pointX[d] = 5;
                pointY[d] = d-1;
            }
        }
    }
}
