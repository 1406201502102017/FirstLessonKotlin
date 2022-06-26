package com.gb.android.firstlessonkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

/*
1. Создать новый проект в Android Studio без поддержки Kotlin.
2. Сконфигурировать Kotlin в новом проекте (лучше вручную).
3. Перевести MainActivity на Kotlin.
4. Добавить кнопку в разметку и повесить на неё clickListener в Activity.
5. Потренироваться в создании классов и функций, описанных в уроке, и убедиться, что всё
работает. Например, создать тестовое приложение:
a. Сформировать data class с двумя свойствами и вывести их на экран приложения.
b. Создать Object класса из пункта а. В этом Object вызвать copy и вывести значения скопированного класса на
экран.
c. Вывести значения из разных циклов в консоль, используя примеры из методических
материалов.

Задача для дополнительного обучения
Переведите проект с заметками на Kotlin. Курс «Базовый уровень».
 */
class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val infoNote = NoteCopy("final", 17, "end")
        val infoNoteCopy = infoNote.copy()
        val dataNote = Note("author", "new text")

        for (i in 1..10) {
            if (i % 2 == 0)
                Log.d("myLog", "Even")
            else
                Log.d("myLog","Odd")
        }

        val classNote = findViewById<TextView>(R.id.dataNote)
        val button = findViewById<Button>(R.id.button).setOnClickListener { classNote.text = "${infoNoteCopy.text} ${infoNoteCopy.page} ${infoNoteCopy.someText}" }
        val showText = findViewById<TextView>(R.id.showText).setText(dataNote.toString())

        Log.d("myLog", "${infoNote.text} ${infoNote.page} ${infoNote.someText}")
        Log.d("myLog", "${infoNoteCopy.text} ${infoNoteCopy.page} ${infoNoteCopy.someText}")

//        val button: Button = findViewById(R.id.button)
//        button.setOnClickListener {
//            textView.text = "Kotlin"
//        }
//
//        findViewById<AppCompatButton>(R.id.button).setOnClickListener { textView.text = "Kotlin" }
    }
}