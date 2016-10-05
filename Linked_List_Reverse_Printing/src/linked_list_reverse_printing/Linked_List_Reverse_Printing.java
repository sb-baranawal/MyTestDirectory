/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list_reverse_printing;

/**
 *
 * @author Saurabh
 */
public class Linked_List_Reverse_Printing {
    
    Node root;
    
    public Linked_List_Reverse_Printing()
    {
        root=null;
    }
    void insert(int value)
    {
        if(root==null)
        {
            root=new Node(value);
            System.out.println("Inserted at root"+root.data);
        }
        else
        {
            Node ptr=root;
            while(ptr.next!=null)
            {
                ptr=ptr.next;
            }
            ptr.next=new Node(value);
            System.out.println("Inserted at end"+ptr.data);
        }
    }
    
    public void display(Node root)
    {
        if(root==null)
        {
            return;
        }
            display(root.next);
            System.out.println(root.data);
            return;
        
    }
    public static void main(String[] args) {
        Linked_List_Reverse_Printing x=new Linked_List_Reverse_Printing();
        x.insert(10);
        x.insert(20);
        x.insert(30);
        x.insert(40);
        x.display(x.root);
    }
    
}
