package ba.sum.fpmoz.pma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ba.sum.fpmoz.pma.model.Student;

public class UserAdminActivity extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference ref;
    EditText studentNameInp;
    EditText studentSurNameInp;
    EditText studentUIdInp;
    Button addStudentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_admin);

        this.db = FirebaseDatabase.getInstance();
        this.ref = this.db.getReference("ednevnik/ucenici");

        this.studentNameInp = findViewById(R.id.ClassNameInp);
        this.studentSurNameInp = findViewById(R.id.classTeacherInp);
        this.studentUIdInp = findViewById(R.id.teacherCourseInp);
        this.addStudentBtn = findViewById(R.id.AddClassBtn);

        addStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentName = studentNameInp.getText().toString();
                String studentSurname = studentSurNameInp.getText().toString();
                String studentUId = studentUIdInp.getText().toString();
                ref.push().setValue(
                        new Student(studentName,studentSurname,studentUId)
                );
                studentNameInp.setText("");
                studentSurNameInp.setText("");
                studentUIdInp.setText("");

                Toast.makeText(getApplicationContext(),
                        "Uspješno ste dodali učenika",Toast.LENGTH_LONG).show();

            }
        });
    }
}