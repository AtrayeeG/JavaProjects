class ReverseLinkedList{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static Node reverseList(Node head){
        Node prev = null; // Previous Box
        Node curr = head; // Current Box
        while(curr!= null){
              Node next = curr.next; //Save next box
              curr.next = prev;      // Ponit backward
              prev = curr;           // Move prev forward
              curr = next;           // Move curr forward
        }
        return prev;
    }

    static void printList(Node head){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        System.out.println("Original:");
        printList(head);
        head = reverseList(head);
        System.out.println("Reversed:");
        printList(head);
    }
}