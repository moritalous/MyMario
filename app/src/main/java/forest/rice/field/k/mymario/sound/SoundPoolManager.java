package forest.rice.field.k.mymario.sound;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

public class SoundPoolManager {

    private static SoundPool soundPool = null;

    private SoundPoolManager() {
    }

    public static SoundPool getSoundPool() {
        if (soundPool == null) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                return getSoundPool1();
            } else {
                return getSoundPool2();
            }
        }
        return soundPool;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private static SoundPool getSoundPool1() {
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
    private static SoundPool getSoundPool2() {
        return new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
    }

}
