package com.example.zhiyicx.justdodagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainPresenter presenter;

    MainFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        fragment = new MainFragment();

        DaggerComponent
                .builder()
                .presenterModule(new PresenterModule(fragment))
                .build()
                .inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFragrnt();
        presenter.doA();
    }

    public void setFragrnt() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame, fragment)
                .commit();
    }
}
