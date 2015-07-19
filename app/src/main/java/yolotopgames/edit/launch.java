package yolotopgames.edit;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class launch extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF21374A")));
        setContentView(R.layout.activity_launch);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_launch, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent browserIntent = new Intent();
            browserIntent.setAction(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse("https://play.google.com/store/apps/details?id=yolotopgames.edit"));
            startActivity(browserIntent);
            return true;
        }
        if (id == R.id.action_infoo) {
            new AlertDialog.Builder(this)
                    .setTitle("Info")
                    .setMessage("This is an app under development! Not finished at all!")
                    .setCancelable(true)

                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {


                        }
                    })


                    .setIcon(R.drawable.ic_info_black_24dp)
                    .show();

        }

        return super.onOptionsItemSelected(item);
    }
    public void strtonT(View view) {
        Vibrator vo = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Intent startI = new Intent(launch.this, MainActivity.class);
        startActivity(startI);
        vo.vibrate(70);
    }
    public void exitt(View view) {
        Vibrator vobbo = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vobbo.vibrate(80);
        new AlertDialog.Builder(this)
                .setTitle("Exit?")
                .setMessage("Are you sure you want to exit?")
                .setCancelable(true)

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        launch.this.finish();
                        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    }
                })

                .setIcon(R.drawable.ic_warning_black_48dp)
                .show();





    }
    @Override
    public void onBackPressed() {
        //Include the code here
        Vibrator voblbo = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        voblbo.vibrate(80);
        new AlertDialog.Builder(this)
                .setTitle("Exit?")
                .setMessage("Are you sure you want to exit?")
                .setCancelable(true)

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


                    }
                })
.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

    public void onClick(DialogInterface dialog, int which) {
        launch.this.finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
})

                .setIcon(R.drawable.ic_warning_black_48dp)
                .show();

        return;
    }
}
