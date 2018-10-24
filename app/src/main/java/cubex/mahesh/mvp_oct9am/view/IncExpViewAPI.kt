package cubex.mahesh.mvp_oct9am.view

import android.database.Cursor

interface IncExpViewAPI {
    fun insertResponse(msg:String)
    fun readResponse(c:Cursor)
}