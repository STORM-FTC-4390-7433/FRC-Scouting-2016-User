package database;


public class Stronghold {
    private int teamNum = 0;
    private int matchNum = 0;
    private int alliance = 0;
    private int autoHigh = 0;
    private int autoLow = 0;
    private int autoCross = 0;
    private int autoDef = 0;
    private int highGoal = 0;
    private int lowGoal = 0;

    private int ramp = 0;
    private int scale = 0;
    private int breach = 0;
    private int capture = 0;
    private int
    dCross1 = 0, dCross2 = 0, dCross3 = 0, dCross4 = 0, dCross5 = 0, dWeak1 = 0, dWeak2 = 0, dWeak3 = 0, dWeak4 = 0, dWeak5 = 0;
    private String startingPos = "", d1 = "", d2 = "", d3 = "", d4 = "", d5 = "", notes = "";
    private int humanYes = 0, humanNo = 0;
    private int pt = 0, cdf = 0, rt = 0, sp = 0, lb = 0, rmp = 0, mt = 0, db = 0, rw = 0;
    public Stronghold(){}
    public Stronghold(int teamNum, int matchNum, int alliance) {
        this.teamNum = teamNum;
        this.matchNum = matchNum;
        this.alliance = alliance;
    }
    public int getAutoDef() {
        return autoDef;
    }

    public void setAutoDef(int autoDef) {
        this.autoDef = autoDef;
    }
    public int getAutoCross() {
        return autoCross;
    }
    public int getHighGoal() {
        return highGoal;
    }

    public void setHighGoal(int highGoal) {
        this.highGoal = highGoal;
    }

    public int getLowGoal() {
        return lowGoal;
    }

    public void setLowGoal(int lowGoal) {
        this.lowGoal = lowGoal;
    }
    public void setAutoCross(int autoCross) {
        this.autoCross = autoCross;
    }
    public void setAutoHigh(int autoHigh) {
        this.autoHigh = autoHigh;
    }

    public void setAutoLow(int autoLow) {
        this.autoLow = autoLow;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public void setCapture(int capture) {
        this.capture = capture;
    }

    public void setStartingPos(String startingPos) {
        this.startingPos = startingPos;
    }

    public void setD1(String d1) {
        this.d1 = d1;
    }

    public void setD2(String d2) {
        this.d2 = d2;
    }

    public void setD3(String d3) {
        this.d3 = d3;
    }

    public void setD4(String d4) {
        this.d4 = d4;
    }

    public void setD5(String d5) {
        this.d5 = d5;
    }


    public void setdWeak1(int dWeak1) {
        this.dWeak1 = dWeak1;
    }

    public void setdWeak2(int dWeak2) {
        this.dWeak2 = dWeak2;
    }

    public void setdWeak3(int dWeak3) {
        this.dWeak3 = dWeak3;
    }

    public void setdWeak4(int dWeak4) {
        this.dWeak4 = dWeak4;
    }

    public void setdWeak5(int dWeak5) {
        this.dWeak5 = dWeak5;
    }


    public void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }

    public void setMatchNum(int matchNum) {
        this.matchNum = matchNum;
    }

    public void setAlliance(int alliance) {
        this.alliance = alliance;
    }

    public int getTeamNum() {
        return teamNum;
    }

    public int getMatchNum() {
        return matchNum;
    }

    public int getAlliance() {
        return alliance;
    }

    public int getAutoHigh() {
        return autoHigh;
    }

    public int getAutoLow() {
        return autoLow;
    }

    public int getScale() {
        return scale;
    }

    public int getCapture() {
        return capture;
    }

    public String getStartingPos() {
        return startingPos;
    }

    public String getD1() {
        return d1;
    }

    public String getD2() {
        return d2;
    }

    public String getD3() {
        return d3;
    }

    public String getD4() {
        return d4;
    }

    public String getD5() {
        return d5;
    }

    public int getdWeak1() {
        return dWeak1;
    }

    public int getdWeak2() {
        return dWeak2;
    }

    public int getdWeak3() {
        return dWeak3;
    }

    public int getdWeak4() {
        return dWeak4;
    }

    public int getdWeak5() {
        return dWeak5;
    }
    public int getRamp() {
        return ramp;
    }

    public void setRamp(int ramp) {
        this.ramp = ramp;
    }

    public String getNotes() {
        return notes;
    }

    public void setdCross1(int dCross1) {
        this.dCross1 = dCross1;
    }

    public void setdCross2(int dCross2) {
        this.dCross2 = dCross2;
    }

    public void setdCross3(int dCross3) {
        this.dCross3 = dCross3;
    }

    public void setdCross4(int dCross4) {
        this.dCross4 = dCross4;
    }

    public void setdCross5(int dCross5) {
        this.dCross5 = dCross5;
    }

    public int getdCross1() {
        return dCross1;
    }

    public int getdCross2() {
        return dCross2;
    }

    public int getdCross3() {
        return dCross3;
    }

    public int getdCross4() {
        return dCross4;
    }

    public int getdCross5() {
        return dCross5;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getPt() {
        return pt;
    }

    public void setPt(int pt) {
        this.pt = pt;
    }

    public int getCdf() {
        return cdf;
    }

    public void setCdf(int cdf) {
        this.cdf = cdf;
    }

    public int getRt() {
        return rt;
    }

    public void setRt(int rt) {
        this.rt = rt;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getLb() {
        return lb;
    }

    public void setLb(int lb) {
        this.lb = lb;
    }

    public int getRmp() {
        return rmp;
    }

    public void setRmp(int rmp) {
        this.rmp = rmp;
    }

    public int getMt() {
        return mt;
    }

    public void setMt(int mt) {
        this.mt = mt;
    }

    public int getDb() {
        return db;
    }

    public void setDb(int db) {
        this.db = db;
    }

    public int getRw() {
        return rw;
    }

    public void setRw(int rw) {
        this.rw = rw;
    }

    public int getHumanYes() {
        return humanYes;
    }

    public void setHuman(int human) {
        this.humanYes = human;
    }
    public int getHumanNo() {
        return humanNo;
    }

    public void setHumanNo(int human) {
        this.humanNo = human;
    }
}
