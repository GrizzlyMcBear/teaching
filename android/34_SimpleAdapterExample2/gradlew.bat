<?xml version="1.0" encoding="UTF-8"?>
<root>
  <item name="android.media.session.MediaSession void setFlags(int) 0">
    <annotation name="androidx.annotation.IntDef">
      <val name="flag" val="true" />
      <val name="value" val="{android.media.session.MediaSession.FLAG_HANDLES_MEDIA_BUTTONS, android.media.session.MediaSession.FLAG_HANDLES_TRANSPORT_CONTROLS}" />
    </annotation>
  </item>
  <item name="android.media.session.MediaSession void setRatingType(int) 0">
    <annotation name="androidx.annotation.IntDef">
      <val name="value" val="{android.media.Rating.RATING_NONE, android.media.Rating.RATING_HEART, android.media.Rating.RATING_THUMB_UP_DOWN, android.media.Rating.RATING_3_STARS, android.media.Rating.RATING_4_STARS, android.media.Rating.RATING_5_STARS, android.media.Rating.RATING_PERCENTAGE}" />
    </annotation>
  </item>
  <item name="android.media.session.PlaybackState int getState()">
    <annotation name="androidx.annotation.IntDef">
      <val name="value" val="{android.media.session.PlaybackState.STATE_NONE, android.media.session.PlaybackState.STATE_STOPPED, android.media.session.PlaybackState.STATE_PAUSED, android.media.session.PlaybackState.STATE_PLAYING, android.media.session.PlaybackState.STATE_FAST_FORWARDING, android.media.session.PlaybackState.STATE_REWINDING, android.media.session.PlaybackState.STATE_BUFFERING, android.media.session.PlaybackState.STATE_ERROR, android.media.session.PlaybackState.STATE_CONNECTING, android.media.session.PlaybackState.STATE_SKIPPING_TO_PREVIOUS, android.media.session.PlaybackState.STATE_SKIPPING_TO_NEXT, android.media.session.PlaybackState.STATE_SKIPPING_TO_QUEUE_ITEM}" />
    </annotation>
  </item>
  <item name="android.media.session.PlaybackState long getActions()">
    <annotation name="androidx.annotation.LongDef">
      <val name="flag" val="true" />
      <val name="value" val="{android.media.session.PlaybackState.ACTION_STOP, android.media.session.PlaybackState.ACTION_PAUSE, android.media.session.PlaybackState.ACTION_PLAY, android.media.session.PlaybackState.ACTION_REWIND, android.media.session.PlaybackState.ACTION_SKIP_TO_PREVIOUS, android.media.session.PlaybackState.ACTION_SKIP_TO_NEXT, android.media.session.PlaybackState.ACTION_FAST_FORWARD, android.media.session.PlaybackState.ACTION_SET_RATING, android.media.session.PlaybackState.ACTION_SEEK_TO, android.media.session.PlaybackState.ACTION_PLAY_PAUSE, android.media.session.PlaybackState.ACTION_PLAY_FROM_MEDIA_ID, android.media.session.PlaybackState.ACTION_PLAY_FROM_SEARCH, android.media.session.PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM, android.media.session.PlaybackState.ACTION_PLAY_FROM_URI, android.media.session.PlaybackState.ACTION_PREPARE, android.media.session.PlaybackState.ACTION_PREPARE_