package joneslee.com.library.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import joneslee.com.library.R;
import joneslee.com.library.listener.ViewPageScrollListener;

/**
 * Description:Base ViewPager's fragment, has background color
 *
 * @author lizhenhua2003@gmail.com (Jones.Lee)
 * @date 16/6/25 13:22
 */
public abstract class BaseFragment extends Fragment implements ViewPageScrollListener {
  protected View mContentView;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    mContentView = inflater.inflate(getLayoutResId(), container, false);
    return mContentView;
  }

  /**
   * return fragment background color
   *
   * @return
   */
  public int getBackGroundColor() {
    return R.color.default_background;
  }


  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    if (mContentView != null) {
      onInflated(mContentView, savedInstanceState);
    }
  }

  /**
   * return fragment layout xml res id
   *
   * @return layout res id
   */
  protected abstract int getLayoutResId();

  /**
   * init layout's view
   *
   * @param contentView
   * @param savedInstanceState
   */
  protected abstract void onInflated(View contentView, Bundle savedInstanceState);


  /**
   * fragment scrolling listener methods
   */
  @Override
  public void onPageScrolled(float positionOffset, int positionOffsetPixels) {

  }
}
