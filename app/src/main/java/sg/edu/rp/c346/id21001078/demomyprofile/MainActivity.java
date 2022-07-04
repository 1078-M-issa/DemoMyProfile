package sg.edu.rp.c346.id21001078.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.ET1);
        etGPA = findViewById(R.id.ET2);
        
    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());

        SharedPreferences Pref = getPreferences(MODE_PRIVATE);

        SharedPreferences .Editor prefEdit = Pref.edit();

        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);

        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        String strName = pref.getString("name", "john");
        float gpa = pref.getFloat("gpa", 0);

        etName.setText(strName);
        etGPA.setText(gpa + "");


    }
}