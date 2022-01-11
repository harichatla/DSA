package ds;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode{

        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data=data;
            this.next=null;
        }
    }

    public void insert(int pos, int data){
        //check the position it is valid
        if(pos <1){
            System.out.println("invalid position");
        }
        ListNode node=new ListNode(data);
        ListNode current=head;
        int index=1;
        //if position is at the begining
        if(pos==1){
            node.next=head;
            head=node;
        }else{
            //traverse the loop to before the actual postion
            while(current!=null && index<pos-1){
                index++;
                current=current.next;
            }

            if(current!=null){
                node.next=current.next;
                current.next=node;
            }
            else{
                System.out.println("Position is exceeding the actual length");
            }

        }


    }

    public void insertAtLast(int data){
        ListNode node=new ListNode(data);
        ListNode current=head;
        //if head is null then assign the head with the new node
        if(head==null){
            head=node;
            return;
        }

        //traverse until the last node is reached
        while(current.next!=null){
            current=current.next;
        }
        //reference the last node to point to the new node
        current.next=node;
    }

    public void insertAtBeginning(int data){
        ListNode node=new ListNode(data);

        //This condition not mandatory
        if(head == null){
            head=node;
            return;
        }
        //reference the new node to the next node of head
        node.next=head;
        head=node;//reference the head to the newly created node

    }

    /*
    This method finds the length of linked list
     */
    public int length(){
        if(head == null){
            return 0;
        }
        ListNode current=head;
        //initiaze the count variable
        int count =0;
        while(current!=null){
            count++;
            current=current.next;
        }

        return count;
    }

    /*
    This method used to display the elements stored in linked list
     */
    public void display(){
        //loop through the Linked List
        ListNode current=head;
        System.out.println("######List of Data######>>");
        while(current!=null) {
            System.out.println("data "+current.data);
            current=current.next;
        }
    }



    public static void main(String [] args) {
        //create a singly Linked List Object
        SinglyLinkedList sll=new SinglyLinkedList();

        //create a list of Nodes
        ListNode first=new ListNode(10);
        ListNode second =new ListNode(20);
        ListNode third=new ListNode(30);

        //connect the nodes
        sll.head=first;
        first.next=second;
        second.next=third;

      sll.display();
      System.out.println("length of the linked list :"+sll.length());
      sll.insertAtBeginning(15);
      sll.display();
      sll.insertAtLast(34);
      sll.display();

      sll.insert(5,45);
      sll.display();

    }

}
