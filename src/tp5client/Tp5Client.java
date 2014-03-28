package tp5client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Tp5Client {

    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        Socket socket = new Socket("localhost", 4444);
        //Socket socket = new Socket("127.0.0.1", 4444);
        //to get the ip address
        System.out.println((java.net.InetAddress.getLocalHost()).toString());

        //true: it will flush the output buffer
        PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       // Thread.sleep(1000);
        
        System.out.println("Sending Hello to server");
        outSocket.println("Hello");
        System.out.println("Waiting answer from server");
        
        if ("Hello".equals(inSocket.readLine())) {
            
            System.out.println("Bonjour, quel est votre Nom");
            String Fname = sc.nextLine();
            
            System.out.println ("Quel est votre prénom");
            String Lname = sc.nextLine();
           
            StringBuilder Identity = new StringBuilder();
            Identity.append(Fname).append("|").append(Lname);
            outSocket.println(Identity.toString());
            
            String ListePiece = inSocket.readLine();
            String ListAndSlot [] = ListePiece.split("|");
            
            System.out.println ("Choississez votre pièce");
            for (int i = 0; i < ListAndSlot.length-1 ; i++) {
                
                String name = ListAndSlot[i].split("-nb-")[0];
                String Slot = ListAndSlot[i].split("-nb-")[1];
                
                System.out.println ("tapez "+ i+1 +" pour la pièce "+ name +"(Il reste pour cette piece "+ Slot +" places");
                
            }
            
            String Numpiece = sc.nextLine();
            System.out.println("Combien de place(s) désirez vous ?");
            String NbSlotTaken = sc.nextLine();
            
            StringBuilder Reservation = new StringBuilder();
            Reservation.append(Numpiece).append("|").append(NbSlotTaken);
            outSocket.println(Reservation.toString());
            
            
            
            if ("Validé".equals(inSocket.readLine())) {
                
                System.out.println("Votre réservation à bien été enregistré. Merci");
            }
            else {
                System.out.println("Erreur !");
            }
            
           
        
        }
    }
}
