package joneslee.android.com.bootpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import joneslee.com.library.util.SharedPreferenceUtil;

public class MainActivity extends AppCompatActivity {
  private Button mNormalBtn;
  private Button mPallaxsBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mNormalBtn = (Button) findViewById(R.id.normal_btn);
    mPallaxsBtn = (Button) findViewById(R.id.pallaxs_btn);

    mPallaxsBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startBootActivity();
      }
    });
    if (!SharedPreferenceUtil.hasLaunchPreferences(this)) {
      startBootActivity();
    }
  }

  private void startBootActivity() {
    Intent intent = new Intent();
    intent.setClass(this, WelcomeActivity.class);
    startActivityForResult(intent, RESULT_OK);
  }
}
