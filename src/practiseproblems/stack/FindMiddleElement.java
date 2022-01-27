package practiseproblems.stack;
import java.util.*;
import java.io.*;


class FindMiddleElement{
    static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution g = new Solution();
            int ans = g.getMiddle(head);
            System.out.println(ans);
            //printList(head);
            t--;
        }
    }
}


class Solution
{
    int getMiddle(Node head)
    {
        Node first=head;
        Node second=head;

        while(second.next!=null){
            first=first.next;
            if(second.next.next!=null){
                second=second.next.next;
            }
            else{
                return first.data;
            }
        }
        return first.data;
    }
}

