package DataStructure;
import java.util.*;
class Node
{
    int elem;
    Node next;
    Node(int elem,Node next)
    {
	this.elem=elem;
	this.next=next;
    }
}

 public class LinkedList {
    
    Node first=null;
    
    void add(int elem)
    {
	if(first==null)
	{
	    Node n=new Node(elem,null);
	    first =n;
	    
	}
	else
	{
	    Node current=first;
	    Node last=null;
	    while(current.next!=null) { // is the last node
		
		current=current.next;
		current =new Node(elem,current.next);
		
		
	    }// here,we know:current is the last node
	    // because current.next==null;
	    
	    	last=current;
		last.next=new Node(elem,null);
		
	    }
	    
	}
    int get(int index)
    {
	  Node current=first;
	  
	if(first==null)
	{
	   
	   throw new IndexOutOfBoundsException("list is empty"); 
	}
	else
	{
	    int counter =0;
	    while(current.next!=null && counter<index)
	    {
		current=current.next;
		counter++;
		
	    }
	    if(counter==index)
	    {
		return current.elem;
	    }
	    else
	    {
		throw new IndexOutOfBoundsException("list is empty");
	    }
	}
	 return current.elem;
    }
	    
public static void main(String args[])
{
    LinkedList li=new LinkedList();
System.out.println("enter the element");
Scanner input=new Scanner(System.in);
int ele=input.nextInt();
li.add(ele);
    }
    
    

}
