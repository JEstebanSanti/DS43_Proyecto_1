package com.example.convertidortemperatura2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // tipo de conversion
    private var conversion : Int = 0
    //variable del valor de temperatura capturada
    private var value: String = ""
    //Valor de resultado
    private var endResult : Double = 0.0

    private  lateinit var total : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val temp = findViewById<EditText>(R.id.editTextValor)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val botonConverter = findViewById<Button>(R.id.button)

        total = findViewById(R.id.resultado)

        val options = resources.getStringArray(R.array.convert_option)

        if (spinner != null){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
            spinner.adapter = adapter


            spinner.onItemSelectedListener = object:
                AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    conversion = position
                    //Toast.makeText(this@MainActivity, "opcionseleccionada " + position, Toast.LENGTH_SHORT).show()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    //TODO("Not yet implemented")
                }
            }


        }

        botonConverter.setOnClickListener(){
            value = temp.text.toString()
            converter(conversion)
        }

    }
    fun converter(conversion: Int) {
        when(conversion){
            0-> {
                //°Cto°F
                //Toast.makeText(this,"°C to F°",Toast.LENGTH_SHORT).show()
                //convertimos a double.
                //Aplicamos la formula
                endResult = ((value.toDouble() * 9/5) + 32)
                total.text = endResult.toString()
            }
            1->{
                endResult = ((value.toDouble()) + 273.15)
                total.text = endResult.toString()

            }
            2->{
                endResult = ((value.toDouble() -32) *5/9)
                total.text = endResult.toString()

            }
            3->{
                endResult = ((value.toDouble() -32) * 5/9 + 273.15)
                total.text = endResult.toString()
            }
            4->{
                endResult = ((value.toDouble()-273.15))
                total.text = endResult.toString()

            }
            5->{
                endResult = ((value.toDouble()-273.15) *9/5 +32)
                total.text = endResult.toString()
            }
        }
    }
}