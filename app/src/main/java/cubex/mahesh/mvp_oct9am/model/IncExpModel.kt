package cubex.mahesh.mvp_oct9am.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import cubex.mahesh.mvp_oct9am.beans.IncExpBean
import cubex.mahesh.mvp_oct9am.presenter.IncExpPresenterAPI
import cubex.mahesh.mvp_oct9am.view.IncExpViewAPI
import cubex.mahesh.mvp_oct9am.view.MainActivity

class IncExpModel : IncExpPresenterAPI
{
    var dBase : SQLiteDatabase? = null
    var mActivity:MainActivity? = null
    constructor(api:IncExpViewAPI)
    {
         mActivity = api as MainActivity
        dBase = mActivity!!.openOrCreateDatabase("incexp_db",
                Context.MODE_PRIVATE,null)
        dBase!!.execSQL("create table if not exists incexp(_id integer primary key autoincrement,date varchar(500),money integer,_desc varchar(500),type varchar(100) )")
    }

    override fun insertIncExp(bean: IncExpBean) {
        var cv = ContentValues( )
        cv.put("date",bean.date)
        cv.put("money",bean.money)
        cv.put("_desc",bean.desc)
        cv.put("type",bean.type)
       var status =  dBase!!.insert("incexp",null, cv)
        if(status!=-1L)
        {
                mActivity!!.insertResponse("Data Insertion Success")
        }else{
            mActivity!!.insertResponse("Data Insertion Fail")
        }

    }

    override fun readIncExp() {
        var c = dBase!!.query("incexp",null,null,
                null,null,null,null)
        mActivity!!.readResponse(c)
    }

}