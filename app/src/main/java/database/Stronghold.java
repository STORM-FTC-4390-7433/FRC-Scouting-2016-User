package database;


public class Stronghold {
    private int teamNum = 0;
    private int matchNum = 0;
    private int alliance = 0;
    private int autoHigh = 0;
    private int autoLow = 0;
    private int autoCross = 0;


    private int scale = 0;
    private int breach = 0;
    private int capture = 0;
    private String startingPos = "", d1 = "", d2 = "", d3 = "", d4 = "", d5 = "",
            dCross1 = "", dCross2 = "", dCross3 = "", dCross4 = "", dCross5 = "", dWeak1 = "", dWeak2 = "", dWeak3 = "", dWeak4 = "", dWeak5 = "";

    public Stronghold(int teamNum, int matchNum, int alliance, int autoHigh, int autoLow, int scale, int breach, int capture, String startingPos, String d1, String d2, String d3, String d4, String d5, String dCross1, String dCross2, String dCross3, String dCross4, String dCross5, String dWeak1, String dWeak2, String dWeak3, String dWeak4, String dWeak5) {
        this.teamNum = teamNum;
        this.matchNum = matchNum;
        this.alliance = alliance;
        this.autoHigh = autoHigh;
        this.autoLow = autoLow;
        this.scale = scale;
        this.breach = breach;
        this.capture = capture;
        this.startingPos = startingPos;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.d4 = d4;
        this.d5 = d5;
        this.dCross1 = dCross1;
        this.dCross2 = dCross2;
        this.dCross3 = dCross3;
        this.dCross4 = dCross4;
        this.dCross5 = dCross5;
        this.dWeak1 = dWeak1;
        this.dWeak2 = dWeak2;
        this.dWeak3 = dWeak3;

        this.dWeak4 = dWeak4;
        this.dWeak5 = dWeak5;
    }

    public Stronghold(int teamNum, int matchNum, int alliance) {
        this.teamNum = teamNum;
        this.matchNum = matchNum;
        this.alliance = alliance;
    }
    public int getAutoCross() {
        return autoCross;
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

    public void setBreach(int breach) {
        this.breach = breach;
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

    public void setdCross1(String dCross1) {
        this.dCross1 = dCross1;
    }

    public void setdCross2(String dCross2) {
        this.dCross2 = dCross2;
    }

    public void setdCross3(String dCross3) {
        this.dCross3 = dCross3;
    }

    public void setdCross4(String dCross4) {
        this.dCross4 = dCross4;
    }

    public void setdCross5(String dCross5) {
        this.dCross5 = dCross5;
    }

    public void setdWeak1(String dWeak1) {
        this.dWeak1 = dWeak1;
    }

    public void setdWeak2(String dWeak2) {
        this.dWeak2 = dWeak2;
    }

    public void setdWeak3(String dWeak3) {
        this.dWeak3 = dWeak3;
    }

    public void setdWeak4(String dWeak4) {
        this.dWeak4 = dWeak4;
    }

    public void setdWeak5(String dWeak5) {
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

    public int getBreach() {
        return breach;
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

    public String getdCross1() {
        return dCross1;
    }

    public String getdCross2() {
        return dCross2;
    }

    public String getdCross3() {
        return dCross3;
    }

    public String getdCross4() {
        return dCross4;
    }

    public String getdCross5() {
        return dCross5;
    }

    public String getdWeak1() {
        return dWeak1;
    }

    public String getdWeak2() {
        return dWeak2;
    }

    public String getdWeak3() {
        return dWeak3;
    }

    public String getdWeak4() {
        return dWeak4;
    }

    public String getdWeak5() {
        return dWeak5;
    }
}
