package Lab2;

public class Stack {

    int top=4;
    int[] stackArray = new int[top];
    int sp = 0;

    public void push (int value){
        if(sp < top) {
            stackArray[sp] = value;
            sp++;
        }
        else {
            int[] dynamicArray = new int[top*2];
            System.arraycopy(stackArray,0,dynamicArray,0,sp);
            stackArray = dynamicArray;
            top = (top*2);
            stackArray[sp] = value;
            sp++;

        }

    }
    public int pop (){
        if(sp < top) {
            stackArray[sp] = 0;
            sp--;
            return stackArray[sp];
        }
        else {
            int[] dynamicArray = new int[top*2];
            System.arraycopy(stackArray,0,dynamicArray,0,sp);
            stackArray = dynamicArray;
            top = (top*2);
            stackArray[sp] = 0;
            sp--;
            return stackArray[sp];
        }
    }

    public void printStack(){
        for (int n : stackArray){
            System.out.println((n)+" ");
        }
    }

}