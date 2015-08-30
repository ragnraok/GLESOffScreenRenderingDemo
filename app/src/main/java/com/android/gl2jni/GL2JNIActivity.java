/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.gl2jni;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class GL2JNIActivity extends Activity {

//    GL2JNIView mView;
    PixelBuffer pixelBuffer;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
//        mView = new GL2JNIView(getApplication());
//        setContentView(mView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                pixelBuffer = new PixelBuffer(1080, 1800, new GLContextFactory(), new GLConfigChooser(8, 8, 8, 8, 0, 0));
                pixelBuffer.setRenderer(new GLRenderer());
                Bitmap bitmap = pixelBuffer.getBitmap();
                if (bitmap != null) {
                    try {
                        FileOutputStream fos = new FileOutputStream("/sdcard/pbbitmap.png");
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                        Log.d("Ragnarok", "successfully store bitmap");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        mView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pixelBuffer != null) {
            pixelBuffer.destroy();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        mView.onResume();
    }
}
