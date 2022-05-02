package com.example.calendar_view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val intent = Intent()
//        intent.setClassName(this, "ru.slybeaver.truecalendar.CalendarActivity")
//        startActivity(intent)

//        val intent = Intent(Intent.ACTION_VIEW).setClassName(
//            "ru.slybeaver.truecalendar", "ru.slybeaver.truecalendar.CalendarActivity"
//        )
//        startActivity(intent)
    }


//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.drop_down_menu, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        val id = item.itemId
//        return if (id == R.id.action_7days1) {
//            true
//        } else super.onOptionsItemSelected(item)
//    }

}