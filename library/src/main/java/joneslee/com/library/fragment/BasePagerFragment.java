package joneslee.com.library.fragment;

import android.os.Bundle;
import android.view.View;

/**
 * Description:
 *
 * @author lizhenhua2003@gmail.com (Jones.Lee)
 * @date 16/6/25 13:30
 */
public abstract class BasePagerFragment extends BaseFragment {
    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    protected void onInflated(View contentView, Bundle savedInstanceState) {

    }
}
