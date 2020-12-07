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

public class AddUsersFragment extends Fragment {
    FirebaseDatabase db;
    DatabaseReference ref;
    EditText studentNameInp;
    EditText studentSurNameInp;
    EditText studentUIdInp;
    Button addStudentBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View userAdminView = inflater.inflate(R.layout.activity_user_admin,container,false);

        this.db = FirebaseDatabase.getInstance();
        this.ref = this.db.getReference("ednevnik/ucenici");

        this.studentNameInp = userAdminView.findViewById(R.id.ClassNameInp);
        this.studentSurNameInp = userAdminView.findViewById(R.id.classTeacherInp);
        this.studentUIdInp = userAdminView.findViewById(R.id.teacherCourseInp);
        this.addStudentBtn = userAdminView.findViewById(R.id.AddClassBtn);

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

                Toast.makeText(userAdminView.getContext(),
                        "Uspješno ste dodali učenika",Toast.LENGTH_LONG).show();

            }
        });
        return userAdminView;
    }


}
