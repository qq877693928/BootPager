package joneslee.com.library.adapter;

import android.support.v4.app.FragmentManager;

import joneslee.com.library.fragment.BaseFragment;

/**
 * Description:
 *
 * @author lizhenhua9@wanda.cn (lzh)
 * @date 16/6/20 20:06
 */
public class BasePagerAdapter extends BaseAdapter<BaseFragment> {
    public BasePagerAdapter(FragmentManager fm) {
        super(fm);
    }
}
