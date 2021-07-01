public class DoubleLinkedList {
    private class Node{
        int value;
        Node left;
        Node right;

        //Constructor
        Node(int val){
            value = val;
            left = null;
            right = null;
        }
    }

    Node first;

    //constructor
    DoubleLinkedList(){
        first = null;
    }

    //Insert a node at the end
    public void insertAtTheEnd(int val){
        Node newNode = new Node(val);
        Node pointer = first;
        if(first==null){
            //List is currently empty, hence insert the new node as the first node
            first = newNode;
        } else {
            while(pointer.right!=null){
                pointer = pointer.right;
            }
            newNode.left = pointer;
            pointer.right = newNode;
        }
    }

    //Search for a node
    public Node searchNode(int val){
        Node pointer = first;
        while(pointer.value != val && pointer.right != null){
            pointer = pointer.right;
        }
        if(pointer.value == val){
            return pointer;
        } else {
            System.out.println("Cannot find " + val + " in the List");
            return null;
        }
    }

    //Insert a node after a given value
    public void insertAfterValue(int val, int afterThis){
        Node newNode = new Node(val);
        Node pointer = searchNode(afterThis);
        if(pointer == null){
            System.out.println("Insertion of " + val + " after " + afterThis + " Failed");
        } else if(pointer.right == null) {
            //Insert at the end
            newNode.left = pointer;
            newNode.right = null;
            pointer.right = newNode;
        } else {
            newNode.left = pointer;
            newNode.right = pointer.right;
            pointer.right.left = newNode;
            pointer.right = newNode;
        }
    }

    //Insert a node before a given value
    public void insertBeforeValue(int val, int beforeThis){
        Node newNode = new Node(val);
        Node pointer = searchNode(beforeThis);
        if(pointer==null){
            System.out.println("Insertion of " + val + " before " + beforeThis + " Failed");
        } else if (pointer == first){
            newNode.left = null;
            newNode.right = pointer;
            first = newNode;
            pointer.left = newNode;
        } else {
            newNode.left = pointer.left;
            newNode.right = pointer;
            pointer.left.right = newNode;
            pointer.left = newNode;
        }
    }

    //Delete a given node
    public void deleteNode(int val){
        Node pointer = searchNode(val);
        if(pointer==null){
            System.out.println("Deletion of " + val + "  failed");
        }else{
            if(pointer == first){
                //First node does not have a pre node
                first = pointer.right;
            } else if(pointer.right == null){
                //Delete the last node
                pointer.left.right = null;
            } else {
                pointer.left.right = pointer.right;
                pointer.right.left = pointer.left;
            }
        }
    }

    //display
    public void displayLinkedList(){
        System.out.println();
        DoubleLinkedList.Node pointer = first;
        if(pointer==null){
            System.out.println("The List is empty");
        }else{
            System.out.print(pointer.value + "\t");
            while(pointer.right!=null){
                pointer = pointer.right;
                System.out.print(pointer.value + "\t");
            }
        }
        System.out.println();
    }

    public static void main(String args[]){
        DoubleLinkedList ll = new DoubleLinkedList();
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
