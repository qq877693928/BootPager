package joneslee.android.com.bootpager.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import joneslee.android.com.bootpager.R;
import joneslee.com.library.fragment.BaseFragment;

/**
 * Description:
 *
 * @author lizhenhua2003@gmail.com (Jones.Lee)
 * @date 16/6/25 22:02
 */
public abstract class BaseWelcomeFragment extends BaseFragment {

  private ImageView mIcon;
  private TextView mTitle;
  private TextView mRemark;
  protected static String TITLE = "title";
  protected static String REMARK = "remark";
  private float mOffsetTranslateDistance = -160f;
  private float mOffsetTextDistance = -100f;

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_title;
  }

  @Override
  protected void onInflated(View contentView, Bundle savedInstanceState) {
    mIcon = (ImageView) mContentView.findViewById(R.id.image);
    mTitle = (TextView) mContentView.findViewById(R.id.title);
    mRemark = (TextView) mContentView.findViewById(R.id.remark);

    mIcon.setImageResource(getImageIconRes());
    mTitle.setText(getTitleStr());
    mRemark.setText(getRemarkContent());
  }

  @Override
  public void onPageScrolled(float positionOffset, int positionOffsetPixels) {
    if (mIcon != null) {
      mIcon.setAlpha(1.0f - positionOffset);
      mIcon.setTranslationY((1.0f - positionOffset) * mOffsetTranslateDistance);
    }
    if (mTitle != null) {
      mTitle.setAlpha(1.0f - positionOffset);
      mTitle.setTranslationY((1.0f - positionOffset) * mOffsetTextDistance);
    }
    if (mRemark != null) {
      mRemark.setAlpha(1.0f - positionOffset);
      mRemark.setTranslationY((1.0f - positionOffset) * mOffsetTextDistance);
    }
  }

  public abstract int getImageIconRes();

  public abstract String getTitleStr();

  public abstract String getRemarkContent();
}
