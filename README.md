# Masai Conference App (Live Meeting App)

#### Masai Conference App is live meeting app which will provid you to meet your friends virtually. 

## Features
* In this app you can meet your friends colleagues live.
* you can share your screen.
* host can mute everyone who is in meeting room.
* if you want rise hand then you can rise your hand.
* if any person doing any anuthorised activity in live meeting then host can kickout this person into live meeting.
* here you can re-join perticular meeting.
* we have also impementd meeting scheduler in our app.
* you can share secret-key with your friends.
* we have also implemeted live chatting with your friends without live meeting.
* you can also see your friends last seen in our app.
* you can send friend request with your friends.


## Screenshots

|**Create Meeting Screen**|**Join Meeting Screen**|**Meet And Chat Screen**|
|:---|:--|:--|
|<img src=https://github.com/lucifernipun22/ZoomProject/blob/main/MasaiConference/app/src/main/res/screenshot/createMeeting.jpeg height="500px" width="350px"/>|<img src=https://github.com/lucifernipun22/ZoomProject/blob/main/MasaiConference/app/src/main/res/screenshot/joinMeeting.jpeg height="500px" width="350px"/>|<img src=https://github.com/lucifernipun22/ZoomProject/blob/main/MasaiConference/app/src/main/res/screenshot/Meet%26Chat.jpeg height="500px" width="350px"/>

|**Setting Screen**|**Meeting Schedule Screen**|**Chatting Screen**|
|:--|:--|:--|
|<img src=https://github.com/lucifernipun22/ZoomProject/blob/main/MasaiConference/app/src/main/res/screenshot/setting.jpeg height="500px" width="350px"/>|<img src=https://github.com/lucifernipun22/ZoomProject/blob/main/MasaiConference/app/src/main/res/screenshot/meetingschedule.jpeg height="500px" width="350px"/>|<img src=https://github.com/lucifernipun22/ZoomProject/blob/main/MasaiConference/app/src/main/res/screenshot/chatting.jpeg height="500px" width="350px"/>
<br/><br/>
## Some of dependencies we used in our app 

    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    implementation 'androidx.core:core-ktx:1.5.0'
    implementation 'androidx.appcompat:appcompat:1.3.0'
    //slider
    implementation 'com.github.smarteist:autoimageslider:1.4.0'
    implementation 'androidx.core:core:1.1.0'
    implementation 'com.google.android.material:material:1.3.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'androidx.recyclerview:recyclerview:1.0.0'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'
    //glide
    implementation 'com.github.bumptech.glide:glide:4.9.0'
    //scheduleTimezone
    compile 'net.danlew:android.joda:2.9.0'
    //lottie
    implementation 'com.airbnb.android:lottie:3.7.0'
    //parse
    implementation "com.github.parse-community.Parse-SDK-Android:parse:1.26.0"
    // Firebase
    implementation 'com.google.firebase:firebase-core:17.2.0'
    implementation 'com.google.firebase:firebase-auth:19.1.0'
    implementation 'com.google.firebase:firebase-database:19.2.0'
    implementation 'com.google.firebase:firebase-messaging:20.0.0'
    implementation 'com.google.firebase:firebase-storage:19.1.0'
    // FirebaseUI for Firebase Realtime Database
    implementation 'com.firebaseui:firebase-ui-database:6.0.2'
    // Firebase
    implementation 'com.google.firebase:firebase-analytics:17.4.3'
    implementation 'com.firebaseui:firebase-ui-auth:6.2.1'
    implementation 'com.google.firebase:firebase-dynamic-links-ktx:19.1.0'
    // for stylist toast
    implementation 'com.github.TheHasnatBD:SweetToast:1.0.2'
    // Picasso Library
    implementation 'com.squareup.picasso:picasso:2.71828'
    // HTTP & HTTP/2 client for Android
    implementation 'com.squareup.okhttp3:okhttp:4.0.1'
    //setting
    implementation 'com.makeramen:roundedimageview:2.3.0'
    implementation 'com.balysv:material-ripple:1.0.2'
    // Kotpref
    implementation 'com.chibatching.kotpref:kotpref:2.10.0'
    // Slider
    implementation 'com.github.AppIntro:AppIntro:6.0.0'
    implementation 'com.google.android.material:material:1.2.0'
    //navigation
    implementation "androidx.navigation:navigation-fragment-ktx:2.3.3"
    implementation "androidx.navigation:navigation-ui-ktx:2.3.3"
    //mewobottomnavigation
    implementation 'com.etebarian:meow-bottom-navigation:1.0.4'
    //tablout
    compile 'com.tompee:funtablayout:1.1.0'
    implementation 'com.github.iammert:AnimatedTabLayout:0.1'
    implementation 'com.github.mukeshsolanki:photofilter:1.0.2'
    implementation 'com.karumi:dexter:6.2.2'
    // Circle ImageView
    implementation 'de.hdodenhof:circleimageview:3.0.0'
    //materialsearch
    implementation 'com.github.mancj:MaterialSearchBar:0.8.2'
    // Coil
    implementation "io.coil-kt:coil:0.10.0"
    //drawer
    implementation 'com.infideap.drawerbehavior:drawer-behavior:1.0.3'
    // TimeAgo
    implementation 'com.github.marlonlom:timeago:4.0.1'
    // Fast Adapter
    implementation "com.mikepenz:fastadapter:5.0.2"
    implementation "com.mikepenz:fastadapter-extensions-binding:5.0.2"
    implementation "com.mikepenz:fastadapter-extensions-diff:5.0.2"
    implementation "com.mikepenz:fastadapter-extensions-utils:5.0.2"
    // Room
    implementation "androidx.room:room-runtime:2.2.5"
    implementation "androidx.room:room-ktx:2.2.5"
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    kapt "androidx.room:room-compiler:2.2.5"
    // Koin
    implementation "org.koin:koin-android:2.0.1"
    implementation "org.koin:koin-androidx-viewmodel:2.0.1"
    // Architecture Components
    implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.2.0"
    // Jitsi
    //implementation('org.jitsi.react:jitsi-meet-sdk:2.9.0') { transitive = true }
    implementation ('org.jitsi.react:jitsi-meet-sdk:2.+') { transitive = true }
    // Material theme
    implementation "com.google.android.material:material:1.1.0"
    //textDrawable
    implementation 'com.amulyakhare:com.amulyakhare.textdrawable:1.0.1'
    // cropping image library
    implementation 'com.theartofdev.edmodo:android-image-cropper:2.7.+'
    // image Compressor library
    implementation 'id.zelory:compressor:2.1.0'
    //RememberEditText
    implementation 'cn.zhaiyifan:rememberedittext:0.9.0'
    //jezzyrecycleView
    implementation 'com.twotoasters.jazzylistview:library-recyclerview:1.2.1'
    //numberofprogressbar
    implementation 'com.daimajia.numberprogressbar:library:1.4@aar'
    implementation 'com.afollestad.material-dialogs:commons:0.9.6.0'
    
    apply plugin: 'com.google.gms.google-services'
    mavenCentral()
    maven { url 'https://maven.fabric.io/public' }



