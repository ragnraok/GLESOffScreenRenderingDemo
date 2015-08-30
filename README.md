# GLESOffScreenRenderingDemo
a simple demo to show how to use OpenGLES off-screen rendering in android

---

It illustrated how to used ``eglCreatePbufferSurface``  to create a new surface and set it as the current surface 
for OpenGL rendering, and used ``glReadPixels`` to retrieve the pixels from the render result, store it in the bitmap.

this project is based on [googlesamples/android-ndk/hello-gl2](https://github.com/googlesamples/android-ndk/tree/master/hello-gl2), and used latest Gradle 2.5 experiment version, which provide support for ndk project