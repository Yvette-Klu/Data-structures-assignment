/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlist;

/**
 *
 * @author Eliezer Klu
 */
public class SinglyLinkedList<E> {

    /**
     * @param args the command line arguments
     */
     private static class Node<E>{
        private E data;
        private Node<E> next;
        public Node(E e, Node<E> n){
            data = e;
            next = n;
        }
        
        public E getData(){
            return data;
        }
        public Node<E> getNext(){
            return next;
        }
        
        public void setNext(Node<E> n){
            next = n;
            
        }
    }
    
    // implementation
      private Node<E> head = null;
      private Node<E> tail = null;
      private int size = 0;
      public SinglyLinkedList() {};
      
      //getsize
      public int size(){
          return size;
          
          
      }
      public boolean isEmpty(){
          return size == 0;
      }
      
      //getfirst
      public E first() {
          if(isEmpty()) {
              return null;
          }
          return head.getData();
      }
      
      
      //getlast
      public E last() {
          if(isEmpty()) {
              return null;
          }
          return tail.getData();
      }
      
      //addfirst
      public void addfirst(E e){
          head = new Node<>(e, head); 
          if(size==0){
              tail=head;
          }
          size++;
          System.out.println("added head node '" + head.getData()+"' ");
      }
      
      //add
      public void add(int i , E e){
          if (i < 0 || i > size()){
              throw new IndexOutOfBoundsException();
          }
          if(i == size()){
              addlast(e);
              return;
          }
          if(i==0){
              addfirst(e);
              return;
              
              
             
          } 
            
          
          
    
         
      }
      
      //addlast
      public void addlast(E e){
          Node<E> newNode = new Node<>(e,null);
          if(isEmpty()){
              head = newNode;
              
              
          }else{
              tail.setNext(newNode);
          }
          tail = newNode;
          size++;
          System.out.println("added tail node '" + tail.getData()+"' ");
                  
      }
     
      
      //removefirst
      public E removefirst() {
          if(isEmpty()){
              return null;
          }
          E result = head.getData();
          head = head.getNext();
          size--;
          if(size == 0){
              tail = null;
          }
          System.out.println("removed head node '" + result+"' ");
          return result;
      }
      
      public void removeLast() {
        if (tail == null){
            return;
        }
        else{
            if (head == tail){
                head = null;
                tail = null;
            }else{
                Node<E> prevToTail = head;
                while (prevToTail.next != tail){
                    prevToTail = prevToTail.next;
                  
                }
                tail = prevToTail;
                tail.next = null;
                
            }
	    size--;
        }
    }
      public void clear(){
          head = null;
          tail = null;
          size =0;
          System.out.println("linkedlist cleared");
      }
      
      public E get(int i){
          if(i <0 || i >= size()){
              throw new IndexOutOfBoundsException();
          }
          if(i < size()-1){
              Node<E> current = head;
              for(int j =0; j< i; j++){
                  current = current.getNext();
              }
              return current.getData();
          }
          return tail.getData();
      }
   
    public static void main(String[] args) {
        // TODO code application logic here
        SinglyLinkedList<String> List = new SinglyLinkedList<>();
        List.addfirst("element 1");//adds element at the head
        List.addfirst("element 2");
        List.addfirst("element 3");
        List.addlast("element 4");//adds element at the tail
        List.addlast("element 5");
        List.addlast("element 6");
        
        // prints out the first element in the linked list
        System.out.println(" the first element is " +  List.first()); 
       // prints out the last element in the linked list
        System.out.println(" the last element is " +  List.last());
        
        // gets element at specific index
        
        System.out.println("the element at index 0 is " + List.get(0));
        
        
        List.removeLast();
        // removes element at the head
        while(!List.isEmpty()){
            List.removefirst();
    
            
        }
        
        
        SinglyLinkedList<Integer> remove = new SinglyLinkedList<>();
        remove.addfirst( 1);
        remove.addfirst( 2);
        remove.addfirst(3);
        remove.addfirst( 4);
        remove.addfirst( 5);
        remove.addfirst( 6);
       remove.add(6, 7);// adds element to the linked list
        
        
        
        System.out.println("the size of the list is"+ remove.size()); // gets the size of the list
        
        remove.removeLast(); //removes element at the tail
        
        while(!remove.isEmpty()){
            remove.removefirst();
   
            
        }
        
        remove.clear();// clears the linked list
        
           
        
    }
    
}
