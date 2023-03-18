import stanford.karel.SuperKarel;
public class BlankKarel2 extends SuperKarel {
    private int moveCounter=0;
    private int beeperCounter=0;
    private int width=1;
    private int length=1;
    private int area=0;
    public void run() {
        int arr[] = getDimensions();
        width = arr[0];
        length = arr[1];
        area = width * length;
        if (isEven(width) && isEven(length)) EvenEven();
        else if (!isEven(width) && !isEven(length)) OddOdd();
        else if (!isEven(width) && isEven(length)) OddEven();
        else if (isEven(width) && !isEven(length)) EvenOdd();
        System.out.println("number of moves =" + moveCounter);
        System.out.println("number of beepers =" + beeperCounter);
    }
    private void EvenEven(){
        if(width==2 && length==2){ DrawDiagonal(); }
        else if(width==2 && width!=length){
            turnLeft();
            drawForEven(length,false);
            turnRight();
            moveToWall();
            turnRight();
            moveToWall();
        }else if(length==2 && length!=width){
            drawForEven(width,true);
            turnLeft();
            moveToWall();
            turnLeft();
            moveToWall();
        }else{
            drawForEven(width,true);
            turnLeft();
            moveToWall();
            turnLeft();
            drawForEven(length,true);
            turnLeft();
            moveToWall();
        }
    }
    private void OddOdd(){
        if(width==1 && length==1){}
        else if (width==1 && width!=length){
            turnLeft();
            drawForOdd(length,true);
            turnRight();
            moveToWall();
        }else if (length==1 && length!=width){
            drawForOdd(width,true);
            turnRight();
            moveToWall();
        }else if (area==9 || length!=width){
            drawForOdd(width,true);
            turnLeft();
            moveToWall();
            turnLeft();
            drawForOdd(length,true);
            turnLeft();
            moveToWall();
        }else if(length == width){
            drawForOdd(length,true);
            turnLeft();
            moveToWall();
            turnLeft();
            drawForOdd(length,true);
            turnRight();
            moveToWall();
            turnAround();
            DrawDiagonal();
            turnAround();
            moveToWall();
            turnLeft();
            DrawDiagonal();
        }
    }
    private void EvenOdd(){
        if(area==2){moveToWall();}
        else if(width>3 && length==1){
            drawForEven(width,true);
            turnLeft();
            moveToWall();
        } else if(width==2 && length>=3){
            turnLeft();
            drawForOdd(length,false);
            turnLeft();
            moveToWall();
        }else{
            drawForEven(width,true);
            turnRight();
            moveToWall();
            turnRight();
            drawForOdd(length,false);
            turnLeft();
            moveToWall();
        }
    }
    private void OddEven(){
        if (area==2){
            turnLeft();
            moveToWall();
        }
        else if (width==1 && length>3){
            turnLeft();
            drawForEven(length,true);
            turnLeft();
            moveToWall();
        }else if (width>1 && length==2){
            drawForOdd(width,true);
            turnRight();
            moveToWall();
        }else{
            drawForOdd(width,true);
            turnRight();
            moveToWall();
            turnRight();
            drawForEven(length,false);
            turnLeft();
            moveToWall();
        }
    }
    private void drawForEven(int dimension,boolean left){
        moveN((dimension/2)-1);
        if(left) turnLeft();
        else turnRight();
        moveToWallWithBeepers();
        if (left)turnRight();
        else turnLeft();
        move();
        moveCounter++;
        if (left) turnRight();
        else turnLeft();
        moveToWallWithBeepers();
    }
    private void drawForOdd(int dimension,boolean left){
        moveN(dimension/2);
        if (left) turnLeft();
        else turnRight();
        moveToWallWithBeepers();
    }
    private boolean isEven(int i){ return i%2==0; }
    private void moveN(int n){
        while(n>0){
            if(frontIsClear()) {
                move();
                moveCounter++;
            }
            n--;
        }
    }
    private int [] getDimensions(){
        int []arr=new int[2];
        for(int i=0;i<2;i++){
            int distance=0;
            while(frontIsClear()){
                distance++;
                move();
                moveCounter++;
            }
            arr[i]=distance;
            turnLeft();
        }
        return arr;
    }
    private void moveToWall(){
        while(frontIsClear()){
            move();
            moveCounter++;
        }
    }
    private void moveToWallWithBeepers(){
        while (frontIsClear()){
            if (!beepersPresent()) {
                putBeeper();
                beeperCounter++;
            }
            move();
            moveCounter++;
        }
        if(!beepersPresent()){
            putBeeper();
            beeperCounter++;
        }
    }
    private void DrawDiagonal(){
        while(frontIsClear()){
            if(noBeepersPresent()){
                putBeeper();
                beeperCounter++;
            }
            turnLeft();
            move();
            moveCounter++;
            turnRight();
            move();
            moveCounter++;
        }
        if(noBeepersPresent()) {
            putBeeper();
            beeperCounter++;
        }
    }
}