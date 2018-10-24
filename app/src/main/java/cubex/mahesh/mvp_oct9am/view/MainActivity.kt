package cubex.mahesh.mvp_oct9am.view

import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cubex.mahesh.mvp_oct9am.R

class MainActivity : AppCompatActivity(),IncExpViewAPI {
    override fun insertResponse(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readResponse(c: Cursor) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
