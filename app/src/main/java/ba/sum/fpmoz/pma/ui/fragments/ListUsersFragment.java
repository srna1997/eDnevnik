package ba.sum.fpmoz.pma.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ba.sum.fpmoz.pma.R;
import ba.sum.fpmoz.pma.model.Student;
import ba.sum.fpmoz.pma.ui.adapters.StudentAdapter;

public class ListUsersFragment extends Fragment {

    DatabaseReference dbref;
    RecyclerView recyclerView;
    StudentAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View userListView = inflater.inflate(R.layout.activity_user_list,container,false);

        this.dbref = FirebaseDatabase.getInstance().getReference();
        this.recyclerView = userListView.findViewById(R.id.recyclerView);
        setUpRecyclerView();

        return userListView;
    }

    public void setUpRecyclerView(){
        FirebaseRecyclerOptions<Student> options = new FirebaseRecyclerOptions.Builder<Student>().setQuery(
                dbref.child("student"), new SnapshotParser<Student>() {
                    @NonNull
                    @Override
                    public Student parseSnapshot(@NonNull DataSnapshot snapshot) {
                        return snapshot.getValue(Student.class);
                    }
                }
        ).build();
        adapter = new StudentAdapter(options);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }
    }
}

/*
        FirebaseRecyclerOptions<Student> options = new FirebaseRecyclerOptions.Builder<Student>().setQuery(
                dbref.child("student"), new SnapshotParser<Student>() {
                    @NonNull
                    @Override
                    public Student parseSnapshot(@NonNull DataSnapshot snapshot) {
                        return snapshot.getValue(Student.class);
                    }
                }
        ).build();
        */
/*
        adapter = new FirebaseRecyclerAdapter<Student,StudentHolder>(options){

            @NonNull
            @Override
            public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_items,parent,false);
                return new StudentHolder(itemView);
            }

            @Override
            protected void onBindViewHolder(@NonNull StudentHolder holder, int position, @NonNull Student model) {
              holder.setStudent(model);
            }

        };
        recyclerView.setAdapter(adapter);
        */
