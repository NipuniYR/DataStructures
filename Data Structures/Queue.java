public class Queue {
    private int queue[];
    private int front;
    private int back;
    private int queueSize;

    //Constructor
    Queue(int size){
        queue = new int[size];
        front = -1;
        back = -1;
        queueSize = size;
    }

    public void enqueue(int val){
        if(back==queueSize-1){
            System.out.println("The Queue is full");
        }else if(back == -1 && front == -1){
            queue[++back] = val;
            ++front;
        }else{
            queue[++back] = val;
        }
    }

    public int dequeue(){
        int val = 0;
        if(front == -1 || front>back){
            System.out.println("The Queue is empty");
        }else{
            val = queue[front];
            front++;
            if(front>back){
                front = back = -1;
            }
        }
        return val;
    }

    //display
    public void displayQueue(){
        System.out.println();
        if(front == -1 || front>back){
            System.out.println("The Queue is empty");
        }else{
            for(int i=front; i<=back; i++){
                System.out.print(queue[i] + "\t");
            }
        }
        System.out.println();
    }

    public static void main(String args[]){
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.displayQueue();
        q.dequeue();
        q.displayQueue();
        q.dequeue();
        q.displayQueue();
        q.dequeue();
        q.displayQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.displayQueue();
    }
}
