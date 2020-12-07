package ba.sum.fpmoz.pma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


import ba.sum.fpmoz.pma.ui.adapters.TabbedAdapter;

public class TabbedUserAdminActivity extends AppCompatActivity {

    TabLayout layout;
    ViewPager2 viewPager2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed_user_admin);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        this.layout = findViewById(R.id.tabLayout);
        this.viewPager2 = findViewById(R.id.viewPager2);
        this.viewPager2.setAdapter(new TabbedAdapter(this));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(layout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0: {
                        tab.setText("List Student");
                        break;
                    }
                    case 1: {
                        tab.setText("Add Student");
                        break;
                    }
                    case 2:{
                        tab.setText("Add Class");
                      break;
                    }
                    case 3:{
                        tab.setText("Add Teacher");
                        break;
                    }
                }
            }
        });
        tabLayoutMediator.attach();

    }

}