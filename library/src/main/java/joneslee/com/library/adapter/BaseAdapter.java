package joneslee.com.library.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import joneslee.com.library.fragment.BaseFragment;

/**
 * Description:base viewPager's adapter
 *
 * @author lizhenhua2003@gmail.com (Jones.Lee)
 * @date 16/6/25 19:44
 */
public class BaseAdapter<T extends BaseFragment> extends FragmentPagerAdapter {
    protected List<T> mFragmentData;
    private boolean isSwipeToFade = true;

    public BaseAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setData(List<T> fragmentData) {
        this.mFragmentData = fragmentData;
        notifyDataSetChanged();
    }


    public List<T> getData() {
        return mFragmentData;
    }

    @Override
    public Fragment getItem(int position) {
        if (getCount() <= position) {
            return null;
        }
        if (position == mFragmentData.size()) {
            return new Fragment();
        } else {
            return mFragmentData.get(position);
        }
    }

    @Override
    public int getCount() {
        return mFragmentData == null ? 0 :
                (isSwipeToFade ? mFragmentData.size() + 1 : mFragmentData.size());
    }

    public void clear() {
        if (mFragmentData != null) {
            mFragmentData.clear();
        }
        notifyDataSetChanged();
    }

    public void isSwipeToFade(boolean swipeToFade) {
        isSwipeToFade = swipeToFade;
    }
}