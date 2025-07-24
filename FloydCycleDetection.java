class FloydCycleDetection{
    static class Node{
        // Node Class for Linked List
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
      
        // Detect clycle using Floyd's Algorithm (tortoise and hare)

        static boolean hasCycle(Node head){
            // Edge case: empty list or single node has no cycle

            if ( head == null || head.next == null) return false;

            Node slow = head;
            Node fast = head;
            while( fast != null && fast.next !=null){
                slow = slow.next;
                fast = fast.next.next;
                if( slow == fast ) return true;
            }
            return false;
        }

            public static void main(String[] args){
                Node head = new Node(1);
                head.next = new Node(2);
                head.next.next = new Node(3);
                head.next.next.next = new Node(4);
                head.next.next.next.next = head.next;

                System.out.println("Has Cycle?" + hasCycle(head));
            }
}