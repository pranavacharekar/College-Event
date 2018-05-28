/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anirudh
 */
public class Client {
    
    Socket socket ;
    DataInputStream dataIn ;
    DataOutputStream dataOut ;
    ObjectInputStream objIn ;
    ObjectOutputStream objOut ;
    
    String teamName ;
    
    
    Client() {
    
        try {
           
            // change port number to ip address of server
            socket = new Socket("localhost",8999);
            dataIn = new DataInputStream(socket.getInputStream());
            dataOut = new DataOutputStream(socket.getOutputStream());
            
            objOut = new ObjectOutputStream(socket.getOutputStream());
            objOut.flush();
            objIn = new ObjectInputStream(socket.getInputStream());
            
        
        } catch (IOException ex) {
        
            ex.printStackTrace();
        
        }
        
    }
    
    public boolean authentication(String teamName) {
        
        this.teamName = teamName ;
    
        try {
            
            dataOut.writeInt(0);
            dataOut.writeUTF(teamName);
            int auth = dataIn.readInt();
            
            if( auth == 0 ) {
            
                //auth successful
                return true ;
                
            }
            
        
        } catch (IOException ex) {
            
            ex.printStackTrace();
            
        }
        
        //auth unsuccessful
        return false;        
    
    }
    
    
    public ArrayList<Ques> getQuestions() {
        
        ArrayList<Ques> list = null ;
    
         try {
            
            dataOut.writeInt(1);
            
             System.out.println("getQ madhe ahe mi");
            
            list = (ArrayList) objIn.readObject();
            Collections.shuffle(list);
            
        
        } catch (IOException|ClassNotFoundException ex) {
            
            ex.printStackTrace();
            
        }
         
         return list;
    
    }
    
    public void quitTest(int score, String teamName, int remainingTime) {
    
        try {
            
            dataOut.writeInt(2) ;
            
            dataOut.writeInt(score) ;
            
            dataOut.writeUTF(teamName);
            
            dataOut.writeInt(remainingTime) ;
            
            socket.close() ;
            
        
        } catch (IOException ex) {
            
            ex.printStackTrace();
            
        }
    
    }
    
    public void sendCodeForTesting( int qId , String code , String teamName ) {
    
        
        int score = 0 ;
        double successRate = 0 ;
        
        try {
            
            // user is only running not submitting
         
            dataOut.writeInt(3) ;
            dataOut.writeInt(qId) ;
            dataOut.writeUTF(code) ;
            
            //successRate = dataIn.readDouble() ;

            // success rate
            // max score
        
        } catch (IOException ex) {
            
              ex.printStackTrace();
        
        }
    
       // return successRate ;
            
    }
    
    public void sendCodeForSubmitting( int qId , String code , String teamName , String language) {
    
        int score = 0 ;
        double successRate = 0 ;
        
          try {
          
            // user is submitting
          
            dataOut.writeInt(4) ;
            dataOut.writeInt(qId) ;
            dataOut.writeUTF(code) ;
            dataOut.writeUTF(teamName) ;
            dataOut.writeUTF(language);

//            score = dataIn.readInt() ;
//            successRate = dataIn.readDouble() ;  
            
        
        } catch (IOException ex) {
            
              ex.printStackTrace();
        
        }
          
       // return score ;
    
    }
    
    public CMQObject[] getCMQuestions() {
        
        CMQObject[] obj = new CMQObject[2] ;
        
         try {
          
            dataOut.writeInt(5) ;

            obj = (CMQObject[]) objIn.readObject() ;
            
        
        } catch (IOException|ClassNotFoundException ex) {
            
              ex.printStackTrace();
        
        }
        
        return obj;
        
    }

    public void registerUser(String part1, String part2, String college, String phno, String email, String teamName) {
        
        try {

                dataOut.writeInt(3) ;

                dataOut.writeUTF(part1);
                dataOut.writeUTF(part2);
                dataOut.writeUTF(college);
                dataOut.writeUTF(phno);
                dataOut.writeUTF(email);
                dataOut.writeUTF(teamName);
            
                
            } catch (IOException ex) {
            
              ex.printStackTrace();
        
        }
       
    }

    public ArrayList<String> getTeamsList() {
        
        ArrayList<String> list = new ArrayList<>() ;
        
        try {
            
            dataOut.writeInt(6);
            list = (ArrayList) objIn.readObject() ;
        
        } catch (IOException|ClassNotFoundException ex) {
        
            ex.printStackTrace();
        
        }
        
        
        return list;

    }
      
    
}

/*

send 0 to server for auth
send 1 to server for questions/answers
send 2 to server for sending scores
send 3 to server for registering user
send 4 to server for saving code
send 5 to server for getting CMQuestions

*/