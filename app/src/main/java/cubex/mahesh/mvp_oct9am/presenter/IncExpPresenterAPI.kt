package cubex.mahesh.mvp_oct9am.presenter

import cubex.mahesh.mvp_oct9am.beans.IncExpBean

interface IncExpPresenterAPI {
    fun insertIncExp(bean:IncExpBean)
    fun readIncExp( )
}