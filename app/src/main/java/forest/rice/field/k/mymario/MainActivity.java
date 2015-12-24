package forest.rice.field.k.mymario;

import android.annotation.TargetApi;
import android.hardware.SensorManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;

import com.squareup.seismic.ShakeDetector;


public class MainActivity extends AppCompatActivity implements ShakeDetector.Listener {


    private MyButton mButton1;
    private MyButton mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.kazuaki.mymario.R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(com.example.kazuaki.mymario.R.id.toolbar);
        setSupportActionBar(toolbar);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        SoundPool soundPool = getSoundPool();

        mButton1 = new MyButton(
                (Button) findViewById(com.example.kazuaki.mymario.R.id.button1),
                soundPool,
                this,
                com.example.kazuaki.mymario.R.raw.nc26792,
                com.example.kazuaki.mymario.R.string.button1
        );

        MyButton button2 = new MyButton(
                (Button) findViewById(com.example.kazuaki.mymario.R.id.button2),
                soundPool,
                this,
                com.example.kazuaki.mymario.R.raw.nc26813,
                com.example.kazuaki.mymario.R.string.button2
        );

        mButton3 = new MyButton(
                (Button) findViewById(com.example.kazuaki.mymario.R.id.button3),
                soundPool,
                this,
                com.example.kazuaki.mymario.R.raw.nc26817,
                com.example.kazuaki.mymario.R.string.button3
        );

        MyButton button4 = new MyButton(
                (Button) findViewById(com.example.kazuaki.mymario.R.id.button4),
                soundPool,
                this,
                com.example.kazuaki.mymario.R.raw.nc27131,
                com.example.kazuaki.mymario.R.string.button4
        );

        MyButton button5 = new MyButton(
                (Button) findViewById(com.example.kazuaki.mymario.R.id.button5),
                soundPool,
                this,
                com.example.kazuaki.mymario.R.raw.nc27132,
                com.example.kazuaki.mymario.R.string.button5
        );

        MyButton button6 = new MyButton(
                (Button) findViewById(com.example.kazuaki.mymario.R.id.button6),
                soundPool,
                this,
                com.example.kazuaki.mymario.R.raw.nc27241,
                com.example.kazuaki.mymario.R.string.button6
        );

        MyButton button7 = new MyButton(
                (Button) findViewById(com.example.kazuaki.mymario.R.id.button7),
                soundPool,
                this,
                com.example.kazuaki.mymario.R.raw.nc27331,
                com.example.kazuaki.mymario.R.string.button7
        );

        MyButton button8 = new MyButton(
                (Button) findViewById(com.example.kazuaki.mymario.R.id.button8),
                soundPool,
                this,
                com.example.kazuaki.mymario.R.raw.nc27333,
                com.example.kazuaki.mymario.R.string.button8
        );

        MyButton button9 = new MyButton(
                (Button) findViewById(com.example.kazuaki.mymario.R.id.button9),
                soundPool,
                this,
                com.example.kazuaki.mymario.R.raw.nc27355,
                com.example.kazuaki.mymario.R.string.button9
        );


        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector sd = new ShakeDetector(this);
        sd.start(sensorManager);

    }

    private SoundPool getSoundPool() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            return getSoundPool1();
        } else {
            return getSoundPool2();
        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private SoundPool getSoundPool1() {
        AudioAttributes attr = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();

        return new SoundPool.Builder()
                .setAudioAttributes(attr)
                .setMaxStreams(6)
                .build();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private SoundPool getSoundPool2() {
        return new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
    }

    @Override
    public void hearShake() {
        Log.e("Shake", "shake");
        mButton1.performClick();
        if ((mButton1.getClickCount() % 20) == 0) {
            mButton3.performClick();
        }
    }
}
