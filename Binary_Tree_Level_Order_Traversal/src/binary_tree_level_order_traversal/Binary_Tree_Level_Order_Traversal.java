/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_tree_level_order_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Binary_Tree_Level_Order_Traversal {

    Queue<Node> q=new LinkedList<>();
    Stack<Node> s1=new Stack<>();
    Stack<Node> s2=new Stack<>();
    Node root;
    int i=0;
    public Binary_Tree_Level_Order_Traversal()
    {
        root=null;
    }
    public void insert(int val)
    {
        if(root==null)
        {
            root=new Node(val);
        }
        else
        {
            q.offer(root);
            while(!q.isEmpty())
            {
                Node temp=q.peek();
                q.poll();
                if(temp.left!=null)
                {
                    q.offer(temp.left);
                }
                if(temp.right!=null)
                {
                    q.offer(temp.right);
                }
                if(temp.left==null)
                {
                    temp.left=new Node(val);
                    break;
                }
                if(temp.right==null)
                {
                    temp.right=new Node(val);
                    break;
                }
            }
        }
    }
    
    public void inorder(Node root)
    {
        if(root!=null)
        {
        inorder(root.left);
        System.out.print(" "+root.data);
        inorder(root.right);
        }
    }
    
    public void preorder(Node root)
    {
        if(root!=null)
        {
            System.out.print(" "+root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    public void postorder(Node root)
    {
        if(root!=null)
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(" "+root.data);
        }
    }
    
    void spiralLevelOrderTraversal(Node root)
    {
        if(root!=null)
        {
            s1.push(root);
            while(!s1.isEmpty() || !s2.isEmpty())
            {
                while(!s1.isEmpty())
                {
                    Node temp=s1.peek();
                    s1.pop();
                    System.out.print(temp.data+ " ");
                    if(temp.left!=null)
                    {
                        s2.push(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        s2.push(temp.right);
                    }
                }
                while(!s2.isEmpty())
                {
                    Node temp=s2.peek();
                    s2.pop();
                    System.out.print(temp.data+" ");
                    if(temp.right!=null)
                    {
                        s1.push(temp.right);
                    }
                    if(temp.left!=null)
                    {
                        s1.push(temp.left);
                    }
                }
            }
        }
    }
    
    
    void delete(Node root)
    {
        //Delete the last node from the tree
        if(root!=null)
        {
        if(root.left==null && root.right==null)
        {
            root=null;
        }
        else
        {
            if(root.right!=null)
            {
                delete(root.right);
            }
            else if(root.left!=null)
            {
                delete(root.left);
            }
        }
        }
    }
    
    public int height(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        if(left>right)
        {
            return left+1;
        }
        else
        {
            return right+1;
        }
    }
    //int diameter=0;
    public int diameter(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=diameter(root.left);
        int right=diameter(root.right);
        
        int left_height=height(root.left);
        int right_height=height(root.right);
        
        int len1=left_height+right_height+1;
        int len2=Math.max(left, right);
        
        return Math.max(len2, len1);
    }
    
    public int level(Node root,int val)
    {
        int level=1;
        Stack<Node> ss1=new Stack<>();
        Stack<Node> ss2=new Stack<>();
        if(root!=null)
        {
            ss1.push(root);
            while(!ss1.isEmpty() || !ss2.isEmpty())
            {
                while(!ss1.isEmpty())
                {
                    Node temp=ss1.peek();
                    ss1.pop();
                    if(temp.data==val)
                    {
                        return level;
                    }
                    if(temp.left!=null)
                    {
                        ss2.push(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        ss2.push(temp.right);
                    }
                }
                if(ss1.isEmpty() && !ss2.isEmpty())
                {
                    level++;
                }
                while(!ss2.isEmpty())
                {
                    Node temp=ss2.peek();
                    ss2.pop();
                    if(temp.data==val)
                    {
                        return level;
                    }
                    if(temp.left!=null)
                    {
                        ss1.push(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        ss1.push(temp.right);
                    }
                }
                if(ss2.isEmpty() && !ss1.isEmpty())
                {
                    level++;
                }
            }
        }
        return -1;
    }
    
    public Node clone(Node root1)
    {
        if(root1==null)
        {
            return null;
        }
        
        Node newnode=new Node(root1.data);
        newnode.left=clone(root1.left);
        newnode.right=clone(root1.right);
        
        return newnode;
    }
    
    void extremeNodesInAlternateOrder(Node root)
    {
        int l=0;
        int r=0;
        if(root!=null)
        {
            s1.push(root);
            while(!s1.isEmpty() || !s2.isEmpty())
            {
                r=0;
                while(!s1.isEmpty())
                {
                    Node temp=s1.peek();
                    s1.pop();
                    if(l==0)
                    {
                        System.out.print(temp.data+ " ");
                        l++;
                    }
                    if(temp.left!=null)
                    {
                        s2.push(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        s2.push(temp.right);
                    }
                }
                l=0;
                while(!s2.isEmpty())
                {
                    Node temp=s2.peek();
                    s2.pop();
                    if(r==0)
                    {
                        System.out.print(temp.data+" ");
                        r++;
                    }
                    if(temp.right!=null)
                    {
                        s1.push(temp.right);
                    }
                    if(temp.left!=null)
                    {
                        s1.push(temp.left);
                    }
                }
            }
        }
    }
    
    public Node mirror(Node root)
    {
        if(root!=null)
        {
            mirror(root.left);
            mirror(root.right);
            Node temp=root.left;
            root.left=root.right;
            root.right=temp;
        }
        return root;
    }
    
    public Node LowestCommonAncestor(Node root,int data1,int data2)
    {
        if(root==null)
        {
            return root;
        }
        if(root.data==data1 || root.data==data2)
        {
            return root;
        }
        Node left=LowestCommonAncestor(root.left, data1, data2);
        Node right=LowestCommonAncestor(root.right, data1, data2);
        
        if(left!=null && right!=null)
        {
            return root;
        }
        else
        {
            return left!=null?left:right;
        }
    }
    
    public int getHead(int arr[])//the array passed here is the preorder traversal sequence
    {
        return arr[this.i++];
    }
    public int searchNode(int start,int end,int arr[],int value)//the array passed here is the inorder traversal sequence
    {
        for(int l=start;l<=end;l++)
        {
            if(value==arr[l])
            {
                return l;
            }
        }
        return -1; //Indicates that the traversal given are wrong
    }
    
    public Node formTree(int in[],int pr[],int start,int end)
    {
        Node root=null;
        if(start<=end)
        {
            root=new Node(getHead(pr));
            int pivot=searchNode(start, end, in, root.data);
            if(pivot==-1)
            {
                return null;
            }
            root.left=formTree(in, pr, start, pivot-1);
            root.right=formTree(in, pr, pivot+1, end);
        }
        return root;
    }
    
    public static void main(String[] args)throws IOException {
        int choice=0;
        Node clone=null;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Binary_Tree_Level_Order_Traversal x=new Binary_Tree_Level_Order_Traversal();
        while(choice!=16)
        {
            System.out.println("\nAVAILABLE OPERATIONS:\n1. Insertion\t2. Inorder\t3. Preorder\t4. Postorder"
                    + "\n5. Spiral Level Order Traversal\t6. Delete\t7. Height\t8. Diameter\n9. Level Search\t"
                    + "10. Clone\t11. Print Clone \t12. Extreme Nodes In Alternate Order \n13. Mirror\t14. LCA \t15. Inorder Preorder tree formation\t16. Exit\n");
            System.out.print("Enter Choice:>>");
            choice=Integer.parseInt(br.readLine());
            switch(choice)
            {
                case 1:
                    System.out.print("INPUT:>>");
                    x.insert(Integer.parseInt(br.readLine()));
                    break;
                case 2:
                    x.inorder(x.root);
                    System.out.println();
                    break;
                case 3:
                    x.preorder(x.root);
                    System.out.println();
                    break;
                case 4:
                    x.postorder(x.root);
                    System.out.println();
                    break;
                case 5:
                    x.spiralLevelOrderTraversal(x.root);
                    System.out.println();
                    break;
                case 6:
                    x.delete(x.root);
                    break;
                case 7:
                    int h=x.height(x.root);
                    System.out.println("Height is "+h);
                    System.out.println();
                    break;
                case 8:
                    int d=x.diameter(x.root);
                    System.out.println("Diameter is "+d);
                    break;
                case 9:
                    System.out.print("\nEnter the data to be searched :>>");
                    int dv=Integer.parseInt(br.readLine());
                    int ch=x.level(x.root, dv);
                    if(ch==-1)
                    {
                        System.out.print("\nValue Not Found!");
                    }
                    else
                    {
                        System.out.print("The data item is present at "+ch+" level.");
                    }
                    break;
                case 10:
                    clone=x.clone(x.root);
                    System.out.print("\n CLoning Done!\n");
                    break;
                case 11:
                    System.out.print("\nThe Cloned tree is:>>");
                    x.inorder(clone);
                    break;
                case 12:
                    x.extremeNodesInAlternateOrder(x.root);
                    break;
                case 13:
                    x.root=x.mirror(x.root);
                    System.out.print("\nMirror created!");
                    break;
                case 14:
                    System.out.println("\nEnter the first number:>>");
                    int data1=Integer.parseInt(br.readLine());
                    System.out.print("\nEnter the second number:>>");
                    int data2=Integer.parseInt(br.readLine());
                    Node lca=x.LowestCommonAncestor(x.root, data1, data2);
                    System.out.print("The LCA is "+lca.data);
                    break;
                case 15:
                    char inorder[]=new char[1000],inc;
                    char preorder[]=new char[1000],poc;
                    System.out.print("\nEnter the Inorder Traversal Sequence:>>");
                    String s1=br.readLine();
                    inorder=s1.toCharArray();
                    System.out.print("\nEnter the Postorder Traversal Sequence:>>");
                    String s2=br.readLine();
                    preorder=s2.toCharArray();
                    int ins[]=new int[1000];
                    int prs[]=new int[1000];
                    for(int i=0;i<s1.length();i++)
                    {
                        ins[i]=Integer.parseInt(inorder[i]+"");
                    }
                    for(int i=0;i<s2.length();i++)
                    {
                        prs[i]=Integer.parseInt(preorder[i]+"");
                    }
                    Node inroot=x.formTree(ins, prs, 0, 6/*Math.max(ins.length, prs.length*/);
                    x.inorder(inroot);
                    break;
                case 16:
                    System.out.println("Exited!");
                    System.exit(0);
            }
        }
    }
}