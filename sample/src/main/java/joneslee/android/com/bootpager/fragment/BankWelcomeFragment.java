package joneslee.android.com.bootpager.fragment;

import joneslee.android.com.bootpager.R;
import joneslee.com.library.fragment.BaseFragment;

/**
 * Description:
 *
 * @author lizhenhua2003@gmail.com (Jones.Lee)
 * @date 16/6/25 22:19
 */
public class BankWelcomeFragment extends BaseWelcomeFragment {
  public static BaseFragment newInstance() {
    return new BankWelcomeFragment();
  }

  @Override
  public int getBackGroundColor() {
    return R.color.green_background;
  }

  @Override
  public int getImageIconRes() {
    return R.mipmap.banks;
  }

  @Override
  public String getTitleStr() {
    return getResources().getString(R.string.bank_title);
  }

  @Override
  public String getRemarkContent() {
    return getResources().getString(R.string.bank_remark);
  }
}
