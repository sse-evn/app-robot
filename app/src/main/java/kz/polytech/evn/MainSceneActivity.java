package kz.polytech.evn;

import android.hardware.display.DisplayManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainSceneActivity extends AppCompatActivity {

    private MainActivitySecond presentation;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_scene_);

        // Инициализация кнопки
        Button buttonPlaySound = findViewById(R.id.button_play_sound);

        // Инициализация MediaPlayer с ресурсом звука
        mediaPlayer = MediaPlayer.create(this, R.raw.info_college_kazakh); // Убедитесь, что sound_file находится в res/raw

        // Установка слушателя для кнопки
        buttonPlaySound.setOnClickListener(v -> {
            // Воспроизведение звука

            if (mediaPlayer != null) {
                mediaPlayer.start();
            }
        });

        // Проверка наличия второго дисплея
        DisplayManager displayManager = (DisplayManager) getSystemService(DISPLAY_SERVICE);
        Display[] displays = displayManager.getDisplays(DisplayManager.DISPLAY_CATEGORY_PRESENTATION);

        if (displays.length > 0 && presentation == null) {
            // Создаем второй экран с первоначальной информацией
            presentation = new MainActivitySecond(this, displays[0]);
            presentation.show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Освобождение MediaPlayer при завершении активности
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
