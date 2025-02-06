package kz.polytech.evn;

import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.view.Display;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MainActivitySecond presentation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация кнопки для перехода на новый экран
        Button buttonStart = findViewById(R.id.btn_speak);

        // Установка слушателя для перехода на новый экран
        buttonStart.setOnClickListener(v -> {
            // Переход в MainSceneActivity
            Intent intent = new Intent(MainActivity.this, MainSceneActivity.class);
            startActivity(intent);

            // Создание нового окна для второго экрана с новым контентом
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

}