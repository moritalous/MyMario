package forest.rice.field.k.mymario.sound;

import android.content.Context;
import android.media.SoundPool;

public abstract class Sound {

    private SoundPool soundPool = null;
    private int soundId = -1;

    public Sound(Context context) {
        soundPool = SoundPoolManager.getSoundPool();
        soundId = soundPool.load(context, getRawId(), 1);
    }

    abstract int getRawId();

    public void play() {
        soundPool.play(soundId, 1, 1, 1, 0, 1);
    }

}
