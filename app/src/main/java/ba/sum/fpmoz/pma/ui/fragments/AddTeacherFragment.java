package ba.sum.fpmoz.pma.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ba.sum.fpmoz.pma.R;
import ba.sum.fpmoz.pma.model.Student;
import ba.sum.fpmoz.pma.model.Teacher;

public class AddTeacherFragment extends Fragment {
    FirebaseDatabase db;
    DatabaseReference ref;
    EditText teacherNameInp;
    EditText teacherSurnameInp;
    EditText teacherCourseInp;
    Button addTeacherBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View TeacherAdminView = inflater.inflate(R.layout.activity_teacher_admin,container,false);
        this.db = FirebaseDatabase.getInstance();
        this.ref = this.db.getReference("ednevnik/nastavnici");

        this.teacherNameInp = TeacherAdminView.findViewById(R.id.ClassNameInp);
        this.teacherSurnameInp = TeacherAdminView.findViewById(R.id.classTeacherInp);
        this.teacherCourseInp = TeacherAdminView.findViewById(R.id.teacherCourseInp);
        this.addTeacherBtn = TeacherAdminView.findViewById(R.id.AddClassBtn);

        addTeacherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teacherName = teacherNameInp.getText().toString();
                String teacherSurname = teacherSurnameInp.getText().toString();
                String teacherCourse = teacherCourseInp.getText().toString();
                ref.push().setValue(
                        new Teacher(teacherName,teacherSurname,teacherCourse)
                );
                teacherNameInp.setText("");
                teacherSurnameInp.setText("");
                teacherCourseInp.setText("");

                Toast.makeText(TeacherAdminView.getContext(),
                        "Uspješno ste dodali nastavnika",Toast.LENGTH_LONG).show();

            }
        });
        return TeacherAdminView;
    }
}
