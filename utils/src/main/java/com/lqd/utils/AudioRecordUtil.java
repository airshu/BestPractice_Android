package com.lqd.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.util.Log;

import java.io.File;

/**
 *
 * @author a564
 * @version 1.0
 * @Date 3/18/21
 */
public class AudioRecordUtil {

    private static final String TAG = "AudioRecordUtil";
    private String mPath;
    private MediaRecorder mMediaRecorder;
    private OnRecordListener mListener;

    private int mMaxDuration = 60 * 10000;

    public AudioRecordUtil() {
        try {
            mMediaRecorder = new MediaRecorder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMediaRecorderConfig(Context context) {
        File file = new File(context.getCacheDir() + "/record/");
        if (!file.exists()) {
            file.mkdirs();
        }
        mPath = context.getCacheDir() + "/record/" + System.currentTimeMillis() + ".aac";
        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);// 设置麦克风
        mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS); // 设置音频文件的编码
        mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);  // 设置音频输出编码格式
        mMediaRecorder.setAudioEncodingBitRate(64 * 1024); // 设置比特率
        mMediaRecorder.setAudioSamplingRate(44100); // 设置音频采样率
        mMediaRecorder.setAudioChannels(1); //音频通道
        mMediaRecorder.setMaxDuration(mMaxDuration); // 设置最大的录音时长
        mMediaRecorder.setOutputFile(mPath);// 设置音频输出地址
        mMediaRecorder.setOnErrorListener(new MediaRecorder.OnErrorListener() {
            @Override
            public void onError(MediaRecorder mediaRecorder, int i, int i1) {
                ThreadHelper.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (mListener != null) {
                            mListener.onError();
                        }
                    }
                });
            }
        });
        mMediaRecorder.setOnInfoListener(new MediaRecorder.OnInfoListener() {
            @Override
            public void onInfo(MediaRecorder mediaRecorder, final int i, int i1) {
                ThreadHelper.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (i == MediaRecorder.MEDIA_RECORDER_INFO_MAX_DURATION_REACHED) {
                            if (mListener != null) {
                                mListener.onRecordMaxReached();
                            }
                        }
                    }
                });
            }
        });

    }

    private void checkPermission(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.RECORD_AUDIO}, 1);
        }
    }

    public void startRecord(Context context) {
        try {
//            checkPermission(context);

            mMediaRecorder.reset();
            setMediaRecorderConfig(context);
            mMediaRecorder.prepare();
            mMediaRecorder.start();
            Log.e(TAG, "开始录音：" + mPath);
        } catch (Exception e) {
            Log.e(TAG, "录音失败啦！！！！");
            e.printStackTrace();
            if (mListener != null) {
                mListener.onError();
            }
        }
    }

    public void stopRecord() {
        try {
            Log.e(TAG, "停止录音");
            mMediaRecorder.stop();
            mMediaRecorder.release();
        } catch (Exception e) {
            Log.e(TAG, "停止录音失败啦！！！！");
            e.printStackTrace();
        }
    }

    public String getPath() {
        return mPath;
    }

    public void deleteAudio() {
        try {
            File file = new File(mPath);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMaxDuration(int maxDuration) {
        mMaxDuration = maxDuration;
    }

    public void release() {
        ThreadHelper.runOnAsyncThread(new Runnable() {
            @Override
            public void run() {
                try {
                    mMediaRecorder.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void setOnRecordListener(OnRecordListener listener) {
        mListener = listener;
    }



}

interface OnRecordListener {
    void onRecordMaxReached();

    void onError();
}
