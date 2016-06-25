package joneslee.com.library.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Description:Config util, save isn't first launch app
 *
 * @author lizhenhua2003@gmail.com (Jones.Lee)
 * @date 16/6/25 13:17
 */
public class SharedPreferenceUtil {
    private static final String SHARED_PREFS = "com.boot.pager";
    private static final String HAS_LAUNCH = "has_first_launch";

    private static SharedPreferences getSharedPrefs(Context context) {
        return context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
    }

    public static boolean hasLaunchPreferences(Context context) {
        return getSharedPrefs(context).getBoolean(HAS_LAUNCH, false);
    }

    private static void updatePreferences(Context context, boolean flag) {
        getSharedPrefs(context).edit().putBoolean(HAS_LAUNCH, flag).commit();
    }

    public static void finishPreferences(Context context) {
        updatePreferences(context, true);
    }



}
