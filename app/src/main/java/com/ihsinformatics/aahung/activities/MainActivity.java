package com.ihsinformatics.aahung.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ihsinformatics.aahung.App;
import com.ihsinformatics.aahung.R;
import com.ihsinformatics.aahung.fragments.form.FormContract;
import com.ihsinformatics.aahung.fragments.login.LoginContract;
import com.ihsinformatics.aahung.network.ApiService;
import com.ihsinformatics.aahung.views.FormBuilder;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements FormContract.View {

    @Inject
    FormContract.Presenter presenter;

    @Inject
    FormBuilder formBuilder;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_form);
        ((App) getApplication()).getComponent().inject(this);
        presenter.takeView(this);
        setupForm((LinearLayout) findViewById(R.id.baselayout));
    }

    private void setupForm(LinearLayout baselayout) {
        FormBuilder formBuilder = new FormBuilder(MainActivity.this,baselayout);
        formBuilder.build();
    }

}
