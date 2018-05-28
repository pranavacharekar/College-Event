package perc;

import java.io.*;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File ;
import java.util.HashMap;


public class Cthread extends Thread{
    
    Socket s;
    DataInputStream dataIn ;
    DataOutputStream dataOut ;
    ObjectInputStream objIn ;
    ObjectOutputStream objOut ;    
    int protocol ;
    
    SQLClass sqlClass ;
    
        
    public Cthread(Socket s)
    {
        try {
           
            this.s=s;
            
            InputStream in=s.getInputStream();
            OutputStream out=s.getOutputStream();
            
            dataIn = new DataInputStream(in);
            dataOut = new DataOutputStream(out);
            
            objOut = new ObjectOutputStream(out);
            dataOut.flush();
            objIn = new ObjectInputStream(in);
            
            sqlClass = new SQLClass();
            
            protocol = -1;
            
        } catch (IOException ex) {
        
            ex.printStackTrace();
        
        }
        
    }
    
    @Override
    public void run()
    {
        
        try {
            
            do{
               
                protocol =  dataIn.readInt() ;
                    //System.out.println("Protocol : "+protocol);
                    switch(protocol) {

                        // check for authentication
                        case 0 :  { authenticate() ; break ; }

                        // send questions to client
                        case 1 : {
                            System.out.println("In sendQuestions cha call");
                            sendQuestions() ; break ; }

                        // get scores from client
                        case 2 : { quitTest() ; break ; }
                        
                        // user is registerings
                        case 3 : { registerUser() ;  break ; }
                        
                        // user is submitting code
                        case 4 : { submitCode() ; break ; }
                        
                        // send CMquestions to client
                        case 5 : { sendCMQuestions() ; break ; }
                        
                        //send map of teamNames to client
                        case 6 : { sendTeamNamesToClient() ; break ; }

                        // authentication failed send back -1 for client to try again
                        default : break;
                        
                }
            } while(protocol != 2 ) ;
        
        } catch (IOException ex) {
        
            ex.printStackTrace();
        
        }

    }

    public void authenticate() {
        
        int auth = -1 ;
        String teamName ;
        
        try {
            
            teamName = dataIn.readUTF() ;
                   
            // call db class and pass teamName
            // pass back 0 if teamName exists else pass back -1
            // and store the returned value in auth
            if( sqlClass.returnPassword(teamName) != null ) {
                auth = 0 ;
            }
            else {
                auth = -1 ;
            }
            
            dataOut.writeInt(auth);
        
        
        } catch (IOException ex) {
            
            ex.printStackTrace();
        
        }
        
        
    }

    public void sendQuestions() {
        
        ArrayList<Ques> list = new ArrayList<>() ;
        
        
        MCQObject[] mcqObj ; 
        
        // call db class and get questions ka array
        // store it in list
        mcqObj = sqlClass.getMCQArray() ;
        
        Ques q = new Ques();
        
        
        for (int i = 1 ; i <= 30 ; i ++ ) {
            System.out.println("For madhe ahe");
            
            q = new Ques(mcqObj[i].qid, mcqObj[i].ps, mcqObj[i].op1, mcqObj[i].op2, mcqObj[i].op3, mcqObj[i].op4, mcqObj[i].ans, mcqObj[i].pos, mcqObj[i].neg);
        
            list.add(q);
            System.out.println(i+" Elements");
        
        }
        
        
        try {
            
            objOut.writeObject(list) ;
        
        } catch (IOException ex) {
        
            ex.printStackTrace() ;
        
        }
        
        
    }

    public void quitTest() {
        
        try {
            
            int score = dataIn.readInt() ;
            String teamName = dataIn.readUTF() ;
            int remainingTime = dataIn.readInt() ;
            
            sqlClass.round2Summarize(teamName, score, remainingTime);
        
        } catch (IOException ex) {
        
            ex.printStackTrace() ;
        
        }
        
        
    }

//    public void runCode() {
//        
//        int qId ;
//        String code ;
//       
//        int successRate = 0 ; 
//        
//        try {
//            // write code to run code
//            // get back success rate
//            
//            qId = dataIn.readInt() ;
//            code = dataIn.readUTF() ;
//
//            dataOut.writeDouble(successRate);
//            
//            
//        } catch (IOException ex) {
//            Logger.getLogger(Cthread.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public void submitCode() {
        
        int qId ; 
        String code ;
        String teamName ;
        String language ;
        int remaniningTime ;
        
        double successRate = 0 ; 
        int score = 0 ;
        
        try {
            
            // write code to enter details into db
            
            qId = dataIn.readInt() ;
            code = dataIn.readUTF() ;
            teamName = dataIn.readUTF() ;
//            remaniningTime = dataIn.readInt() ;
            language=dataIn.readUTF();
            
            
            // change path for linux..set it to /Desktop/teamName/code.language
            //edit this for linux;
            String fname=teamName+"code"+qId;
            
            if(language.equalsIgnoreCase("java"))
            {
                fname+=".java";
            }
            else 
                //if(language.equalsIgnoreCase("C++"))
            {
                fname+=".cpp";
            }
            
            
            File f=new File(fname);
            
            FileWriter fw=new FileWriter(f);
            fw.write(code);
            
            fw.close();
//            System.out.println(f.getAbsolutePath());
            
            
        } catch (IOException ex) {
            Logger.getLogger(Cthread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void sendCMQuestions() {
    
        CMQObject[] obj = new CMQObject[2];
        try {
            
            obj = sqlClass.getCMQ();
            
            System.out.println(obj[1].ps);
            
            objOut.writeObject(obj);
            
        } catch (IOException ex) {
            Logger.getLogger(Cthread.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public void registerUser() {
        
        String part1 , part2 , college , phno , email , teamName ;

        try {
            
            part1 = dataIn.readUTF();
            part2 = dataIn.readUTF();
            college = dataIn.readUTF();
            phno = dataIn.readUTF();
            email = dataIn.readUTF();
            teamName = dataIn.readUTF();
            
            sqlClass.insertTeam(teamName, college, part1, part2, phno, email);
            
            
        } catch (IOException ex) {
            
            ex.printStackTrace() ;
        
        }

    }

    public void sendTeamNamesToClient() {
        
        ArrayList<String> list = new ArrayList<>() ;
        
        try {
            
            
            list = sqlClass.getTeamNames() ;
            
            objOut.writeObject(list);
            
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            
        }
        
        
        
    }

}

/*

send 0 to server for auth
send 1 to server for questions/answers
send 2 to server for sending scores
send 3 to server for sending codes
send 4 to server for saving code
send 5 to server for getting CMQuestions
send 6 to server for getting teamNames for team registration
*/

