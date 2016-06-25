package joneslee.com.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import joneslee.com.library.R;

/**
 * Description:
 *
 * @author lizhenhua2003@gmail.com (Jones.Lee)
 * @date 16/6/25 13:18
 */
public class ViewPagerIndicator extends View implements ViewPager.OnPageChangeListener {
  private static final float SPACE_WIDTH = 20f;
  private static final int DEFAULT_OTHER_COLOR = 0x22000000;
  private static final int DEFAULT_CURRENT_COLOR = 0x99ffffff;
  private int mCountIndex = 0;
  private int mOtherColor = DEFAULT_OTHER_COLOR;
  private int mCurrentColor = DEFAULT_CURRENT_COLOR;
  private float mPadding = SPACE_WIDTH;
  private float mCircleSize = 8f;
  private float mCenterX;
  private float mCenterY;

  // Current change offset relative to startX
  private float mCurrentChangeX = 0f;
  private float mStartX = 0f;
  private Paint mPaint;

  public ViewPagerIndicator(Context context) {
    this(context, null, 0);
  }

  public ViewPagerIndicator(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public ViewPagerIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    TypedArray a =
        context.obtainStyledAttributes(attrs, R.styleable.ViewPagerIndicator, defStyleAttr, 0);

    mOtherColor = a.getColor(R.styleable.ViewPagerIndicator_indicatorColor, DEFAULT_OTHER_COLOR);
    mCurrentColor =
        a.getColor(R.styleable.ViewPagerIndicator_currentPageColor, DEFAULT_CURRENT_COLOR);
    init(context);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    mCenterX = getMeasuredWidth() / 2;
    mCenterY = getMeasuredHeight() / 2;
    mStartX = getFirstCoordinateX(mCenterX);
    mCurrentChangeX = mStartX;
  }

  private void init(Context context) {
    mPaint = new Paint();
    mPaint.setAntiAlias(true);
  }

  public void setCountIndex(int countIndex) {
    mCountIndex = countIndex;
    invalidate();
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    mPaint.setColor(mOtherColor);

    for (int i = 0; i < mCountIndex; i++) {
      canvas.drawCircle(mStartX + i * (mPadding + 2 * mCircleSize), mCenterY, mCircleSize, mPaint);
    }

    mPaint.setColor(mCurrentColor);
    canvas.drawCircle(mCurrentChangeX, mCenterY, mCircleSize, mPaint);
  }

  private float getFirstCoordinateX(float centerX) {
    boolean isOddNum = mCountIndex % 2 == 0;
    int offsetIndex = mCountIndex / 2;
    float offsetX = offsetIndex * mPadding + mCircleSize * offsetIndex * 2;
    if (isOddNum) {
      offsetX += mCircleSize + mPadding / 2;
    }
    return centerX - offsetX;
  }


  /**
   * ViewPager OnPageChangeListener methods
   */
  @Override
  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    if (position < mCountIndex - 1) {
      mCurrentChangeX =
          mStartX + position * (mPadding + 2 * mCircleSize) + positionOffset
              * (mPadding + 2 * mCircleSize);
      invalidate();
    }
  }

  @Override
  public void onPageSelected(int position) {}

  @Override
  public void onPageScrollStateChanged(int state) {

  }
}
