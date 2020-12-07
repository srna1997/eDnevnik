package ba.sum.fpmoz.pma.ui.adapters;

import android.view.ViewGroup;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ba.sum.fpmoz.pma.ui.fragments.AddClassFragment;
import ba.sum.fpmoz.pma.ui.fragments.AddTeacherFragment;
import ba.sum.fpmoz.pma.ui.fragments.AddUsersFragment;
import ba.sum.fpmoz.pma.ui.fragments.ListUsersFragment;

public class TabbedAdapter extends FragmentStateAdapter {

    public TabbedAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ListUsersFragment();
            case 1:
                return new AddUsersFragment();
            case 2:
                return new AddClassFragment();
            default:
                return new AddTeacherFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}