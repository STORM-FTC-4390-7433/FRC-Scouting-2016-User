package fragments;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragments.AutoFragment;
import fragments.SubmitFragment;
import fragments.TeleFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                AutoFragment fragment1 = new AutoFragment();
                return fragment1;
            case 1:
                TeleFragment fragment2 = new TeleFragment();
                return fragment2;
            case 2:
                DefenseFragment fragment3 = new DefenseFragment();
                return fragment3;
            case 3:
                SubmitFragment fragment4 = new SubmitFragment();
                return fragment4;
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Auto";
            case 1:
                return "Tele";
            case 2:
                return "Defense";
            case 3:
                return "Submit";
        }
        return null;
    }
}