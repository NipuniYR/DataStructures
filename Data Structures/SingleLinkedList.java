public class SingleLinkedList {
    private class Node{
        int value;
        Node next;

        //Constructor
        Node(int val){
            value = val;
            next = null;
        }
    }

    Node first;

    //constructor
    SingleLinkedList(){
        first = null;
    }

    //Insert a Node at the end of the list
    public void insertAtTheEnd(int val){
        Node newNode = new Node(val);
        Node pointer = first;
        if(pointer==null){
            //List is currently empty, hence insert the new node as the first node
            first = newNode;
        }else{
            while(pointer.next !=null){
                pointer = pointer.next;
            }
            pointer.next = newNode;
        }
    }

    //Search for a Node
    public Node searchNode(int val){
        Node pointer = first;
        while(pointer.value != val && pointer.next != null){
            pointer = pointer.next;
        }
        if(pointer.value == val){
            return pointer;
        }else{
            System.out.println("Cannot find " + val + " in the List");
            return null;
        }
    }

    //Get the address of the previous node of a given value
    public Node searchPreNode(int val){
        Node prePointer = first;
        Node pointer = first;
        while(pointer.value != val && pointer.next != null){
            prePointer = pointer;
            pointer = pointer.next;
        }
        if(pointer.value == val){
            return prePointer;
        }else{
            System.out.println("Cannot find " + val + " in the List");
            return null;
        }
    }

    //Insert a Node after a given value
    public void insertAfterValue(int val, int afterThis){
        Node newNode = new Node(val);
        Node pointer = searchNode(afterThis);
        if(pointer==null){
            System.out.println("Insertion of " + val + " after " + afterThis + " Failed");
        }else{
            newNode.next = pointer.next;
            pointer.next = newNode;
        }
    }

    //Insert a Node before a given value
    public void insertBeforeValue(int val, int beforeThis){
        Node newNode = new Node(val);
        Node pointer = searchPreNode(beforeThis);
        if(pointer==null){
            System.out.println("Insertion of " + val + " before " + beforeThis + " Failed");
        }else{
            if(pointer==first){
                //first node does not have a pre node
                newNode.next = first;
                first = newNode;
            }else{
                newNode.next = pointer.next;
                pointer.next = newNode;
            }
        }
    }

    //Delete a given Node
    public void deleteNode(int val){
        Node pointer = searchPreNode(val);
        if(pointer==null){
            System.out.println("Deletion of " + val + "  failed");
        }else{
            if(pointer==first){
                //First node does not have a pre node
                first = pointer.next;
            }else{
                pointer.next = pointer.next.next;
            }
        }
    }

    //display
    public void displayLinkedList(){
        System.out.println();
        Node pointer = first;
        if(pointer==null){
            System.out.println("The List is empty");
        }else{
            System.out.print(pointer.value + "\t");
            while(pointer.next!=null){
                pointer = pointer.next;
                System.out.print(pointer.value + "\t");
            }
        }
        System.out.println();
    }

    public static void main(String args[]){
        SingleLinkedList ll = new SingleLinkedList();
        ll.insertAtTheEnd(1);
        ll.insertAtTheEnd(2);
        ll.displayLinkedList();
        ll.insertAfterValue(3,1);
        ll.displayLinkedList();
        ll.insertBeforeValue(4,1);
        ll.displayLinkedList();
        ll.insertAtTheEnd(5);
        ll.insertAtTheEnd(6);
        ll.insertAtTheEnd(7);
        ll.displayLinkedList();
        ll.deleteNode(4);
        ll.displayLinkedList();
        ll.deleteNode(5);
        ll.displayLinkedList();
        ll.deleteNode(7);
        ll.displayLinkedList();
        ll.insertBeforeValue(2,8);
        ll.displayLinkedList();
        ll.deleteNode(6);
        ll.displayLinkedList();
    }
}
