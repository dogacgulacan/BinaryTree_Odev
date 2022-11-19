/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binarytree;

import java.util.Scanner;


public class BinaryTree {

    
    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);
        Btree tree = new Btree();
        int secim=-1;
        int data=0;
        int aranan;
        while(secim!=0){
            System.out.println("\n1-Kök ekle");
            System.out.println("2-Sola ekle");
            System.out.println("3-Saga ekle");
            System.out.println("4-Silme işlemi");
            System.out.println("5-Yazdır");
            System.out.println("0-Çıkış");
            tree.Kok(tree.root,data);
            System.out.print("Seçiminizi giriniz :");secim=sc.nextInt();
            
            switch(secim){
                case 1:
                    System.out.println("Eklenecek degeri giriniz:");
                    data=sc.nextInt();
                    System.out.println("Hangi kökten önce ekleneceğini giriniz:");
                    aranan=sc.nextInt();
                    tree.root=tree.kokeekle(tree.root,data,aranan);break;
                case 2:
                    System.out.println("Hangi kökün soluna ekleneceğini giriniz:");
                    data=sc.nextInt();
                    System.out.println("Eklenecek degeri giriniz:");
                    aranan=sc.nextInt();
                    tree.root=tree.SolaEkle(tree.root,data,aranan);break;
                case 3:
                    System.out.println("Hangi kökün sağına ekleneceğini giriniz:");
                    data=sc.nextInt();
                    System.out.println("Eklenecek degeri giriniz:");
                    aranan=sc.nextInt();
                    tree.root=tree.SagaEkle(tree.root,data,aranan);break;
                case 4:
                    System.out.println("Silinecek degeri giriniz:");
                    data=sc.nextInt();
                    tree.root=tree.Sil(tree.root,data);break;
                case 5:
                    tree.yazdir(tree.root);
                    
            }
        }
    }
    
}
