package com.example.project1;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class CreateTask extends AppCompatActivity {

    private static final String BACK_STACK_ROOT_TAG = "root_fragment";
    FrameLayout frameLayout;
    FragmentManager fragmentManager;
    Fragment fragment = null;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_task_activity);

        frameLayout = findViewById(R.id.task_fragment_host);
        fragment = new CreateTaskFragment1();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.task_fragment_host, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

    }

    public void addFragmentOnTop(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.task_fragment_host, fragment)
                .addToBackStack(null)
                .commit();
    }
}
