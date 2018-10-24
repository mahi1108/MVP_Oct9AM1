package cubex.mahesh.mvp_oct9am.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import cubex.mahesh.mvp_oct9am.beans.IncExpBean
import cubex.mahesh.mvp_oct9am.presenter.IncExpPresenterAPI
import cubex.mahesh.mvp_oct9am.view.IncExpViewAPI
import cubex.mahesh.mvp_oct9am.view.MainActivity

class IncExpModel : IncExpPresenterAPI
{
    var dBase : SQLiteDatabase? = null
    constructor(api:IncExpViewAPI)
    {
        var mActivity = api as MainActivity
        dBase = mActivity.openOrCreateDatabase("incexp_db",
                Context.MODE_PRIVATE,null)
        dBase!!.execSQL("create table if not exists incexp(_id integer primary key autoincrement,date varchar(500),money integer,_desc varchar(500),type varchar(100) )")
    }

    override fun insertIncExp(bean: IncExpBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun readIncExp() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}