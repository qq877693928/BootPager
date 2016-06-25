package joneslee.android.com.bootpager;

import java.util.List;

import joneslee.android.com.bootpager.fragment.BankWelcomeFragment;
import joneslee.android.com.bootpager.fragment.HotelWelcomeFragment;
import joneslee.android.com.bootpager.fragment.StoreWelcomeFragment;
import joneslee.com.library.activity.BasePagerActivity;
import joneslee.com.library.fragment.BaseFragment;

/**
 * Description:
 *
 * @author lizhenhua2003@gmail.com (Jones.Lee)
 * @date 16/6/25 21:55
 */
public class WelcomeActivity extends BasePagerActivity {
    @Override
    protected void getFragmentList(List<BaseFragment> pagerList) {
        pagerList.add(HotelWelcomeFragment.newInstance());
        pagerList.add(BankWelcomeFragment.newInstance());
        pagerList.add(StoreWelcomeFragment.newInstance());
    }
}
