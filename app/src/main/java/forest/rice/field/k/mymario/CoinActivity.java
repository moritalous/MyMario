package forest.rice.field.k.mymario;

import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.squareup.seismic.ShakeDetector;

import forest.rice.field.k.mymario.sound.CoinSound;
import forest.rice.field.k.mymario.sound.OneUpSound;

public class CoinActivity extends AppCompatActivity implements ShakeDetector.Listener {

    private ShakeDetector sd;

    private CoinSound coinSound;
    private OneUpSound oneUpSound;

    private int count = 0;

    private TextView textCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        textCount = (TextView) findViewById(R.id.textCount);
        textCount.setText(String.valueOf(count));

        coinSound = new CoinSound(this);
        oneUpSound = new OneUpSound(this);

        sd = new ShakeDetector(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sd.start(sensorManager);
    }

    @Override
    protected void onPause() {
        super.onPause();

        sd.stop();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void hearShake() {
        Log.i("Shake", "Shake");
        coinSound.play();
        count++;
        textCount.setText(String.valueOf(count));
        if (count % 20 == 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    oneUpSound.play();
                }
            }, 100);
        }
    }
}
