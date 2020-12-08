package ba.sum.fpmoz.pma.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import ba.sum.fpmoz.pma.R;
import ba.sum.fpmoz.pma.model.Student;

public class StudentAdapter extends FirebaseRecyclerAdapter<Student,StudentAdapter.studentHolder> {

    public StudentAdapter(@NonNull FirebaseRecyclerOptions<Student> options){
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull studentHolder holder, int position, @NonNull Student model) {
        holder.studentNameTxt.setText(model.getName());
        holder.studentSurnameTxt.setText(model.getSurname());
        holder.studentUIdTxt.setText(model.getUid());
    }

    @NonNull
    @Override
    public studentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_items,parent,false);
        return new StudentAdapter.studentHolder(itemView);
    }

    public class studentHolder extends RecyclerView.ViewHolder {

        TextView studentNameTxt;
        TextView studentSurnameTxt;
        TextView studentUIdTxt;

        public studentHolder(@NonNull View itemView) {
            super(itemView);
            studentNameTxt = itemView.findViewById(R.id.studentNameTxt);
            studentSurnameTxt = itemView.findViewById(R.id.studentSurnameTxt);
            studentUIdTxt = itemView.findViewById(R.id.studentUIdTxt);
        }
    }
}
