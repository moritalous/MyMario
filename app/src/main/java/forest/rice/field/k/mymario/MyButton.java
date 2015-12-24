package forest.rice.field.k.mymario;

import android.content.Context;
import android.media.SoundPool;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyButton {

    private Button button;
    private int soundId;
    private int rawId;
    private SoundPool soundPool;

    private int clickCount = 0;
    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            clickCount++;
            soundPool.play(soundId, 1, 1, 1, 0, 1);

        }
    };

    public MyButton(Button button, SoundPool soundPool, Context context, int rawId, int titleId) {
        this.button = button;
        this.rawId = rawId;
        this.soundPool = soundPool;
        this.soundId = soundPool.load(context, rawId, 1);
        this.button.setOnClickListener(onClickListener);
        this.button.setText(context.getText(titleId));
    }

    public void performClick() {
        this.button.performClick();
    }

    public int getClickCount() {
        return clickCount;
    }
}
