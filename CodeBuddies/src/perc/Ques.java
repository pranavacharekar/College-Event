package perc;

import java.io.Serializable;

public class Ques implements Serializable{
    public static final long serialVersionUID=1L;
    /*
    @params
    Ques MCQObject
    qid = qid
    ans = ans
    posm = pos
    negm = neg
    prob = ps
    op1 = op1
    op2 = op2
    op3 = op3
    op4 = op4
    */
    
    int qid,ans,posm,negm;
    String prob,op1,op2,op3,op4;
    
    public Ques() {
    
    }
    
    public Ques(int qid,String prob,String op1,String op2,String op3,String op4,int ans,int posm,int negm) {
    
        this.qid=qid;
        this.prob=prob;
        this.op1=op1;
        this.op2=op2;
        this.op3=op3;
        this.op4=op4;
        this.ans=ans;
        this.posm=posm;
        this.negm=negm;
    
    }
    
    public int getqid() {
        return qid;
    }
    
    public String getprob() {
        return prob;
    }
    
    public String getop1() {
        return op1;
    }
    
    public String getop2() {
        return op2;
    }
    
    public String getop3() {
        return op3;
    }
    
    public String getop4() {
        return op4;
    }
    
    public int getans() {
        return ans;
    }
    
    public int getposm() {
        return posm;
    }
    
    public int getnegm() {
        return negm;
    }
    
}
