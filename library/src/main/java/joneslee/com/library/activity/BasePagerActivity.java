package joneslee.com.library.activity;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import joneslee.com.library.R;
import joneslee.com.library.adapter.BasePagerAdapter;
import joneslee.com.library.fragment.BaseFragment;
import joneslee.com.library.util.SharedPreferenceUtil;
import joneslee.com.library.view.ViewPagerIndicator;

/**
 * Description:
 *
 * @author lizhenhua2003@gmail.com (Jones.Lee)
 * @date 16/6/25 19:21
 */
public abstract class BasePagerActivity extends AppCompatActivity
    implements ViewPager.OnPageChangeListener {

  private List<BaseFragment> mPagerList = new ArrayList<>();
  private ViewPager mViewPager;
  private View mBackGround;
  private BasePagerAdapter mPagerAdapter;
  private ViewPagerIndicator mViewPagerIndicator;
  private View mRoot;

  private View mNextBtn;
  private View mSkipBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResId());

    // init view pager data
    mPagerList.clear();
    getFragmentList(mPagerList);

    onInflated();
    mViewPager.addOnPageChangeListener(this);
    mViewPager.addOnPageChangeListener(mViewPagerIndicator);
    if (getPagerByIndex(0) != null) {
      mBackGround.setBackgroundColor(getPagerByIndex(0).getBackGroundColor());
    }
    mPagerAdapter = getFragmentAdapter(getSupportFragmentManager());
    mPagerAdapter.isSwipeToFade(isSwipeToFade());
    mPagerAdapter.setData(mPagerList);
    mViewPager.setAdapter(mPagerAdapter);

    mViewPagerIndicator.setCountIndex(mPagerList.size());
    
    mSkipBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finishPagerActivity();
      }
    });

    mNextBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if(mViewPager != null) {
          mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
        }
      }
    });
  }

  protected void onInflated() {
    mBackGround = findViewById(R.id.background_layout);
    mViewPager = (ViewPager) findViewById(R.id.content_view_pager);
    mSkipBtn = findViewById(R.id.skip_view);
    mNextBtn = findViewById(R.id.next_view);
    mViewPagerIndicator = (ViewPagerIndicator) findViewById(R.id.content_pager_indicator);
    mRoot = findViewById(R.id.content_root);
  }

  protected int getLayoutResId() {
    return R.layout.activity_welcome_pager;
  }

  @Override
  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    if (position < mPagerList.size()) {
      ArgbEvaluator argbEvaluator = new ArgbEvaluator();
      int evaluate = (Integer) argbEvaluator.evaluate(positionOffset,
          getResources().getColor(getPagerByIndex(position).getBackGroundColor()),
          getResources().getColor(getPagerByIndex(Math.min((position + 1), mPagerList.size() - 1))
              .getBackGroundColor()));
      mBackGround.setBackgroundColor(evaluate);
    }
    if (isSwipeToFade()) {
      if (position == mPagerList.size() - 1) {
        mRoot.setAlpha(1 - positionOffset);
      }
    }
    if (getPagerByIndex(position) != null) {
      getPagerByIndex(position).onPageScrolled(positionOffset, positionOffsetPixels);
    }

    if (getPagerByIndex(position + 1) != null) {
      getPagerByIndex(position + 1).onPageScrolled(1.0f - positionOffset, positionOffsetPixels);
    }

    if (isSwipeToFade()) {
      if (position == mPagerList.size()) {
        finishPagerActivity();
      }
    }
  }

  private void finishPagerActivity() {
    SharedPreferenceUtil.finishPreferences(this);
    this.finish();
  }

  @Override
  public void onPageSelected(int position) {

  }

  @Override
  public void onPageScrollStateChanged(int state) {

  }

  protected BaseFragment getPagerByIndex(int position) {
    if (mPagerList == null || mPagerList.size() <= position) {
      return null;
    }
    return mPagerList.get(position);
  }

  protected abstract void getFragmentList(List<BaseFragment> pagerList);

  protected BasePagerAdapter getFragmentAdapter(FragmentManager fm) {
    return new BasePagerAdapter(fm);
  };

  /**
   * ViewPager isn't swipe to fade, default is true;
   *
   * @return
   */
  protected boolean isSwipeToFade() {
    return true;
  }

}
