package forest.rice.field.k.mymario.media;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

public abstract class MyMediaPlayer implements MediaPlayer.OnCompletionListener {

    MediaPlayer player;

    MyMediaPlayerOnCompletionListener listener;

    public MyMediaPlayer(Context context) {

        player = MediaPlayer.create(context, getResId());
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        try {
//            player.prepare();
        player.setOnCompletionListener(this);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void setOnCompletionListener(MyMediaPlayerOnCompletionListener listener) {
        this.listener = listener;
    }

    abstract int getResId();

    public void start() {
//        player.reset();
        player.start();
    }

    public void stop() {
        player.stop();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        if (listener != null) {
            listener.onCompletion();
        }
    }

    public interface MyMediaPlayerOnCompletionListener {
        void onCompletion();
    }
}
