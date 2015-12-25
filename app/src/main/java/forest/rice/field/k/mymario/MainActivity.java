package forest.rice.field.k.mymario;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import forest.rice.field.k.mymario.sound.SoundPoolManager;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        SoundPool soundPool = SoundPoolManager.getSoundPool();

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setText("コイン");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CoinActivity.class);
                startActivity(intent);
            }
        });

        MyButton button2 = new MyButton(
                (Button) findViewById(R.id.button2),
                soundPool,
                this,
                R.raw.nc26813,
                R.string.button2
        );

        MyButton mButton3 = new MyButton(
                (Button) findViewById(R.id.button3),
                soundPool,
                this,
                R.raw.nc26817,
                R.string.button3
        );


        Button button4 = (Button) findViewById(R.id.button4);
        button4.setText("ジャンプ");
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JumpActivity.class);
                startActivity(intent);
            }
        });


        MyButton button5 = new MyButton(
                (Button) findViewById(R.id.button5),
                soundPool,
                this,
                R.raw.nc27132,
                R.string.button5
        );

        MyButton button6 = new MyButton(
                (Button) findViewById(R.id.button6),
                soundPool,
                this,
                R.raw.nc27241,
                R.string.button6
        );

        MyButton button7 = new MyButton(
                (Button) findViewById(R.id.button7),
                soundPool,
                this,
                R.raw.nc27331,
                R.string.button7
        );

        MyButton button8 = new MyButton(
                (Button) findViewById(R.id.button8),
                soundPool,
                this,
                R.raw.nc27333,
                R.string.button8
        );

        MyButton button9 = new MyButton(
                (Button) findViewById(R.id.button9),
                soundPool,
                this,
                R.raw.nc27355,
                R.string.button9
        );
    }
}
