package database;

/**
 * Stronghold data object class used
 */
public class Stronghold {
    //stronghold variables
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
    /**
     * <p>Empty Constructor</p>
     */
    public Stronghold(){}
    /**
     * <p>Used in the main activity for the intial object</p>
     * @param teamNum - team number
     * @param matchNum - match number
     * @param alliance - alliance(1 for red, 0 for blue)
     */
    public Stronghold(int teamNum, int matchNum, int alliance) {
        this.teamNum = teamNum;
        this.matchNum = matchNum;
        this.alliance = alliance;
    }

    /**
     * <p>Getter for the autoDef</p>
     * @return 1 if def was reached, 0 if they were not reached at all or if they were crossed
     */
    public int getAutoDef() {
        return autoDef;
    }

    /**
     * <p>sets autoDef value</p>
     * @param autoDef - new autoDef value
     */
    public void setAutoDef(int autoDef) {
        this.autoDef = autoDef;
    }

    /**
     * <p>Getter for the autoCross</p>
     * @return 1 if def was crossed, 0 if they were not crossed, meaning they were reached or not even that
     */
    public int getAutoCross() {
        return autoCross;
    }

    /**
     * <p>Getter for the high goal score</p>
     * @return high goal score
     */
    public int getHighGoal() {
        return highGoal;
    }

    /**
     * <p>Sets high goal score</p>
     * @param highGoal - new high goal value
     */
    public void setHighGoal(int highGoal) {
        this.highGoal = highGoal;
    }

    /**
     * <p>Getter for low goal score</p>
     * @return low goal score
     */
    public int getLowGoal() {
        return lowGoal;
    }

    /**
     * <p>Sets the low goal score</p>
     * @param lowGoal - new low goal score
     */
    public void setLowGoal(int lowGoal) {
        this.lowGoal = lowGoal;
    }

    /**
     * <p>Sets auto cross score</p>
     * @param autoCross - 1 if crossed, 0 if not
     */
    public void setAutoCross(int autoCross) {
        this.autoCross = autoCross;
    }

    /**
     * <p>Sets auto high goal score</p>
     * @param autoHigh - new auto high goal score
     */
    public void setAutoHigh(int autoHigh) {
        this.autoHigh = autoHigh;
    }
    /**
     * <p>Sets auto low goal score</p>
     * @param autoLow - new auto low goal score
     */
    public void setAutoLow(int autoLow) {
        this.autoLow = autoLow;
    }

    /**
     * Set new scale score
     * @param scale - new scale score. 1 if scaled, 0 if not
     */
    public void setScale(int scale) {
        this.scale = scale;
    }

    /**
     * Set new capture score
     * @param capture - new capture score. 1 if captured, 0 if not
     */
    public void setCapture(int capture) {
        this.capture = capture;
    }

    /**
     * sets the starting position of the robot
     * @param startingPos - robot starting position
     */
    public void setStartingPos(String startingPos) {
        this.startingPos = startingPos;
    }

    /**
     * sets the first defense
     * @param d1 - defense 1
     */
    public void setD1(String d1) {
        this.d1 = d1;
    }
    /**
     * sets the second defense
     * @param d2 - defense 2
     */
    public void setD2(String d2) {
        this.d2 = d2;
    }
    /**
     * sets the third defense
     * @param d3 - defense 3
     */
    public void setD3(String d3) {
        this.d3 = d3;
    }
    /**
     * sets the fourth defense
     * @param d4 - defense 4
     */
    public void setD4(String d4) {
        this.d4 = d4;
    }
    /**
     * sets the fifth defense
     * @param d5 - defense 5
     */
    public void setD5(String d5) {
        this.d5 = d5;
    }

