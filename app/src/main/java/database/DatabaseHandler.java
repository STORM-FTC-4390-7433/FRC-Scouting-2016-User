package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {
    private static String DB_name = "strongholdDB";
    private static String DB_Table = "strongholdData";
    private static int DB_VERSION = 11;

    private static String KEY_TEAM ="teamNum";
    private static String KEY_MATCH = "matchNum";
    private static String KEY_Alliance = "alliance";
    private static String KEY_AUTODEF = "autoDef";
    private static String KEY_AUTOHIGH = "autoHigh";
    private static String KEY_AUTOLOW = "autoLow";
    private static String KEY_STARTPOS = "startingPos";
    private static String KEY_AUTOCROSS = "autoCross";
    private static String KEY_HIGHGOAL = "highGoal";
    private static String KEY_LOWGOAL = "lowGoal";
    private static String KEY_SCALE = "roboScale";
    private static String KEY_CAPTURE = "roboCap";
    private static String KEY_RAMP = "roboRamp";
    private static String KEY_D1 = "defOne";
    private static String KEY_D2 = "defTwo";
    private static String KEY_D3 = "defThree";
    private static String KEY_D4 = "defFour";
    private static String KEY_D5 = "defFive";
    private static String KEY_DC1 = "defCrossOne";
    private static String KEY_DC2 = "defCrossTwo";
    private static String KEY_DC3 = "defCrossThree";
    private static String KEY_DC4 = "defCrossFour";
    private static String KEY_DC5 = "defCrossFive";
    private static String KEY_DW1 = "defWeakOne";
    private static String KEY_DW2 = "defWeakTwo";
    private static String KEY_DW3 = "defWeakThree";
    private static String KEY_DW4 = "defWeakFour";
    private static String KEY_DW5 = "defWeakFive";
    private static String KEY_NOTES = "notes";
    private static String KEY_PT = "portcullis";
    private static String KEY_CDF = "cheval";
    private static String KEY_RMP = "ramparts";
    private static String KEY_MT = "moat";
    private static String KEY_DRB = "drawbridge";
    private static String KEY_SP = "sally";
    private static String KEY_RW = "rockwall";
    private static String KEY_RT = "roughtTerrain";
    private static String KEY_LB = "lowBar";
    private static String KEY_HUM = "human";
    private static String KEY_HUMNO = "humanNo";
    private static DatabaseHandler dbH = null;
    private Context ctx;

    public DatabaseHandler(Context context) {
        super(context, DB_name, null, DB_VERSION);
    }
    public static DatabaseHandler getInstance(Context context){
        if(dbH == null){
            dbH = new DatabaseHandler(context.getApplicationContext());
        }
        return dbH;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TEAM = "CREATE TABLE " + DB_Table + "(" +
                              KEY_TEAM + " INTEGER," +
                              KEY_MATCH + " INTEGER," +
                              KEY_Alliance + " INTEGER," +
                              KEY_AUTODEF + " INTEGER," +
                              KEY_AUTOHIGH + " INTEGER," +
                              KEY_AUTOLOW + " INTEGER," +
                              KEY_STARTPOS + " TEXT," +
                              KEY_AUTOCROSS + " INTEGER," +
                              KEY_HIGHGOAL + " INTEGER," +
                              KEY_LOWGOAL + " INTEGER," +
                              KEY_SCALE + " INTEGER," +
                              KEY_CAPTURE + " INTEGER," +
                              KEY_RAMP + " INTEGER," +
                              KEY_D1 + " TEXT," +
                              KEY_D2 + " TEXT," +
                              KEY_D3 + " TEXT," +
                              KEY_D4 + " TEXT," +
                              KEY_D5 + " TEXT," +
                              KEY_DC1 + " INTEGER," +
                              KEY_DC2 + " INTEGER," +
                              KEY_DC3 + " INTEGER," +
                              KEY_DC4 + " INTEGER," +
                              KEY_DC5 + " INTEGER," +
                              KEY_DW1 + " INTEGER," +
                              KEY_DW2 + " INTEGER," +
                              KEY_DW3 + " INTEGER," +
                              KEY_DW4 + " INTEGER," +
                              KEY_DW5 + " INTEGER," +
                              KEY_NOTES + " TEXT," +
                              KEY_PT + " INTEGER," +
                              KEY_CDF + " INTEGER," +
                              KEY_RMP + " INTEGER," +
                              KEY_MT + " INTEGER," +
                              KEY_DRB + " INTEGER," +
                              KEY_SP + " INTEGER," +
                              KEY_RW + " INTEGER," +
                              KEY_RT + " INTEGER," +
                              KEY_LB + " INTEGER," +
                              KEY_HUM + " INTEGER," +
                              KEY_HUMNO + " INTEGER" +
                              ")";
        db.execSQL(CREATE_TEAM);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_Table);
        onCreate(db);
    }
    public void clearTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_Table, null, null);
    }
    public ContentValues addData(Stronghold strong){
        ContentValues values = new ContentValues();
        values.put(KEY_TEAM, strong.getTeamNum());
        values.put(KEY_MATCH, strong.getMatchNum());
        values.put(KEY_Alliance, strong.getAlliance());
        values.put(KEY_AUTODEF, strong.getAutoDef());
        values.put(KEY_AUTOHIGH, strong.getAutoHigh());
        values.put(KEY_AUTOLOW, strong.getAutoLow());
        values.put(KEY_STARTPOS, strong.getStartingPos());
        values.put(KEY_AUTOCROSS, strong.getAutoCross());
        values.put(KEY_HIGHGOAL, strong.getHighGoal());
        values.put(KEY_LOWGOAL, strong.getLowGoal());
        values.put(KEY_SCALE, strong.getScale());
        values.put(KEY_CAPTURE, strong.getCapture());
        values.put(KEY_RAMP, strong.getRamp());
        values.put(KEY_D1, strong.getD1());
        values.put(KEY_D2, strong.getD2());
        values.put(KEY_D3, strong.getD3());
        values.put(KEY_D4, strong.getD4());
        values.put(KEY_D5, strong.getD5());
        values.put(KEY_DC1, strong.getdCross1());
        values.put(KEY_DC2, strong.getdCross2());
        values.put(KEY_DC3, strong.getdCross3());
        values.put(KEY_DC4, strong.getdCross4());
        values.put(KEY_DC5, strong.getdCross5());
        values.put(KEY_DW1, strong.getdWeak1());
        values.put(KEY_DW2, strong.getdWeak2());
        values.put(KEY_DW3, strong.getdWeak3());
        values.put(KEY_DW4, strong.getdWeak4());
        values.put(KEY_DW5, strong.getdWeak5());
        values.put(KEY_NOTES, strong.getNotes());
        values.put(KEY_PT, strong.getPt());
        values.put(KEY_CDF, strong.getCdf());
        values.put(KEY_RMP, strong.getRmp());
        values.put(KEY_MT, strong.getMt());
        values.put(KEY_DRB, strong.getDb());
        values.put(KEY_SP, strong.getSp());
        values.put(KEY_RW, strong.getRw());
        values.put(KEY_RT, strong.getRt());
        values.put(KEY_LB, strong.getLb());
        values.put(KEY_HUM, strong.getHumanYes());
        values.put(KEY_HUMNO, strong.getHumanNo());
        return values;

    }
    public void addAllData(Stronghold strong){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = addData(strong);
        db.insert(DB_Table, null, values);
        Log.d("DB", "Data added");
        db.close();
    }
    public List<Stronghold> getAllTeams(){
        List<Stronghold> list = new ArrayList<Stronghold>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + DB_Table;
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            do {
                Stronghold tmp = new Stronghold();
                tmp.setTeamNum(cursor.getInt(cursor.getColumnIndex(KEY_TEAM)));
                tmp.setMatchNum(cursor.getInt(cursor.getColumnIndex(KEY_MATCH)));
                tmp.setAlliance(cursor.getInt(cursor.getColumnIndex(KEY_Alliance)));
                tmp.setAutoDef(cursor.getInt(cursor.getColumnIndex(KEY_AUTODEF)));
                tmp.setAutoHigh(cursor.getInt(cursor.getColumnIndex(KEY_AUTOHIGH)));
                tmp.setAutoLow(cursor.getInt(cursor.getColumnIndex(KEY_AUTOLOW)));
                tmp.setStartingPos(cursor.getString(cursor.getColumnIndex(KEY_STARTPOS)));
                tmp.setAutoCross(cursor.getInt(cursor.getColumnIndex(KEY_AUTOCROSS)));
                tmp.setHighGoal(cursor.getInt(cursor.getColumnIndex(KEY_HIGHGOAL)));
                tmp.setLowGoal(cursor.getInt(cursor.getColumnIndex(KEY_LOWGOAL)));
                tmp.setScale(cursor.getInt(cursor.getColumnIndex(KEY_SCALE)));
                tmp.setCapture(cursor.getInt(cursor.getColumnIndex(KEY_CAPTURE)));
                tmp.setRamp(cursor.getInt(cursor.getColumnIndex(KEY_RAMP)));
                tmp.setD1(cursor.getString(cursor.getColumnIndex(KEY_D1)));
                tmp.setD2(cursor.getString(cursor.getColumnIndex(KEY_D2)));
                tmp.setD3(cursor.getString(cursor.getColumnIndex(KEY_D3)));
                tmp.setD4(cursor.getString(cursor.getColumnIndex(KEY_D4)));
                tmp.setD5(cursor.getString(cursor.getColumnIndex(KEY_D5)));
                tmp.setdCross1(cursor.getInt(cursor.getColumnIndex(KEY_DC1)));
                tmp.setdCross2(cursor.getInt(cursor.getColumnIndex(KEY_DC2)));
                tmp.setdCross3(cursor.getInt(cursor.getColumnIndex(KEY_DC3)));
                tmp.setdCross4(cursor.getInt(cursor.getColumnIndex(KEY_DC4)));
                tmp.setdCross5(cursor.getInt(cursor.getColumnIndex(KEY_DC5)));
                tmp.setdWeak1(cursor.getInt(cursor.getColumnIndex(KEY_DW1)));
                tmp.setdWeak2(cursor.getInt(cursor.getColumnIndex(KEY_DW2)));
                tmp.setdWeak3(cursor.getInt(cursor.getColumnIndex(KEY_DW3)));
                tmp.setdWeak4(cursor.getInt(cursor.getColumnIndex(KEY_DW4)));
                tmp.setdWeak5(cursor.getInt(cursor.getColumnIndex(KEY_DW5)));
                tmp.setNotes(cursor.getString(cursor.getColumnIndex(KEY_NOTES)));
                tmp.setPt(cursor.getInt(cursor.getColumnIndex(KEY_PT)));
                tmp.setCdf(cursor.getInt(cursor.getColumnIndex(KEY_CDF)));
                tmp.setRmp(cursor.getInt(cursor.getColumnIndex(KEY_RMP)));
                tmp.setMt(cursor.getInt(cursor.getColumnIndex(KEY_MT)));
                tmp.setDb(cursor.getInt(cursor.getColumnIndex(KEY_DRB)));
                tmp.setSp(cursor.getInt(cursor.getColumnIndex(KEY_SP)));
                tmp.setRw(cursor.getInt(cursor.getColumnIndex(KEY_RW)));
                tmp.setRt(cursor.getInt(cursor.getColumnIndex(KEY_RT)));
                tmp.setLb(cursor.getInt(cursor.getColumnIndex(KEY_LB)));
                tmp.setHuman(cursor.getInt(cursor.getColumnIndex(KEY_HUM)));
                tmp.setHumanNo(cursor.getInt(cursor.getColumnIndex(KEY_HUMNO)));
                list.add(tmp);

            } while (cursor.moveToNext());
        }
        return list;
    }
}
