package cubex.mahesh.mvp_oct9am.view

import android.app.DatePickerDialog
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import cubex.mahesh.mvp_oct9am.R
import cubex.mahesh.mvp_oct9am.beans.IncExpBean
import cubex.mahesh.mvp_oct9am.model.IncExpModel
import cubex.mahesh.mvp_oct9am.presenter.IncExpPresenterAPI
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(),IncExpViewAPI {
    override fun insertResponse(msg: String) {
        Toast.makeText(this@MainActivity,
                msg,Toast.LENGTH_LONG).show()
      }

    override fun readResponse(c: Cursor) {

       var cAdapter = SimpleCursorAdapter(this@MainActivity,
               R.layout.indiview,c,
               arrayOf("date","money","type","_desc"),
               intArrayOf(R.id.date,R.id.money,R.id.type,R.id.desc),
               0)
        lview.adapter = cAdapter

        var income_sum = 0
        var expense_sum = 0
        while(c.moveToNext())
        {
            if(c.getString(4).equals("income")){
                        income_sum = income_sum+ c.getInt(2)
            }else{
                expense_sum = expense_sum+ c.getInt(2)
            }
        }
        tv1.text = income_sum.toString()
        tv2.text = expense_sum.toString()
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1.setOnClickListener {
        var listener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    et1.setText("$p3 - ${p2+1} - $p1")
            }
        }
            var cal = Calendar.getInstance()
            var year = cal.get(Calendar.YEAR)
            var month = cal.get(Calendar.MONTH)
            var day = cal.get(Calendar.DAY_OF_MONTH)
            // context,OnDateSetListener,year,month,day
            var dpd = DatePickerDialog(this@MainActivity, listener,
                    year,month,day)
            dpd.show()

        }
        b2.setOnClickListener {
            var api:IncExpPresenterAPI = IncExpModel(
                                                                            this@MainActivity)
            var bean = IncExpBean(et1.text.toString(),
                                et2.text.toString().toInt(),
                                et3.text.toString(),sp1.selectedItem.toString())
            api.insertIncExp(bean)

        }
        b3.setOnClickListener {
            var api:IncExpPresenterAPI = IncExpModel(
                    this@MainActivity)
            api.readIncExp()
        }

    }
}
