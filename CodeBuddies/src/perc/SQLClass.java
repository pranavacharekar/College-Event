package perc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

class TeamObject
{
    String teamname=new String();
    String password=new String();
    String college=new String();
    String part1=new String();
    String part2=new String();
    String phno=new String();
    String email=new String();
}

class SLTCObject //SLTC = Short Listed Team Contacts
{
    String teamname;
    String phno;
    String email;
}

class MCQObject
{
    int qid;
    String ps=new String();
    String op1=new String();
    String op2=new String();
    String op3=new String();
    String op4=new String();
    int ans;
    int pos;
    int neg;
    public MCQObject()
    {}
    public MCQObject(MCQObject par)
    {
        this.ans=par.ans;
        this.neg=par.neg;
        this.pos=par.pos;
        this.op1=par.op1;
        this.op2=par.op2;
        this.op3=par.op3;
        this.op4=par.op4;
        this.ps=par.ps;
        this.qid=par.qid;
    }
}


public class SQLClass {
    Connection conn;
    
    SQLClass() {
    
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cb1", "root", "");
          System.out.println("Connection established!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
        
//    public static void main(String[] args) {
//        SQLClass c=new SQLClass();
//        c.ConnectDB();
//        c.test(c);
//    }
//    
//    public void test(SQLClass c)
//    {
//        MCQObject x=c.getMCQ(1);
//        System.out.println(x.ps);
//        
//    }
    
//    public void ConnectDB() // function to connect to database
//    {
//        try
//        {
//        Class.forName("com.mysql.jdbc.Driver");
//        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cb1", "anirudh", "");
//            System.out.println("Connection established!");
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
    
    public void insertTeam(String tname, String clg, String p1, String p2, String phno, String email) //Function to insert team records
    {
        String stmt = "insert into teams values (?,?,?,?,?,?)";
        try
        {
            PreparedStatement pst=conn.prepareStatement(stmt);
            pst.setString(1, tname);
            pst.setString(2, clg);
            pst.setString(3, p1);
            pst.setString(4, p2);
            pst.setString(5, phno);
            pst.setString(6, email);
            pst.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public String returnPassword(String teamname) //function used to return password while authentication
    {
        String stmt = "select team_name from teams where team_name=?";
        try
        {
            PreparedStatement pst=conn.prepareStatement(stmt);
            pst.setString(1, teamname);
            ResultSet rs=null;
            rs=pst.executeQuery();
            if(rs.first())
            {
                return rs.getString("team_name");
            }
            else
            {
                return null;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return "~SQL ERROR~";
        }
    }
    
    public void insertMCQ(int qid, String ps, String op1, String op2, String op3, String op4, int answer, int pos, int neg) //function to populate MCQQuestions table
    {
       
        String stmt = "insert into mcq_questions values (?,?,?,?,?,?,?,?,?)";
        try
        {
            PreparedStatement pst=conn.prepareStatement(stmt);
            pst.setInt(1, qid);
            pst.setString(2, ps);
            pst.setString(3, op1);
            pst.setString(4, op2);
            pst.setString(5, op3);
            pst.setString(6, op4);
            pst.setInt(7, answer);
            pst.setInt(8, pos);
            pst.setInt(9, neg);
            pst.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public MCQObject getMCQ(int qid) // Function to get a MCQ by its Q_ID
    {
        MCQObject m=new MCQObject();
        String stmt = "select * from mcq_questions where Q_ID=?";
        PreparedStatement pst;
        try
        {
            m.qid=-1;
            pst=conn.prepareStatement(stmt);
            pst.setString(1, qid+"");
            ResultSet rs;
            rs=pst.executeQuery();
            if(rs.first())
            {
                m.qid=rs.getInt(1);
                m.ps=rs.getString(2);
                m.op1=rs.getString(3);
                m.op2=rs.getString(4);
                m.op3=rs.getString(5);
                m.op4=rs.getString(6);
                m.ans=rs.getInt(7);
                m.pos=rs.getInt(8);
                m.neg=rs.getInt(9);
            }
            return m;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return m;
    }
    
    public int createCMQ(int qid, String ps, String ipf, String opf, String stc, int ms) //function to create a CodeMasters question
    {
        int updatecount=0;
        String stmt = "insert into codemasters_questions values (?,?,?,?,?,?)";
        try
        {
            PreparedStatement pst=conn.prepareStatement(stmt);
            pst.setInt(1, qid);
            pst.setString(2, ps);
            pst.setString(3, ipf);
            pst.setString(4, opf);
            pst.setString(5, stc);
            pst.setInt(6, ms);
            
            updatecount=pst.executeUpdate();
            return updatecount;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return updatecount;
        }
    }
    
    public CMQObject[] getCMQ() //function to get a CodeMasters question from Database
    {
        CMQObject m[]=new CMQObject[2];
        
        for (int i = 0 ; i < 2 ; i ++ )
            m[i] = new CMQObject() ;
        
        String stmt = "select * from codemasters_questions";
        try
        {
            m[0].qid=-1;
            m[1].qid=-1;
            PreparedStatement pst=conn.prepareStatement(stmt);
            ResultSet rs=null;
            rs=pst.executeQuery();
            int i=0;
            while(rs.next())
                {
                    m[i].qid=rs.getInt(1);
                    m[i].ps=rs.getString(2);
                    m[i].ipf=rs.getString(3);
                    m[i].opf=rs.getString(4);
                    m[i].stc=rs.getString(5);
                    m[i].ms=rs.getInt(6);
                    i++;
                }
            
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
                
        return m;
    }
 
    /*  15 easy questions from 1-20
        10 medium questions from 21-35
        5 hard questions from 36-45
    */
    
    public MCQObject[] getMCQArray() //function to get an array of MCQs in random fashion
    {
        
//        MCQObject a[]=new MCQObject[31];
//        ArrayList arr=new ArrayList();
//        int j=1;
//        for(int i=1; i<=20; i++) //this loop creates an array of numbers from 1-20 i.e. qid of easy questions
//        {
//            arr.add(i);
//        }
//        Collections.shuffle(arr); //randomizes the array
//        for(int i=1; i<=15; i++)
//        {
//            a[j]=getMCQ((int)arr.get(i)); //the MCQ corresponding to the qid in the array is taken from the db
//            j++;
//            
//        }
//        arr.clear();
//        for(int i=21; i<=35; i++) //this loop creates an array of numbers from 21-35 i.e. qid of medium questions
//        {
//            arr.add(i);
//        }
//        Collections.shuffle(arr); //randomizes the array
//        for(int i=1; i<=10; i++)
//        {
//            a[j]=getMCQ((int)arr.get(i)); //the MCQ corresponding to the qid in the array is taken from the db
//            j++;
//        }
//        arr.clear();
//        for(int i=36; i<=45; i++) //this loop creates an array of numbers from 36-45 i.e. qid of hard questions
//        {
//            arr.add(i);
//        }
//        Collections.shuffle(arr); //randomizes the array
//        for(int i=1; i<=5; i++)
//        {
//            a[j]=getMCQ((int)arr.get(i)); //the MCQ corresponding to the qid in the array is taken from the db
//            j++;
//        }
//        return a; //the 30 questions are ready to be sent to the client
        MCQObject a[]=new MCQObject[31];
        ArrayList arr=new ArrayList(31);
        int j=1;
        for(int i=1; i<=40; i++) //this loop creates an array of numbers from 1-20 i.e. qid of easy questions
        {
            arr.add(i);
        }
        Collections.shuffle(arr); //randomizes the array
        for(int i=0; i<15; i++)
        {
            a[j]=getMCQ((int)arr.get(i)); //the MCQ corresponding to the qid in the array is taken from the db
            j++;
            
        }
        arr.clear();
        for(int i=41; i<=65; i++) //this loop creates an array of numbers from 21-35 i.e. qid of medium questions
        {
            arr.add(i);
        }
        Collections.shuffle(arr); //randomizes the array
        for(int i=0; i<=9; i++)
        {
            a[j]=getMCQ((int)arr.get(i)); //the MCQ corresponding to the qid in the array is taken from the db
            j++;
        }
        arr.clear();
        for(int i=66; i<=80; i++) //this loop creates an array of numbers from 36-45 i.e. qid of hard questions
        {
            arr.add(i);
        }
        Collections.shuffle(arr); //randomizes the array
        for(int i=0; i<=4; i++)
        {
            a[j]=getMCQ((int)arr.get(i)); //the MCQ corresponding to the qid in the array is taken from the db
            j++;
        }
        return a; //the 30 questions are ready to be sent to the client
    }
    
    public void round2Summarize(String teamname, int score, int remTime) //function to add the final score record of each team.
    {
        String stmt = "insert into round2_team_summary values (?,?,?)";
        try
        {
            PreparedStatement pst=conn.prepareStatement(stmt);
            pst.setString(1, teamname);
            pst.setInt(2, score);
            pst.setInt(3, remTime);
            pst.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();

        }
    }
    
    public SLTCObject[] shortlistRound2(int howmanyteams) //function to shortlist teams from round 2 results.
    {
        SLTCObject t[]=new SLTCObject[howmanyteams+1], temp=new SLTCObject();
        int j=1;
        String stmt = "select r.team_name, phno, email from teams t, round2_team_summary r where t.team_name=r.team_name order by score desc limit ?";
        try
        {
            PreparedStatement pst;
            pst=conn.prepareStatement(stmt);
            pst.setInt(1, howmanyteams);
            ResultSet rs;
            rs=pst.executeQuery();
            if(rs.first())
            {
                do
                {
                    temp=new SLTCObject();
                    temp.teamname = rs.getString(1);
                    temp.phno = rs.getString(2);
                    temp.email = rs.getString(3);
                    t[j]=temp;
                    j++;
                }while(rs.next());
            }
            else
            {
                System.out.println("~SQLERROR~");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return t;
    }

    public ArrayList<String> getTeamNames() {
        
        ArrayList<String> list = new ArrayList<>() ;
        String stmt = "select team_name from teams";
        String temp;
        try
        {
            PreparedStatement pst;
            pst=conn.prepareStatement(stmt);
            ResultSet rs;
            rs=pst.executeQuery();
            while(rs.next()) {
                temp=rs.getString("team_name");
                list.add(temp);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    
        return list ;
        
    }
     
}
