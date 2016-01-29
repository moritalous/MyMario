package forest.rice.field.k.mymario;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.squareup.seismic.ShakeDetector;

import forest.rice.field.k.mymario.media.HurryUpMediaPlayer;
import forest.rice.field.k.mymario.media.MyMediaPlayer;
import forest.rice.field.k.mymario.media.OneUpMediaPlayer;
import forest.rice.field.k.mymario.sound.CoinSound;
import forest.rice.field.k.mymario.utils.CountDown;

public class CountGameActivity extends AppCompatActivity implements CountDown.CountDownCallback, ShakeDetector.Listener, MyMediaPlayer.MyMediaPlayerOnCompletionListener {

    private FloatingActionButton fab;
    private TextView textCount;
    private TextView textTimer;

    private ShakeDetector sd;

    private CoinSound coinSound;

    private int count = 0;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        handler = new Handler();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textTimer.setText(String.format("%1$03d", 10));

                count = 0;
                textCount.setText(String.valueOf(count));

                fab.hide();

                playStartSound();
            }
        });

        textTimer = (TextView) findViewById(R.id.text);

        textCount = (TextView) findViewById(R.id.textCount);
        textCount.setText(String.valueOf(count));

        coinSound = new CoinSound(this);
        sd = new ShakeDetector(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
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
    public void post(int nowCount) {
        textTimer.setText(String.format("%1$03d", nowCount));
    }

    @Override
    public void finish(int nowCount) {
        fab.show();
        textTimer.setText(String.format("%1$03d", nowCount));
        sd.stop();

        playStopSound();
    }

    @Override
    public void hearShake() {
        Log.i("Shake", "Shake");
        coinSound.play();
        count++;
        textCount.setText(String.valueOf(count));
    }

    private void playStartSound() {
        MyMediaPlayer player = new HurryUpMediaPlayer(this);
        player.setOnCompletionListener(this);
        player.start();
    }

    private void playStopSound() {
        MyMediaPlayer player = new OneUpMediaPlayer(this);
        player.start();
    }

    private void startCountDown() {
        CountDown countDown = new CountDown(handler, CountGameActivity.this);
        try {
            countDown.startCountDown(1000, 10);

            SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            sd.start(sensorManager);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCompletion() {
        startCountDown();
    }
}
