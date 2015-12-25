package forest.rice.field.k.mymario.sound;

import android.content.Context;

import forest.rice.field.k.mymario.R;

public class MushroomSound extends Sound {

    public MushroomSound(Context context) {
        super(context);
    }

    @Override
    int getRawId() {
        return R.raw.nc26813;
    }

    @Override
    public void play() {
        super.play();
        vibrator.vibrate(150);
    }
}
