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
    FirebaseDatabase db;
    DatabaseReference ref;
    RecyclerView recyclerView;
    StudentAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View userListView = inflater.inflate(R.layout.activity_user_list,container,false);

        this.recyclerView = userListView.findViewById(R.id.recyclerView);

        this.db = FirebaseDatabase.getInstance();
        this.ref = this.db.getReference("ednevnik/ucenici");
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<Student> options = new FirebaseRecyclerOptions
                .Builder<Student>()
                .setQuery(this.ref, Student.class).build();
        this.adapter = new StudentAdapter(options);
        this.recyclerView.setAdapter(this.adapter);

        return userListView;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }
    }
}