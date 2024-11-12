package com.jagrosh.jmusicbot;

import dev.lavalink.youtube.YoutubeAudioSourceManager;

public class MyYtAudioSourceManager extends YoutubeAudioSourceManager {
    public MyYtAudioSourceManager(boolean allowSearch, boolean useOauth2, String googleClientId, String googleClientSecret) {
        super(allowSearch);
        if (!useOauth2)
            return;
        this.oauth2Handler = new MyAuth2Handler(httpInterfaceManager,googleClientId,googleClientSecret);
        contextFilter.setOauth2Handler(oauth2Handler);

        httpInterfaceManager.setHttpContextFilter(contextFilter);
    }
}
