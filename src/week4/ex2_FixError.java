package week4;

public class ex2_FixError {
    int p;
    public void setP(int p){
        this.p = p;                     //p = p -> cannot define which p
                                        //added this.p ->  setP function ## p in the ex2_FixError class
    }
}
