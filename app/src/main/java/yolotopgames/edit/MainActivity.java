package yolotopgames.edit;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.os.Vibrator;
import android.support.v4.app.NavUtils;
import android.support.v4.print.PrintHelper;
import android.support.v4.view.ViewParentCompatICS;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends ActionBarActivity {
    public TextView Rollo;
    final Context context = this;
    private Bitmap bitmap;
    public ToggleButton coldfilter;
    public ToggleButton filtt;
    public Button buttono;
    public Button oran;
    public EditText mTxt;
    public ToggleButton buttol;
    public HorizontalScrollView Edto;
    public ImageView lolop;
    public RelativeLayout wf;
    public RelativeLayout cf;
    public HorizontalScrollView fil;
    public ToggleButton warmfilter;
    public EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        ActionBar actionBar = getSupportActionBar();

        lolop = (ImageView) findViewById(R.id.imur);

        // Get intent, action and MIME type


        setContentView(R.layout.activity_main);

        Rollo = (TextView) findViewById(R.id.Banan);
        buttol = (ToggleButton) findViewById(R.id.imageView2);
        wf = (RelativeLayout) findViewById(R.id.warm_filter);
        cf = (RelativeLayout) findViewById(R.id.cold_filter);
        coldfilter = (ToggleButton) findViewById(R.id.cld);
        warmfilter = (ToggleButton) findViewById(R.id.wrm);
        filtt = (ToggleButton) findViewById(R.id.coool);
        fil = (HorizontalScrollView) findViewById(R.id.filters);
        mTxt = (EditText) findViewById(R.id.mytxt);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Impact.ttf");
        Rollo.setTypeface(font);
        mTxt.setTypeface(font);
        Edto = (HorizontalScrollView) findViewById(R.id.textedit);
        Edto.setVisibility(View.GONE);
        oran = (Button) findViewById(R.id.org);
        Typeface fonto = Typeface.createFromAsset(getAssets(), "fonts/orange.ttf");
        oran.setTypeface(fonto);
        wf.setVisibility(View.GONE);
        cf.setVisibility(View.GONE);
        fil.setVisibility(View.GONE);

        mPasswordView = (EditText) findViewById(R.id.mytxt);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == 42 || actionId == EditorInfo.IME_NULL) {

                    Rollo.setText(mTxt.getText());
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mTxt.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ed, menu);
        return true;
    }


    private int PICK_IMAGE_REQUEST = 1;
    public ViewGroup vie;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {


            case R.id.shar:


                return true;

            case R.id.home:
                Vibrator voll = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                voll.vibrate(70);
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.share:
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(70);
                Intent intentsms = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + ""));
                intentsms.putExtra("sms_body", "Hi! Go download the app 'Edit' on Google Play! https://play.google.com/store/apps/details?id=yolotopgames.edit");
                startActivity(intentsms);
                return true;
            case R.id.new_game:
                Vibrator va = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

