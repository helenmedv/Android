package helen.personal.education

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var buttonClickAction = findViewById<Button>(R.id.button_activity_main_action)
//        var textResult = findViewById<TextView>(R.id.textView_activity_main_result)
//        var textName = findViewById<EditText>(R.id.editText_activity_main_person_name)
//
//
//        buttonClickAction.setOnClickListener{
//            var txt : String = textName.text.toString()
//
//            var isRight : Boolean = txt.any(){it.isDigit()}
//            if (isRight){
//                textResult.setTextColor(resources.getColor(R.color.colorRed))
//                textResult.setText(R.string.wrong_name)
//            }
//            else {
//                textResult.setTextColor(resources.getColor(R.color.colorBlack))
//                textResult.setText(R.string.right_name)
//            }
//        }

        var textName = findViewById<EditText>(R.id.editText_activity_main_name)
        var textEmail = findViewById<EditText>(R.id.editText_activity_main_emailAddress)
        var textPassword = findViewById<EditText>(R.id.editText_activity_main_password)
        var textPasswordConfirm = findViewById<EditText>(R.id.editText_activity_main_password_confirm)
        var buttonRegistration = findViewById<Button>(R.id.button_activity_main_registration)
        var textResult = findViewById<TextView>(R.id.textView_activity_main_show_result)

        textName.text.clear()
        textEmail.text.clear()
        textPassword.text.clear()
        textPasswordConfirm.text.clear()

        buttonRegistration.setOnClickListener{

            var nameIsEmpty : Boolean = textName.text.isEmpty()
            var emailIsEmpty : Boolean = textEmail.text.isEmpty()
            var passwordIsEmpty : Boolean = textPassword.text.isEmpty()
            var nameContainsDigit : Boolean = textName.text.toString().any(){it.isDigit()}

            if (nameIsEmpty|| emailIsEmpty || passwordIsEmpty){

                textResult.setTextColor(resources.getColor(R.color.colorRed))
                textResult.setText(R.string.field_empty)
            }
            else if (!nameContainsDigit){
                textResult.setTextColor(resources.getColor(R.color.colorRed))
                textResult.setText(R.string.name_contains_digit)
            }
            else if (textPassword.text.toString() != textPasswordConfirm.text.toString()){
                textResult.setTextColor(resources.getColor(R.color.colorRed))
                textResult.setText(R.string.equals_passwords)
            }
            else {
                textResult.setTextColor(resources.getColor(R.color.colorBlack))
                textResult.setText(R.string.right_name)
            }
        }
    }
}