/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarytree;
import java.util.Scanner;
import java.util.Stack;

public class Btree {
    Dugum root;
    
    public Btree(){
        root=null;
    }
    
        Dugum yeniDugum(int data){   
        root=new Dugum(data);
        System.out.println(data+" Agaca Eklendi");
        return root;
    }
        Scanner sc = new Scanner(System.in);
        Dugum Kok(Dugum root,int data){ 
            if(root==null){
        System.out.println("Agac Bos Oldugundan Baslangic kokunu giriniz:");
        data=sc.nextInt();
        root=yeniDugum(data);
 }
            return root;
        }    
        
      Dugum kokeekle(Dugum root,int data,int aranan){
              Dugum gecici;
            if(root!=null){
            if(root.sol!=null){
            if(root.sol.data==aranan){
               gecici=root.sol;
               root.sol=yeniDugum(data);
               root.sol.sol=gecici;
            }
            else {
                root.sag=kokeekle(root.sag, data, aranan);
                root.sol=kokeekle(root.sol, data, aranan);
                
            }
            }
            if(root.sag!=null){
            if(root.sag.data==aranan){
               gecici=root.sag;
               root.sag=yeniDugum(data);
               root.sag.sag=gecici;
            }
            else {
              root.sol=kokeekle(root.sol, data, aranan);
              root.sag=kokeekle(root.sag, data, aranan); 
            }
            }  
            }
      
        return root;    
    }
      Dugum SolaEkle(Dugum root,int data,int data2){
        if(root!=null){
            if(root.data==data){
                if(root.sol==null)
                root.sol=yeniDugum(data2);
                else
                    System.out.println("Kokun solu dolu oldugundan eklenemez.");
            }
            else{
               root.sol=SolaEkle(root.sol,data,data2);
               root.sag=SolaEkle(root.sag,data,data2);
        }      
        }
        return root;
       } 
       Dugum SagaEkle(Dugum root,int data,int data2){
        if(root!=null){
            if(root.data==data){
                if(root.sag==null)
                root.sag=yeniDugum(data2);
               else
                    System.out.println("Kokun sagi dolu oldugundan eklenemez.");
            }
            else{  
               root.sag=SagaEkle(root.sag,data,data2);
               root.sol=SagaEkle(root.sol,data,data2);
            }
        }
        return root;
       }
       Dugum Sil(Dugum root,int data){
         if(root==null){
             return root;
         } 
         else if(root.data==data){
           root.sol=null;
           root.sag=null;
           root.sag=Sil(root.sag,data);
           root.sol=Sil(root.sol, data);
           root=null;
         }
         else{
           root.sag=Sil(root.sag,data);
           root.sol=Sil(root.sol, data);
         }
           return root;
    }
    public void yazdir(Dugum node) {
    Stack<Dugum> s1 = new Stack<Dugum>();
    Stack<Dugum> s2 = new Stack<Dugum>();

    s1.push(node);
    while (!s1.isEmpty() || !s2.isEmpty()) {

      while (!s1.isEmpty()) {
        Dugum tmp = s1.pop();
        System.out.print(tmp.data + " ");

        if (tmp.sol != null) {
          s2.push(tmp.sol);
        }

        if (tmp.sag != null) {
          s2.push(tmp.sag);
        }
      }
      System.out.println();

      while (!s2.isEmpty()) {
        Dugum tmp = s2.pop();
        System.out.print(tmp.data + " ");

        if (tmp.sag != null) {
          s1.push(tmp.sag);
        }

        if (tmp.sol != null) {
          s1.push(tmp.sol);
        }
      }
      System.out.println();
    }
  }
   
}
