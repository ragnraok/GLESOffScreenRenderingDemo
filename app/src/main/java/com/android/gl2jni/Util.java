package com.android.gl2jni;

import android.util.Log;

import javax.microedition.khronos.egl.EGL10;

/**
 * Created by ragnarok on 15/8/30.
 */
public class Util {


    public static void checkEglError(String TAG, String prompt, EGL10 egl) {
        int error;
        while ((error = egl.eglGetError()) != EGL10.EGL_SUCCESS) {
            Log.e(TAG, String.format("%s: EGL error: 0x%x", prompt, error));
        }
    }
}
