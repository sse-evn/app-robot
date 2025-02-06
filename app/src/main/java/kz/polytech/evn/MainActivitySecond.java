package kz.polytech.evn;

import android.annotation.SuppressLint;
import android.app.Presentation;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.widget.VideoView;
import android.widget.MediaController;

public class MainActivitySecond extends Presentation {

    private VideoView videoView;

    public MainActivitySecond(Context context, Display display) {
        super(context, display);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen_layout);

        // Найти VideoView из макета
        videoView = findViewById(R.id.video_view);

        // Указать URI видеофайла
        Uri videoUri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.vi);

        // Установить URI в VideoView
        videoView.setVideoURI(videoUri);

        // Добавить MediaController для управления воспроизведением (опционально)
        MediaController mediaController = new MediaController(getContext());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // Установить слушатель на завершение видео
        videoView.setOnCompletionListener(mp -> videoView.start()); // Перезапуск видео

        // Запустить видео автоматически
        videoView.start();
    }
}
