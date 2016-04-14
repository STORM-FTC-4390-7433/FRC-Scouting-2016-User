package org.lrhsd.storm.user16;
import android.content.Context;
import android.content.res.AssetManager;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * <p>Class to validate team numbers</p>
 */
public class TeamNumbers {

    private static String total;

    /**
     * Constructor to build
     * @param context - Activity context
     */
    public TeamNumbers(Context context) {

        try {

            AssetManager manager = context.getAssets();
            InputStream input = manager.open("team_numbers.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            total = reader.readLine();
            reader.close();

        } catch (IOException ex) {

        }

    }

    /**
     * Checks if team exists
     * @param team - integer of a team number
     * @return true if team number exists, false if it doesn't
     */
    public static boolean isATeamNumber(int team) {
        String teamNum = "," + team + ",";

        if (total.contains(teamNum))
            return true;
        else
            return false;

    }

}
