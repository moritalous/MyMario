package forest.rice.field.k.mymario.utils;

import android.os.Handler;

public class CountDown {

    private final Handler handler;
    private final CountDownCallback callback;
    private Runnable runnable;
    private int count;
    private STATUS status = null;

    public CountDown(Handler handler, CountDownCallback callback) {
        this.handler = handler;
        this.callback = callback;
        status = STATUS.INIT;
    }

    public void startCountDown(final int interval, final int count) throws IllegalAccessException {
        if (status != STATUS.INIT) {
            throw new IllegalAccessException();
        }
        this.count = count;

        runnable = new Runnable() {
            @Override
            public void run() {
                if (status != STATUS.DO) {
                    return;
                }


                CountDown.this.count--;
                if (CountDown.this.count == 0) {
                    callback.finish(CountDown.this.count);
                } else {
                    callback.post(CountDown.this.count);
                    handler.postDelayed(runnable, interval);
                }

            }
        };

        status = STATUS.DO;
        handler.postDelayed(runnable, interval);
    }

    public void stopCountDown() throws IllegalAccessException {
        if (status != STATUS.DO) {
            throw new IllegalAccessException();
        }
        status = STATUS.STOP;
    }

    private enum STATUS {
        INIT,
        DO,
        STOP,
    }

    public interface CountDownCallback {
        void post(int nowCount);

        void finish(int nowCount);
    }
}
