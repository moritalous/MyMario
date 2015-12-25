package forest.rice.field.k.mymario.sound;

import android.content.Context;
import android.os.Handler;

import forest.rice.field.k.mymario.utils.RandomUtil;

public class JumpSoundBarrage extends JumpSound {

    int count = 0;

    MushroomSound mushroomSound;
    CoinSound coinSound;

    public JumpSoundBarrage(Context context) {
        super(context);

        mushroomSound = new MushroomSound(context);
        coinSound = new CoinSound(context);
    }

    @Override
    public void play() {
        if (count == 0) {
            super.play();

            switch (RandomUtil.getRandom(20)) {
                case 1:
                case 2:
                case 3:
                case 4: {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mushroomSound.play();
                        }
                    }, 200);
                }
                break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14: {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            coinSound.play();
                        }
                    }, 200);
                }
                break;
                default:
                    break;
            }

        }
        count++;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                count--;
            }
        }, 400);
    }
}