    /**
     * sets the team number
     * @param teamNum - the team number
     */
    public void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }

    /**
     * sets the match number
     * @param matchNum - the match number
     */
    public void setMatchNum(int matchNum) {
        this.matchNum = matchNum;
    }

    /**
     * sets alliance
     * @param alliance alliance value - 1 if red, 0 if blue
     */
    public void setAlliance(int alliance) {
        this.alliance = alliance;
    }

    /**
     * returns the team number
     * @return team number
     */
    public int getTeamNum() {
        return teamNum;
    }

    /**
     * returns the match number
     * @return match number
     */
    public int getMatchNum() {
        return matchNum;
    }

    /**
     * returns the alliance number
     * @return alliance number
     */
    public int getAlliance() {
        return alliance;
    }

    /**
     * returns the auto high score
     * @return auto high score
     */
    public int getAutoHigh() {
        return autoHigh;
    }

    /**
     * returns auto low score
     * @return auto low score
     */
    public int getAutoLow() {
        return autoLow;
    }

    /**
     * returns scale score
     * @return 1 if scaled, 0 if not
     */
    public int getScale() {
        return scale;
    }

    /**
     * returns capture score
     * @return 1 if captured, 0 if not
     */
    public int getCapture() {
        return capture;
    }

    /**
     * returns the starting position
     * @return starting defense position
     */
    public String getStartingPos() {
        return startingPos;
    }

    /**
     * returns the first defense
     * @return first defense
     */
    public String getD1() {
        return d1;
    }
    /**
     * returns the second defense
     * @return second defense
     */
    public String getD2() {
        return d2;
    }
    /**
     * returns the third defense
     * @return third defense
     */
    public String getD3() {
        return d3;
    }
    /**
     * returns the fourth defense
     * @return fourth defense
     */
    public String getD4() {
        return d4;
    }

    /**
     * returns the fifth defense
     * @return fifth defense
     */
    public String getD5() {
        return d5;
    }

    /**
     * returns ramp score
     * @return 1 if ramp is crossed, 0 if not
     */
    public int getRamp() {
        return ramp;
    }

    /**
     * sets ramp score
     * @param ramp 1 if ramp is crossed, 0 if not
     */
    public void setRamp(int ramp) {
        this.ramp = ramp;
    }

    /**
     * returns the notes
     * @return qualitative notes on the match
     */
    public String getNotes() {
        return notes;
    }

    /**
     * sets number of times defense 1 was crossed
     * @param dCross1 - number of times d1 was crossed
     */
    public void setdCross1(int dCross1) {
        this.dCross1 = dCross1;
    }

    /**
     * sets the number of times defense 2 was crossed
     * @param dCross2 - number of times d2 was crossed
     */
    public void setdCross2(int dCross2) {
        this.dCross2 = dCross2;
    }

    /**
     * sets the number of times defense 3 was crossed
     * @param dCross3 - number of times d3 was crossed
     */
    public void setdCross3(int dCross3) {
        this.dCross3 = dCross3;
    }

    /**
     * sets the number of times defense 4 was crossed
     * @param dCross4 - number of times d4 was crossed
     */
    public void setdCross4(int dCross4) {
        this.dCross4 = dCross4;
    }

    /**
     * sets the number of times defense 5 was crossed
     * @param dCross5 - number of times d5 was crossed
     */
    public void setdCross5(int dCross5) {
        this.dCross5 = dCross5;
    }

    /**
     * returns the number of times defense 1 was crossed
     * @return number of times d1 was crossed
     */
    public int getdCross1() {
        return dCross1;
    }

    /**
     * returns the number of times defense 2 was crossed
     * @return number of times d2 was crossed
     */
    public int getdCross2() {
        return dCross2;
    }

    /**
     * returns the number of times defense 3 was crossed
     * @return number of times d3 was crossed
     */
    public int getdCross3() {
        return dCross3;
    }

    /**
     * returns the number of times defense 4 was crossed
     * @return number of times d4 was crossed
     */
    public int getdCross4() {
        return dCross4;
    }

    /**
     * returns the number of times defense 5 was crossed
     * @return number of times d5 was crossed
     */
    public int getdCross5() {
        return dCross5;
    }

    /**
     * sets the notes
     * @param notes - qualitative notes on the match
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * returns the number of times portcullius was crossed
     * @return number of times portcullius was crossed
     */
    public int getPt() {
        return pt;
    }

    /**
     * sets the number of times portcullius was crossed
     * @param pt - number of times portcullius was crossed
     */
    public void setPt(int pt) {
        this.pt = pt;
    }

    /**
     * returns the number of times the cheval de frise was crossed
     * @return the number of times the cheval de frise was crossed
     */
    public int getCdf() {
        return cdf;
    }

    /**
     * sets the number of times the cheval de frise was crossed
     * @param cdf - the number of times the cheval de frise was crossed
     */
    public void setCdf(int cdf) {
        this.cdf = cdf;
    }

    /**
     * returns the number of times the rough terrain was crossed
     * @return the number of times the rough terrain was crossed
     */
    public int getRt() {
        return rt;
    }

    /**
     * sets the number of times the rough terrain was crossed
     * @param rt - the number of times the rough terrain was crossed
     */
    public void setRt(int rt) {
        this.rt = rt;
    }

    /**
     * returns the number of times the sally port was crossed
     * @return the number of times the sally port was crossed
     */
    public int getSp() {
        return sp;
    }

    /**
     * sets the number of times the sally port was crossed
     * @param sp - the number of times the sally port was crossed
     */
    public void setSp(int sp) {
        this.sp = sp;
    }

    /**
     * returns the number of times the low bar was crossed
     * @return the number of times the low bar was crossed
     */
    public int getLb() {
        return lb;
    }

    /**
     * sets the number of times the low bar was crossed
     * @param lb - the number of times the low bar was crossed
     */
    public void setLb(int lb) {
        this.lb = lb;
    }

    /**
     * returns the number of times the ramparts was crossed
     * @return the number of times the ramparts was crossed
     */
    public int getRmp() {
        return rmp;
    }

    /**
     * sets the number of times the ramparts was crossed
     * @param rmp - the number of times the low bar was crossed
     */
    public void setRmp(int rmp) {
        this.rmp = rmp;
    }

    /**
     * returns the number of times the moat was crossed
     * @return the number of times the moat was crossed
     */
    public int getMt() {
        return mt;
    }

    /**
     * sets the number of times the moat was crossed
     * @param mt - the number of times the low bar was crossed
     */
    public void setMt(int mt) {
        this.mt = mt;
    }

    /**
     * returns the number of times the drawbridge was crossed
     * @return the number of times the drawbridge was crossed
     */
    public int getDb() {
        return db;
    }

    /**
     * sets the number of times the drawbridge was crossed
     * @param db - the number of times the drawbridge was crossed
     */
    public void setDb(int db) {
        this.db = db;
    }

    /**
     * returns the number of times the rockwall was crossed
     * @return the number of times the rockwall was crossed
     */
    public int getRw() {
        return rw;
    }

    /**
     * sets the number of times the rockwall was crossed
     * @param rw - the number of times the rockwall was crossed
     */
    public void setRw(int rw) {
        this.rw = rw;
    }
}
