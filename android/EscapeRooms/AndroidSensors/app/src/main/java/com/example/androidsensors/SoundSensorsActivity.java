package com.example.androidsensors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class SoundSensorsActivity extends AppCompatActivity {

    MediaRecorder mediaRecorder;
    boolean usingMediaRecorder = false;

    AudioRecord audioRecord;
    boolean usingAudioRecord = true;
    int minBufferSize;

    private void optionMediaRecorder() {
        // Create a new `MediaRecorder` and set its output format
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_2_TS);

        // Set the `MediaRecorder`'s encoder
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);

        try {
            // Complete the `MediaRecorder`'s initialization
            mediaRecorder.prepare();
        } catch (IOException e) {
            Toast.makeText(this,
                    String.format("Exception encountered (%s) see error output log for more details", e.getClass().toString()),
                    Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void optionAudioRecord() {
        // Check for permission, get into this code and refactor it WP
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        minBufferSize = AudioRecord.getMinBufferSize(AudioFormat.SAMPLE_RATE_UNSPECIFIED,
                AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_FLOAT);
        audioRecord = new AudioRecord(MediaRecorder.AudioSource.DEFAULT, AudioFormat.SAMPLE_RATE_UNSPECIFIED,
                AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_FLOAT, minBufferSize);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_sensors);

        optionAudioRecord();
    }

    private void printAudio() {
        float[] audioData = new float[minBufferSize];

        if (audioRecord.read(audioData, 0, minBufferSize, AudioRecord.READ_NON_BLOCKING) > 0) {
            Toast.makeText(this, String.format("First float red: %s", audioData[0]), Toast.LENGTH_SHORT).show();
        } else {
            // Error reading data
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        handleStopRecording();
    }

    @Override
    protected void onStop() {
        super.onStop();
        handleStopRecording();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handleResourceRelease();
    }

    private void handleStartRecording() {
        if (usingAudioRecord) {
            audioRecord.startRecording();
        } else if (usingMediaRecorder) {
            mediaRecorder.start();
        }
    }

    private void handleStopRecording() {
        if (usingAudioRecord) {
            audioRecord.stop();
        } else if (usingMediaRecorder) {
            mediaRecorder.stop();
        }
    }

    private void handleResourceRelease() {
        if (usingAudioRecord) {

        } else if (usingMediaRecorder) {
            mediaRecorder.release();
        }
    }

    public void startRecording(View view) {
        handleStartRecording();
        printAudio();
    }

    public void stopRecording(View view) {
        handleStopRecording();
    }
}