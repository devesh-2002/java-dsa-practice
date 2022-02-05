package com.StackQueue;

public class DynamicStack extends CustomStack{
    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);//it will call CustomStack(int size);
    }

    @Override //Override the push method because you don't want to use the one in parent class
    public boolean push(int item) {
        if(this.isFull()){
            //If the array is full double the array size, so that it will never be full
            int[] temp = new int[data.length*2];
            for (int i = 0; i < data.length; i++) { //Copy all previous data in new data
                temp[i] = data[i];
                //temp goes out of scope
            }
            data = temp;

        }
        //Since the array is not full now, we can insert item
        return super.push(item);

    }
}
//Mostly constant time