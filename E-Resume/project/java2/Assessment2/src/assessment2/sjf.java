package assessment2;

public class sjf {
    private char process;
    private int ATime, BTime, TATime, WTime, CTime, ETime;
    /*      Process = Job name
            ATime = Arrival Time
            BTime = Bursting Time
            TATime = Turn around Time
            WTime = Waiting Time
            CTime = Completion Time
            ETime = Executing Time
    */
    
    public sjf(char p, int at, int bt) 
    {
        process = p;
        ATime = at;
        BTime = bt;
    }
    
    public char getProcess() {return process;}
    public int getAT() {return ATime;}
    public int getBT() {return BTime;}
    public int getTAT() {return TATime;}
    public int getWT() {return WTime;}
    public int getCT() {return CTime;}
    public int getET() {return ETime;}

    public void setProcess(char p) {process = p;}
    public void setAT(int at) {ATime = at;}
    public void setBT(int bt) {BTime = bt;}
    public void setTAT(int tat) {TATime = tat;}
    public void setWT(int wt) {WTime = wt;}
    public void setCT(int ct) {CTime = ct;}
    public void setET(int et) {ETime = et;}
}
