package uk.ac.tees.aad.w9528614;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private Activity mCurrentActivity;
    private Toast mOldToast;
    private Handler mHandler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    public Activity setActivty(Activity activity){
       return mCurrentActivity= activity;

    }


    public void showToast(final String message) {
        if (message != null)
            if (getMainLooper() == Looper.myLooper()) {
                if (null != mOldToast) {
                    mOldToast.cancel();
                }

                if (message.contains("<html>")) {
                    LayoutInflater li = mCurrentActivity.getLayoutInflater();

                    //Getting the View object as defined in the customtoast.xml file
                  //  View layout = li.inflate(R.layout.custom_toast, null);
                    /*WebView webView = layout.findViewById(R.id.webView);

                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.getSettings().setBuiltInZoomControls(false);
                    webView.getSettings().setLoadWithOverviewMode(true);
                    webView.getSettings().setLoadsImagesAutomatically(true);
                    webView.setBackgroundColor(0);
                    //webView.getSettings().setUseWideViewPort(true);
                    webView.setWebChromeClient(new WebChromeClient());

                    webView.loadDataWithBaseURL(null, message, null, "UTF-8", null);
                    //webView.loadData(message,"text/html","UTF-8");*/
                    //Creating the Toast object
                    mOldToast = new Toast(mCurrentActivity);
                   // mOldToast.setView(layout);
                   // mOldToast.setDuration(3000);
                    //   mOldToast.setView(layout);//setting the vie
                } else {
                    mOldToast = Toast.makeText(this, Html.fromHtml(message), Toast.LENGTH_LONG);
                    View toastView = mOldToast.getView(); //This'll return the default View of the Toast.
                    Typeface regular = Typeface.createFromAsset(this.getAssets(), "fonts/if_std_reg.ttf");
                    TextView toastMessage = toastView.findViewById(android.R.id.message);
                    toastMessage.setTypeface(regular);
                    //Spanned spanned = Html.fromHtml(message, this, null);
                    toastMessage.setText(Html.fromHtml(message));
                }
                mOldToast.setGravity(Gravity.CENTER, 0, 0);
                mOldToast.show();
            } else {
                mHandler.post(() -> showToast(message));
            }
    }
}
