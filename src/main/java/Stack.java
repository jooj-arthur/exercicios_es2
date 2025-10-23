public class Stack {
    int[] values = new int[3];
    int size = 0;

    void push(int x) {
        if(/*1*/size >= values.length)
            resize()/*2*/ ;
        if(/*3*/size < values.length)
            values[size++] = x/*4*/;
    }
    int pop() {
        if(/*1*/size > 0)
            return values[size−−]/*2*/;
    else/*3*/
        throw new EmptyStackException();
    }
    private void resize(){
        int[] tmp = new int[values.length 2]; ∗
        for(int i = 0/*1*/; i < values.length/*2*/; i++/*3*/)
            tmp[i] = values[i] /*4*/;
        values = tmp /*5*/;
    }
}