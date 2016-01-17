package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by tom on 1/16/16.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    private static String DB_name = "strongholdDB";
    private static String DB_Table = "strongholdData";
    private static int DB_VERSION = 1;

    private static String KEY_TEAM = "teamNum";
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
    private static String KEY_BREACH = "roboBreach";
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
                              KEY_BREACH + " INTEGER," +
                              KEY_CAPTURE + " INTEGER," +
                              KEY_RAMP + " INTEGER," +
                              KEY_D1 + " TEXT," +
                              KEY_D2 + " TEXT" +
                              KEY_D3 + " TEXT," +
                              KEY_D4 + " TEXT" +
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
                              KEY_NOTES + " TEXT" +
                              ")";
        db.execSQL(CREATE_TEAM);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_Table);
        onCreate(db);
    }
    public void addData(Stronghold strong){
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
        values.put(KEY_BREACH, strong.getBreach());
        values.put(KEY_CAPTURE, strong.getCapture());
        values.put(KEY_RAMP, strong.getRamp());
        values.put(KEY_D1, strong.getD1());
        values.put(KEY_D2, strong.getD2());
        values.put(KEY_D3, strong.getD3());
        values.put(KEY_D4, strong.getD4());
        values.put(KEY_DC1, strong.getdCross1());
        values.put(KEY_DC2, strong.getdCross2());
        values.put(KEY_DC3, strong.getdCross3());
        values.put(KEY_DC4, strong.getdCross4());
        values.put(KEY_DC5, strong.getdCross5());
        values.put(KEY_DW1, strong.getdWeak1());
        values.put(KEY_DW2, strong.getdWeak2());
        values.put(KEY_DW3, strong.getdWeak3());
        values.put(KEY_DW4, strong.getdWeak4());
        values.put(KEY_DW4, strong.getdWeak5());
        values.put(KEY_NOTES, strong.getNotes());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(DB_Table, null, values);
        db.close();
    }
    public ArrayList<Stronghold> getAllTeams(){
        ArrayList<Stronghold> list = new ArrayList<Stronghold>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + DB_Table;
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Stronghold tmp = new Stronghold();
                tmp.setTeamNum(cursor.getInt(0));
                tmp.setMatchNum(cursor.getInt(1));
                tmp.setAlliance(cursor.getInt(2));
                tmp.setAutoDef(cursor.getInt(3));
                tmp.setAutoHigh(cursor.getInt(4));
                tmp.setAutoLow(cursor.getInt(5));
                tmp.setStartingPos(cursor.getString(6));
                tmp.setAutoCross(cursor.getInt(7));
                tmp.setHighGoal(cursor.getInt(8));
                tmp.setLowGoal(cursor.getInt(9));
                tmp.setScale(cursor.getInt(10));
                tmp.setBreach(cursor.getInt(11));
                tmp.setCapture(cursor.getInt(12));
                tmp.setRamp(cursor.getInt(13));
                tmp.setD1(cursor.getString(14));
                tmp.setD2(cursor.getString(15));
                tmp.setD3(cursor.getString(16));
                tmp.setD4(cursor.getString(17));
                tmp.setD5(cursor.getString(18));
                tmp.setdCross1(cursor.getInt(19));
                tmp.setdCross2(cursor.getInt(20));
                tmp.setdCross3(cursor.getInt(21));
                tmp.setdCross4(cursor.getInt(22));
                tmp.setdCross5(cursor.getInt(23));
                tmp.setdWeak1(cursor.getInt(24));
                tmp.setdWeak2(cursor.getInt(25));
                tmp.setdWeak3(cursor.getInt(26));
                tmp.setdWeak4(cursor.getInt(27));
                tmp.setdWeak5(cursor.getInt(28));
                tmp.setNotes(cursor.getString(29));
                list.add(tmp);

            }while(cursor.moveToNext());
        }
        db.close();
        return list;
    }
}
