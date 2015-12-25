package forest.rice.field.k.mymario;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.squareup.seismic.ShakeDetector;

import forest.rice.field.k.mymario.sound.JumpSoundBarrage;

public class JumpActivity extends AppCompatActivity implements ShakeDetector.Listener {

    private ShakeDetector sd;

    private JumpSoundBarrage jumpSoundBarrage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);

        jumpSoundBarrage = new JumpSoundBarrage(this);

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
    public void hearShake() {
        Log.i("Shake", "Shake");
        jumpSoundBarrage.play();
    }
}