<!--#Dependency 

## Technologies
* Java
* Kotlin
* Alert Dialog
* Intent
* Recycle View
* Room Database
* WebView
* firebase
* jitsi

dependencies {

    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'
    implementation 'com.github.bumptech.glide:glide:4.11.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'
    implementation 'com.github.swapnil1104:OtpEditText:1.0.2-rc'
    implementation 'com.github.aabhasr1:OtpView:v1.1.2'
    implementation 'com.google.android.material:material:1.0.0'
    implementation 'com.github.ybq:Android-SpinKit:1.4.0'

}

#Screenshots

![mydigital(2)](https://miro.medium.com/max/418/1*FB-u1A79smTlReyEobUMHQ.jpeg);
![test1](https://miro.medium.com/max/418/1*SPmvr7NmA__BB2YdLOJgzg.jpeg);
![test1](https://miro.medium.com/max/418/1*rJT7_0K5eGB_t0AewZJA2g.jpeg)
![test1](https://miro.medium.com/max/418/1*EEMNorsZMNg8CX04Twxfug.jpeg);


#Uses To Build Project

Animation in Splash Screen.

Password Toggle.

WebView to Login With Facebook or Google.

Glide.

SavedInstance.

Alert Dialog.

Recycle View.

Fragments.

<!--# Music Player App

###### Music Player application contains a list of songs.

## Technologies
* Java
* Services
* Content Provider

## Features

* The Music Player app displays a list of songs. With the help of Content Provider, all the songs from mobile device are provided to this music player app.
* The app allows you to Play, Pause and Stop songs with the help of Services.
* This app also provides the feature to shuffle and repeat songs.
* As per the requirement, the songs from the app can be deleted.

## Screenshots and description

After opening the application, you will find the welcome screen that stays in for 2 seconds. Afer that you can see the main home screen of the application. It displays the songs
from mobile device using content provider. 

It consists of 4 fragments namely, "Home", "Songs", "Albums" and "Artists". It also contains a search view and menu button at the top right corner of the screen.

|**Welcome screen**|**Main Home screen**|
|:---|:--|
|<img src=images/music_splash.jpeg height="500px" width="450px"/>|<img src=images/music_home.jpeg height="500px"/>|

<br/><br/>

The Home, Songs, Albums and Artists fragments contains its respective contents which is that the Home fragments displays all the songs present in the device. The Albums displays the list of all songs as per the albums name and the Artists fragment displays the songs based on the list of artists' name.

|**Albums screen**|**Artists screen**|
|:---|:--|
|<img src=images/music_album.jpeg height="500px"/>|<img src=images/music_artists.jpeg height="500px"/>|

<br/> <br/>

The Songs fragment displays the list of all the songs with the song name. On click of the song, its respective Music Play screen appears and the service starts so song starts playing. 

Using Services, user can play, pause & stop the song on click of play button. It provides the feature to shuffle the songs in the device and play it and if the user wants a song to play on repeat mode, user can click on repeat song option. It also consists of seek bar and it displays the duration of the current playing song. 

|**SongsList screen**|**Music Play screen**|
|:---|:--|
|<img src=images/music_song_list.jpeg height="500px"/>|<img src=images/music_song_play.jpeg height="500px"/>|

<br/> <br/>

The user can search the songs as per their choice with the help of seach view option. The list of songs are filtered according to the search input. 
The songs can be sorted based on the songs alphabets, date and size. It also provides the options to delete the song from the device. If the user wants to do it, they can click on the menu option at the end of the song and delete it.

|**Search view**|**Sort songs**|**Delete songs**|
|:---|:--|:--|
|<img src=images/music_search.jpeg height="500px"/>|<img src=images/music_sort.jpeg height="500px"/>|<img src=images/music_delete.jpeg height="500px"/>-->
