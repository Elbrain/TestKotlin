package uk.org.websolution.testkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var generateBtn : Button
    private lateinit var addBtn : Button
    private lateinit var generatedNumber : TextView
    private lateinit var editTextName : EditText
    private lateinit var editTexSurname : EditText
    private lateinit var personCreatedText : TextView
    private  var personList = mutableListOf<Person>()
    private var  count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        generateBtn = findViewById(R.id.generate_btn)
        addBtn = findViewById(R.id.add_person_btn)
        generatedNumber = findViewById(R.id.text_view_generated_num)
        editTextName = findViewById(R.id.editTextTextPersonName)
        editTexSurname = findViewById(R.id.editTextTextPersonSurname)
        personCreatedText = findViewById(R.id.text_view_persons_created)

        generateBtn.setOnClickListener {
            generateNumber()
        }

        addBtn.setOnClickListener {
            addPerson()
        }
    }

    private fun addPerson() {
        if (editTextName.text.isNotEmpty() && editTexSurname.text.isNotEmpty()){
            personList.add(Person(editTextName.text.toString(), editTexSurname.text.toString()))
            count++
            personCreatedText.text = count.toString()
        } else Toast.makeText(this, "Enter the data", Toast.LENGTH_SHORT).show()
    }

    private fun generateNumber() {
        generatedNumber.text = Random.nextInt(10).toString()
    }
}