// Vibrate for 400 milliseconds
                va.vibrate(90);


                                Vibrator vll = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                                vll.vibrate(70);
                                File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "/Tedits");
                                boolean success = true;
                                if (!folder.exists()) {
                                    success = folder.mkdir();
                                }
                                if (success) {
                                    // Do something on success
                                } else {
                                    // Do something else on failure
                                }
                                Calendar c = Calendar.getInstance();


                                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                                String formattedDate = df.format(c.getTime());
                                vie = (ViewGroup) findViewById(R.id.relative1);
                                LayoutInflater inflater = getLayoutInflater();
                                View layout = inflater.inflate(R.layout.tostl, (ViewGroup) findViewById(R.id.toast_layout));
                                ((TextView) layout.findViewById(R.id.toast_text_1)).setText("Great! The image is now saved in the Tedit- folder!");
                                Toast toast = new Toast(getBaseContext());
                                toast.setDuration(Toast.LENGTH_LONG);

                                toast.setView(layout);
                                toast.show();
                                vie.setDrawingCacheEnabled(true);
                                Bitmap bmp = Bitmap.createBitmap(vie.getDrawingCache());
                                vie.setDrawingCacheEnabled(false);
                                try {
                                    FileOutputStream fos = new FileOutputStream(new File(Environment
                                            .getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString() + "/Tedits", "TEDIT"
                                            + "-" + formattedDate + "-" + System.currentTimeMillis() + ".png"));
                                    bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
                                    fos.flush();
                                    fos.close();
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                //We get a reference to the NotificationManager
                                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                                String MyText = "Saved!";
                                Notification mNotification = new Notification(R.drawable.web_hi_res_512, MyText, System.currentTimeMillis());
                                //The three parameters are: 1. an icon, 2. a title, 3. time when the notification appears

                                String MyNotificationTitle = "Alert!";
                                String MyNotificationText = "The image is now saved at /DCIM/Tedits!";

                                Intent MyIntent = new Intent(Intent.ACTION_VIEW);
                                PendingIntent StartIntent = PendingIntent.getActivity(getApplicationContext(), 0, MyIntent, PendingIntent.FLAG_CANCEL_CURRENT);
                                //A PendingIntent will be fired when the notification is clicked. The FLAG_CANCEL_CURRENT flag cancels the pendingintent

                                mNotification.setLatestEventInfo(getApplicationContext(), MyNotificationTitle, MyNotificationText, StartIntent);
                                mNotification.defaults |= Notification.DEFAULT_VIBRATE;
                                mNotification.flags |= Notification.FLAG_AUTO_CANCEL;


                                mNotification.defaults |= Notification.DEFAULT_SOUND;

                                //mNotification.defaults |= Notification.DEFAULT_VIBRATE;

                                int NOTIFICATION_ID = 1;
                                notificationManager.notify(NOTIFICATION_ID, mNotification);
                                //We are passing the notification to the NotificationManager with a unique id.


                                return true;

                                default:


                return super.onOptionsItemSelected(item);
        }


    }





    public void imuronc(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Choose")
                .setMessage("Choose an image from your gallery or take one.")
                .setCancelable(true)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Camera", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        startActivityForResult(intent, 7);

                    }
                })

                .setNeutralButton("Gallery", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                        Intent Galli = new Intent();
                        // Show only images, no videos or anything else
                        Galli.setType("image/*");
                        Galli.setAction(Intent.ACTION_GET_CONTENT);
// Always show the chooser (if there are multiple options available)

                        startActivityForResult(Intent.createChooser(Galli, "Select Picture"), PICK_IMAGE_REQUEST);

                    }
                })


                .setIcon(android.R.drawable.ic_menu_gallery)
                .show();
    }
    public RelativeLayout llmain;


    public void text(View view) {

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            // Enable vibrate
            // Vibrate for 400 milliseconds
            v.vibrate(50);
            filtt.setChecked(false);
            buttol.setBackgroundColor(Color.parseColor("#FF2D2D2D"));
            filtt.setBackgroundColor(Color.parseColor("#ff414141"));
            fil.setVisibility(View.GONE);
            Edto.setVisibility(View.VISIBLE);
        } else {
            // Disable vibrate
            buttol.setBackgroundColor(Color.parseColor("#ff414141"));
// Vibrate for 400 milliseconds
            v.vibrate(70);
            Edto.setVisibility(View.GONE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == 7) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            lolop.setImageBitmap(image);
        }
        if (resultCode == Activity.RESULT_OK && requestCode == 1) {

            lolop.setImageURI(data.getData());

        }


    }

    public void blk(View view) {
        Rollo.setTextColor(Color.BLACK);
    }

    public void wt(View view) {
        Rollo.setTextColor(Color.WHITE);

    }

    public void bl(View view) {
        Rollo.setTextColor(Color.parseColor("#ff007dff"));
    }

    public void fiftieight(View view) {
        Rollo.setTextSize(40);
    }

    public void eightf(View view) {
        Rollo.setTextSize(58);
    }


    public void bade(View view) {

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            v.vibrate(70);
            fil.setVisibility(View.VISIBLE);
            buttol.setChecked(false);
            buttol.setBackgroundColor(Color.parseColor("#ff414141"));
            filtt.setBackgroundColor(Color.parseColor("#FF2D2D2D"));
            Edto.setVisibility(View.GONE);
        } else {
            // Disable vibrate
            v.vibrate(50);
            filtt.setBackgroundColor(Color.parseColor("#ff414141"));

            fil.setVisibility(View.GONE);
        }
    }

    public void wmfilter(View view) {
        // Is the toggle on?
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            // Enable vibrate
            v.vibrate(70);
            warmfilter.setBackgroundColor(Color.parseColor("#FFA45200"));
            wf.setVisibility(View.VISIBLE);
            fil.setVisibility(View.VISIBLE);
        } else {
            // Disable vibrate
            v.vibrate(50);
            warmfilter.setBackgroundColor(Color.parseColor("#ffff8000"));

            wf.setVisibility(View.GONE);
        }
    }

    public void cldfilter(View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            // Enable vibrate
            v.vibrate(50);
            coldfilter.setBackgroundColor(Color.parseColor("#FF0076A0"));
            cf.setVisibility(View.VISIBLE);

        } else {
            // Disable vibrate
            v.vibrate(70);
            coldfilter.setBackgroundColor(Color.parseColor("#ff00c0ff"));

            cf.setVisibility(View.GONE);
        }
    }

    public void twenty(View view) {
        Rollo.setTextSize(28);
    }

    public void orgOnT(View view) {
        Typeface fontol = Typeface.createFromAsset(getAssets(), "fonts/orange.ttf");
        Rollo.setTypeface(fontol);
        mTxt.setTypeface(fontol);

    }

    @Override
    public void onBackPressed() {
        //Include the code here
        NavUtils.navigateUpFromSameTask(this);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        return;
    }
}














