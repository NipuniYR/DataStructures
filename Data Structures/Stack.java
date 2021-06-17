public class Stack {
    private int stack[];
    private int top;
    private int stackSize;

    //Constructor
    Stack(int size){
        stack = new int[size];
        top = -1;
        stackSize = size;
    }

    //push
    public void push(int val){
        if(top == stackSize-1){
            System.out.println("Stack overflow");
        }
        else{
            stack[++top] = val;
        }
    }

    //pop
    public int pop(){
        if(top==-1){
            System.out.println("The stack is empty");
            System.exit(0); //code 0 - successful termination
        }
        return stack[top--];
    }

    //peek
    public void peek(){
        System.out.println("Top element of the stack is "+ stack[top]);
    }

    //display
    public void displayStack(){
        System.out.println();
        if(top==-1){
            System.out.println("The stack is empty");
        } else {
            for(int i=0; i<=top; i++){
                System.out.print(stack[i] + "\t");
            }
        }
        System.out.println();
    }

    public static void main(String args[]){
        Stack s = new Stack(5);
        s.push(1);
        s.push(2);
        s.push(3);
        s.displayStack();
        s.peek();
        s.pop();
        s.displayStack();
    }
}
