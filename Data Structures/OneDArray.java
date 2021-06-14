import java.util.Scanner;

public class OneDArray {
    public static void main(String[] args){
        final int SIZE = 5; //same as #define in CPP
        int[] num = new int[SIZE];
        int option;
        do{
            System.out.println("Please select an option..");
            System.out.println("1. Add elements to the Array");
            System.out.println("2. View the Array");
            System.out.println("3. Exit");
            Scanner sc = new Scanner(System.in); //System.in is a standard input stream
            System.out.print("Please enter your option: ");
            option = sc.nextInt();
            switch(option){
                case 1:
                    addElements(num);
                    break;
                case 2:
                    viewArray(num);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Option. Please Try Again");
            }
        }
        while(option!=3);
    }

    public static void addElements(int array[]){ //this is actually work as pass by reference
        int i=0;
        while (array[i]!=0){
            i++;
            if(i==array.length){
                System.out.println("There is no more space in the array");
                return;
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the integers(seperate using a space): ");
        String str = sc.nextLine();
        String arr[] = str.split(" ");
        for(int x=0;x<arr.length;x++) {
            array[i] = Integer.parseInt(arr[x]);
            i++;
            if (i >= array.length) {
                if(i>array.length){
                    System.out.println("There is no enough space to add all the elements into the array.");
                }
                break;
            }
        }
        System.out.println("\n");
    }

    public static void viewArray(int array[]){
        System.out.println("\n");
        int i=0;
        while (array[i]!=0){
            System.out.print(array[i]+" ");
            i++;
            if(i==array.length){
                break;
            }
        }
        if(i==0){
            System.out.println("Array is Empty\n");
        }
        else{
            System.out.println("\n");
        }
    }
}
