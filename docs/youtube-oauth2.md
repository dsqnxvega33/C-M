---
title: Signing into YouTube
description: "Information regarding signing into a Google Account, to help with YouTube playback"
---

## Foreword

You can give JMusicBot access your Google account to help with
playing back YouTube tracks.

This is only need to sign in if you wish to play age-restricted videos,
or are experiencing the "Please sign in" error. Outside of that, signing in
is unnecessary.

!!! danger

    **DO NOT USE YOUR MAIN GOOGLE ACCOUNT!**

    Your Google account can get terminated, as this is breaking
    Google's Terms of Service.

    **CREATE A NEW GOOGLE ACCOUNT FOR JMUSICBOT!**

## Setting up

1. Enable `youtubeoauth2=true` in your `config.txt`.
    - You may already have `youtubeoauth2=false` somewhere in your config.
      If you do, you can replace `false` with `true`.
    - Otherwise, create a new line anywhere in your config with
      `youtubeoauth2=true`.

2. Restart JMusicBot.

3. JMusicBot will now send the following
   to the owner's direct messages and to the console:
    ```
    [INFO] [YoutubeOauth2Handler]: ==================================================
    [INFO] [YoutubeOauth2Handler]: !!! DO NOT AUTHORISE WITH YOUR MAIN ACCOUNT, USE A BURNER !!!
    [INFO] [YoutubeOauth2Handler]: OAUTH INTEGRATION: To give youtube-source access to your account, go to https://www.google.com/device and enter code GXN-YJC-BQNY
    [INFO] [YoutubeOauth2Handler]: !!! DO NOT AUTHORISE WITH YOUR MAIN ACCOUNT, USE A BURNER !!!
    [INFO] [YoutubeOauth2Handler]: ==================================================
    ```

    ![Direct Message from JMusicBot on Discord](/assets/images/youtube-oauth2-dm.png)

4. Head to the shown URL (https://www.google.com/device)
   and enter the code prompted by JMusicBot:

    ![Screenshot of Google's page with the code filled in](/assets/images/youtube-oauth2-code.png)

5. Select your Google account

    !!! danger

        Reminder, **DO NOT USE YOUR MAIN GOOGLE ACCOUNT FOR SIGNING IN!**

        Please make sure you are using a new Google account!

    ![Screenshot of Google's choose an account page](/assets/images/youtube-oauth2-choose-account.png)

6. In the authorisation page, click "Allow"
   to authorise JMusicBot to your Google account.

    ![Screenshot of Google's authorisation page](/assets/images/youtube-oauth2-authorisation.png)


After the authorisation has completed, the following message should get logged
to the console a few seconds later:

`[INFO] [YoutubeOauth2TokenHandler]: Authorization successful & retrieved token! Storing the token in /path/to/jmusicbot/youtubetoken.txt`

JMusicBot is now signed in and will store the credentials
in a new `youtubetoken.txt` file. 

!!! note

    If JMusicBot fails to write that file, it will instead log the message
    "Failed to write the YouTube OAuth2 refresh token to storage! You will
    need to authorize again on the next reboot."

    Ensure JMusicBot can write files, then restart the bot & login again.

## FAQ

### I get asked to enter a phone number when registering on Google!

You should try the following:

- If you are using a VPN, disable it.
- When prompted if you want a new Gmail account, use your own
  Email address instead.

If these don't work, it *should* be okay for you to use your phone number.
Using your phone number for verification won't directly tie it to the account,
so bans won't reach out to other Google accounts. The only caveat is that
there is a limit to how many Google accounts a phone number can verify.

### What causes the sign in issue to appear?

We believe that Google has begun identifying & blocking IP address ranges (ASNs)
that come from server host providers (such as DigitalOcean, OVH, Hetzner etc.)
and other sources that excessively load videos on YouTube.

### What is this workaround of signing in to a Google account? Is it rsiky?

Using traditional workarounds, like cookies, is known to be risky on YouTube
and gets Google accounts banned quickly.
However, this (mostly riskless) workaround has been found, in which you
"sign in" to a Google account as a device/TV using OAuth2.

There have been no confirmed cases of Google accounts getting banned using 
this workaround so far. However, it is still heavily encouraged to use a
new Google account for this, as Google could detect this workaround at any time
and ban Google accounts that abuse it.

### How do I sign out?

To sign out, manually delete the `youtubetoken.txt` and restart JMusicBot.

Additionally, you may want to go to
[Your Google Account -> Security -> See all connections](https://myaccount.google.com/connections)
to remove the "YouTube on TV" connection.
Note that this will also sign out any TV you were signed in to with that
Google account.

![Screenshot of Google's connections page](/assets/images/youtube-oauth2-connections.png)

![Screenshot of YouTube on TV connection page, highlighting the "Delete all connections you have with YouTube on TV" button](/assets/images/youtube-oauth2-connections-youtube-tv.png)
