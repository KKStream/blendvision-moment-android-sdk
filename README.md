# BlendVision Moment Player

BlendVisionMomentPlayer is a Kotlin library to help you integrate BlendVision Moment player into your Android app.

## Requirement

The SDK supports
- Kotlin
- Android 6 or above


## Installation

### AAR

- Copy the following files required in the `sdk` folder to the `lib` folder in your project:

```
blendvisionmomentplayer-(latest_version).aar
kksplayer-library-ui-(kksplayer_version).aar
kksplayer-library-hls-(kksplayer_version).aar
kksplayer-library-dash-(kksplayer_version).aar
kksplayer-library-core-(kksplayer_version).aar
kksplayer-kkdrm-(kksplayer_version).aar
kksplayer-(kksplayer_version).aar
kks-paas-release-(kks_paas_version).aar
kks-network-(kks_network_version).aar
kks-daas-release-(kks_daas_version).aar
```

### Gradle Setting

- Add the following permission to `AndroidManifest.xml` file:
```xml
    <uses-permission android:name="android.permission.INTERNET" />
```

- Add the following plugins to the module-level `build.gradle` file:
```groovy
plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-kapt'
}
```

- Add the following dependencies to the module-level `build.gradle` file:
```groovy
dependencies {
    // The libraries for BlendVision Moment Player
    implementation fileTree(dir: 'libs', include: ['*.jar', "*.aar"])

    // The required dependencies
    implementation "androidx.core:core-ktx:$core_ktx_version"
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation "com.google.code.gson:gson:$gson_version"
    implementation "com.google.android.gms:play-services-cast-framework:$cast_version"
    implementation "com.squareup.okhttp3:okhttp:$okHttp_version"
    implementation "com.google.ads.interactivemedia.v3:interactivemedia:$google_ima_version"
    implementation "com.github.bumptech.glide:glide:$glide_version"
    kapt "com.github.bumptech.glide:compiler:$glide_version"
    implementation "io.reactivex.rxjava2:rxjava:$rx_java_version"
    implementation "io.reactivex.rxjava2:rxandroid:$rx_android_version"
    implementation "io.reactivex.rxjava2:rxkotlin:$rx_kotlin_version"
    implementation "androidx.room:room-runtime:$androidx_room_version"
    kapt "androidx.room:room-compiler:$androidx_room_version"
    implementation "com.auth0.android:jwtdecode:$jwt_version"
    implementation "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:$retrofit_coroutines_adapter"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_viewmodel_ktx"
}
```

- Add the following package option to the module-level `build.gradle` file:
```groovy
android {
    ...
    packagingOptions {
        exclude 'META-INF/*.kotlin_module'
    }
}
```

- Turn on Java 8 support in the module-level `build.gradle` file:

```groovy
android {
    ...
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = '1.8'
    }
}
```

- Enable view binding in the module-level `build.gradle` file:

```groovy
android {
    ...
    viewBinding {
        enabled = true
    }
}
```
## Usage
You can start a Moment LIVE event by call `BlendVisionMomentPlayer.presentPlayer` to present the player and then start the LIVE playback.

```kotlin
overrided fun onCreate(savedInstanceState: Bundle?) {
    ...
    // define a container in your layout to embed the player in
    val container: ViewGroup = findViewById<FrameLayout>(R.id.container)
    
    // Fetch a access token from your moment service CMS
    val token: String = fetchToken()
    
    BlendVisionMomentPlayer.presentPlayer(
        playerContext = PlayerContext(
            activity = this,
            container = container,
            configuration = Configuration(defaultResolution = resolution),
            barItems = gerBarItems()
        ),
        token = token
    )
}
```

## ProGuard 
Depending on your ProGuard (DexGuard) config and usage, you may need to include the following lines in your `proguard-rules.pro` :

```pro
-keep interface com.kkstream.android.blendvisionmoment.** { *; }

-keep public class com.kkstream.android.blendvisionmoment.** { *; }
```
