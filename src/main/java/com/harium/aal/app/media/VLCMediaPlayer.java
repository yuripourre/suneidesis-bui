package com.harium.aal.app.media;

import com.harium.aal.BaseApp;
import com.harium.aal.core.engine.AALEngine;
import com.harium.aal.core.input.InputKey;

public class VLCMediaPlayer extends BaseApp implements MediaPlayer {

    public VLCMediaPlayer(AALEngine engine) {
        super(engine);
    }

    @Override
    public void open() {
        run("vlc");
    }

    @Override
    public void togglePlay() {
        engine.typeKey(InputKey.SPACE);
    }

    @Override
    public void cycleAudioTrack() {
        /*if (!active()) {
            activate();
        }*/
        engine.typeKey(InputKey.B);
    }
}
