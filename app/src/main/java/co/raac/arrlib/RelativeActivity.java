package co.raac.arrlib;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import co.raac.testlib.myClasses.CodeExecute;

public class RelativeActivity extends Activity {
    private static final String TAG = "RelativeActivity";
    ViewGroup viewGroup;
    View topBanner;
    View bottonBanner;
    Dialog popup;
    private View topOfScreenBanner;
    private ViewGroup fisrtChild;
    private View bottomOfScreenBanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
    }
    @Override
    public void onBackPressed() {
        try {
            if (bottonBanner != null) {
                viewGroup.removeView(bottonBanner);
            }
            if (topBanner != null) {
                viewGroup.removeView(topBanner);
            }
            if (topOfScreenBanner != null) {
                viewGroup.removeView(topOfScreenBanner);
            }
            if (bottomOfScreenBanner!= null) {
                viewGroup.removeView(bottomOfScreenBanner);
            }
            if (popup != null) {
                popup.cancel();
                popup.dismiss();
            }
        } catch (Exception ex) {
            Log.d(TAG, "onBackPressed: " + ex.getMessage());
        }
        Toast.makeText(this, "Dispose banner", Toast.LENGTH_LONG).show();
        super.onBackPressed();

    }

    public void btnClick(View v) {
        try {
            Button btn = (Button) v;
            if (btn.getId() == R.id.topbanner) {
                toggleTopBanner(v);
            } else if (btn.getId() == R.id.bottombanner) {
                toggleBottomBanner(v);
            } else if (btn.getId() == R.id.popup) {
                showPopup(v);
            } else if (btn.getId() == R.id.topofscreenbanner) {
                toggleTopOfScreenBanner(v);
            }
            else if (btn.getId() == R.id.bottomofscreenbanner) {
                toggleBottomOfScreenBanner(v);
            }
        }
        catch (Exception ex){
            Log.d(TAG, "btnClick: "+ex.getMessage());
        }
    }

    private void toggleBottomOfScreenBanner(View v) {
        bottomOfScreenBanner = CodeExecute.getBottomOfScreenBanner(this);
    }

    private void toggleTopBanner(View v) {
        // get top banner
        topBanner = CodeExecute.getTopBanner(this);
    }
    private void toggleTopOfScreenBanner(View v) {
        // get top banner
        topOfScreenBanner = CodeExecute.getTopOfScreenBanner(this);
    }
    private void toggleBottomBanner(View v) {
        // get bottom banner
        topBanner = CodeExecute.getBottomBanner(this);
    }
    private void showPopup(View v) {
        popup = CodeExecute.getPopupBanner(this);
        if (popup != null) {
            popup.show();
        }
    }
}
