package fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import database.Stronghold;
import fragments.AutoFragment;
import fragments.SubmitFragment;
import fragments.TeleFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    Stronghold strong;
    public ViewPagerAdapter(FragmentManager fm, Stronghold strong) {
        super(fm);
        this.strong = strong;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                AutoFragment fragment1 = new AutoFragment();
                return fragment1;
            case 1:
                TeleFragment fragment2 = new TeleFragment();

                Bundle args = new Bundle();
                args.putString("D1", strong.getD1());
                args.putString("D2", strong.getD2());
                args.putString("D3", strong.getD3());
                args.putString("D4", strong.getD4());
                args.putString("D5", strong.getD5());

                fragment2.setArguments(args);
                return fragment2;
            case 2:
                SubmitFragment fragment3 = new SubmitFragment();
                return fragment3;
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Auto";
            case 1:
                return "Tele";
            case 2:
                return "Submit";
        }
        return null;
    }
}