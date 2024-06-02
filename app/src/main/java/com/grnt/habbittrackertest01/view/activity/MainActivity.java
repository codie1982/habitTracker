package com.grnt.habbittrackertest01.view.activity;

import static androidx.navigation.Navigation.findNavController;
import static androidx.navigation.ui.AppBarConfigurationKt.AppBarConfiguration;
import static androidx.navigation.ui.NavigationUI.setupActionBarWithNavController;

import android.os.Bundle;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentContainer;
import androidx.navigation.NavController;

import com.grnt.habbittrackertest01.BaseActivity;
import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.data.HabitDao;

public class MainActivity extends BaseActivity {

    FragmentContainer fc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = findNavController(this, R.id.fragmentContainerView);
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}