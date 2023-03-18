import stanford.karel.SuperKarel;
public class Homework extends SuperKarel {
    private int counter=0;
    public void run() {
        setBeepersInBag(1000);
        int width=getDistance();
        turnLeft();
        int length=getDistance();
        int area=length*width;
        boolean mapNotClean=false;
        turnLeft();
        if(mapNotClean) {
            collectAllBeepers(length);
            DivideIfNotClean(length,width,area);
        }
        else DivideIfClean(length,width,area);
        System.out.println(counter);
    }
    public void DivideIfNotClean(int length,int width,int area){
        if (area<3){ }//case 1 Do nothing
        else if (length==2 && length==width) {
            moveTowall();
            turnAround();
            DrawDiagonal();
        } else if (length==1 && width>2 && !isEven(width)){//case 2.0
            moveN(width/2);
            turnLeft();
            putNbeepers(length);
            turnAround();
            moveTowall();
            turnRight();
            moveTowall();
        } else if(length==2 && width>2 && !isEven(width)){//case 2.1
            moveN(width/2);
            turnRight();
            putNbeepers(length);
            turnAround();
            moveTowall();
            turnRight();
            moveTowall();
        } else if(length>2 && width<=2 && !isEven(length)){//case 2.2
            turnLeft();
            moveN(length/2);
            turnRight();
            putNbeepers(width);
            turnRight();
            moveTowall();
            turnRight();
            moveTowall();
        } else if (length<=2 && width>2 && isEven(width)){//case 3.0
            moveN((width/2)-1);
            turnLeft();
            putNbeepers(length);
            turnRight();
            move();
            counter++;
            turnRight();
            putNbeepers(length);
            turnRight();
            moveTowall();
        } else if (length>2 && width<=2 && isEven(length)){//case 3.1
            turnRight();
            moveN((length/2)-1);
            turnLeft();
            putNbeepers(width);
            turnRight();
            move();
            counter++;
            turnRight();
            putNbeepers(width);
            turnRight();
            moveTowall();
            turnRight();
            moveTowall();
        } else if (isEven(length)&& !isEven(width)){//case 4.0
            moveN(width/2);
            turnRight();
            putNbeepers(length);
            turnLeft();
            moveN(width/2);
            turnLeft();
            moveN((length/2)-1);
            turnLeft();
            putNbeepers(width);
            turnRight();
            move();
            counter++;
            turnRight();
            putNbeepers(width);
            turnLeft();
            moveTowall();
        } else if(isEven(width) && !isEven(length)){//case 4.1
            moveN((width/2)-1);
            turnLeft();
            putNbeepers(length);
            turnRight();
            move();
            counter++;
            turnRight();
            putNbeepers(length);
            turnLeft();
            moveTowall();
            turnLeft();
            moveN(length/2);
            turnLeft();
            putNbeepers(width);
            turnLeft();
            moveTowall();
        } else if (isEven(width) && isEven(length)){//case 5
            moveN((width/2)-1);
            turnRight();
            putNbeepers(length);
            turnLeft();
            move();
            counter++;
            turnLeft();
            putNbeepers(length);
            turnRight();
            moveTowall();
            turnRight();
            moveN((length/2)-1);
            turnRight();
            putNbeepers(width);
            turnLeft();
            move();
            counter++;
            turnLeft();
            putNbeepers(width);
            turnLeft();
            moveTowall();
        } else if ((!isEven(length) && !isEven(width) && length!=width) || area==9 ){//case 6
            moveN(width/2);
            turnLeft();
            putNbeepers(length);
            turnRight();
            moveTowall();
            turnRight();
            moveN(length/2);
            turnRight();
            putNbeepers(width);
            turnLeft();
            moveTowall();
        } else if (!isEven(length)  && length==width){//case 7
            moveN(width/2);
            turnLeft();
            putNbeepers(length);
            turnLeft();
            moveTowall();
            turnLeft();
            moveN(length/2);
            turnLeft();
            putNbeepers(width);
            turnRight();
            moveTowall();
            turnAround();
            DrawDiagonal();
            turnRight();
            moveTowall();
            turnAround();
            DrawDiagonal();
        }
    }
    public void DivideIfClean(int length ,int width ,int area){
        if (area<3){ }//case 1 Do nothing
        else if (length==2 && length==width) DrawDiagonal();
        else if (length<=2 && width>2 && !isEven(width)){//case 2.0
            moveN(width/2);
            turnLeft();
            putNbeepers(length);
            turnRight();
            moveTowall();
        }else if(length>2 && width<=2 && !isEven(length)){//case 2.1
            turnLeft();
            moveN(length/2);
            turnRight();
            putNbeepers(width);
            turnLeft();
            moveTowall();
        }else if (length<=2 && width>2 && isEven(width)){//case 3.0
            moveN((width/2)-1);
            turnLeft();
            putNbeepers(length);
            turnRight();
            move();
            counter++;
            turnRight();
            putNbeepers(length);
            turnLeft();
            moveTowall();
            turnLeft();
            moveTowall();
        }else if (length>2 && width<=2 && isEven(length)){//case 3.1
            turnLeft();
            moveN((length/2)-1);
            turnRight();
            putNbeepers(width);
            turnLeft();
            move();
            counter++;
            turnLeft();
            putNbeepers(width);
            turnRight();
            moveTowall();
            turnRight();
            moveTowall();
        }else if (isEven(length)&& !isEven(width)){//case 4.0
            moveN(width/2);
            turnLeft();
            putNbeepers(length);
            turnRight();
            moveN(width/2);
            turnRight();
            moveN((length/2));
            turnRight();
            putNbeepers(width);
            turnRight();
            move();
            counter++;
            turnRight();
            putNbeepers(width);
            turnLeft();
            moveTowall();
        }else if(isEven(width) && !isEven(length)){//case 4.1
            moveN((width/2));
            turnLeft();
            putNbeepers(length);
            turnLeft();
            move();
            counter++;
            turnLeft();
            putNbeepers(length);
            turnRight();
            moveTowall();
            turnRight();
            moveN(length/2);
            turnRight();
            putNbeepers(width);
            turnLeft();
            moveTowall();
        }else if (isEven(width) && isEven(length)){//case 5
            moveN((width/2)-1);
            turnLeft();
            putNbeepers(length);
            turnRight();
            move();
            counter++;
            turnRight();
            putNbeepers(length);
            turnLeft();
            moveTowall();
            turnLeft();
            moveN((length/2)-1);
            turnLeft();
            putNbeepers(width);
            turnRight();
            move();
            counter++;
            turnRight();
            putNbeepers(width);
            turnLeft();
            moveTowall();
        }else if ((!isEven(length) && !isEven(width) && length!=width) || area==9 ){//case 6
            moveN(width/2);
            turnLeft();
            putNbeepers(length);
            turnLeft();
            moveTowall();
            turnLeft();
            moveN(length/2);
            turnLeft();
            putNbeepers(width);
            turnLeft();
            moveTowall();
        }else if (!isEven(length)  && length==width){//case 7
            moveN(width/2);
            turnLeft();
            putNbeepers(length);
            turnLeft();
            moveTowall();
            turnLeft();
            moveN(length/2);
            turnLeft();
            putNbeepers(width);
            turnRight();
            moveTowall();
            turnAround();
            DrawDiagonal();
            turnLeft();
            turnLeft();
            moveTowall();
            turnLeft();
            DrawDiagonal();
        }
    }
    private void  DrawDiagonal(){
        while(frontIsClear()){
            if(noBeepersPresent())
                putBeeper();
            turnLeft();
            move();
            counter++;
            turnRight();
            move();
            counter++;
        }
        if(noBeepersPresent()) putBeeper();
    }
    private boolean isEven(int i){return i%2==0;}
    private void collectAllBeepers(int l){
        int count=1;
        int templ=l;
        while(l>0){
            collectOneLineOfBeepers();
            if(isEven(count)){
                turnRight();
                if(frontIsClear()){
                    move();
                    turnRight();
                }
            } else{
                turnLeft();
                if(frontIsClear()){
                    move();
                    turnLeft();
                }
            }
            count++;
            l--;
        }
        if(!isEven(templ))
            turnLeft();
        else{
            turnRight();
        }
    }
    private void collectOneLineOfBeepers(){
        while(frontIsClear()){
            if (beepersPresent())
                pickBeeper();
            move();
        }
        if(beepersPresent())
            pickBeeper();
    }
    private void putNbeepers(int n){
        while(n>0 && frontIsClear()){
            if(noBeepersPresent()) {
                putBeeper();
                move();
                counter++;
            }else{
                move();
                counter++;
            }
            n--;
        }
        if(noBeepersPresent()) putBeeper();
    }
    private void moveN(int n){
        while(n>0){
            if(frontIsClear()){
                move();
                counter++;
            }
            n--;
        }
    }
    private void moveTowall(){
        while(frontIsClear()) {
            move();
            counter++;
        }
    }
    public int getDistance(){
        int distance=0;
        while(frontIsClear()){
            distance++;
            move();
            counter++;
        }
        distance+=1;
        return distance;
    }
}