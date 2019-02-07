package com.mayank.butterknife;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btnEnter)
    Button btnEnter;

    @BindView(R.id.btnShowList)
    Button btnShowList;

    @BindView(R.id.etUserName)
    EditText etUsername;

    @BindView(R.id.etPassword)
    EditText etPassword;

    @BindView(R.id.logo)
    ImageView imgLogo;

    @BindDrawable(R.drawable.ic_launcher_background)
    Drawable drawableBackground;

    @BindDrawable(R.mipmap.ic_launcher)
    Drawable drawableLogo;

    @BindViews({R.id.etUserName, R.id.etPassword})
    List<EditText> etInputs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding the view using Butter-Knife
        ButterKnife.bind(this);
    }

    // Check Edit Text Input
    final ButterKnife.Action<EditText> FOR_EMPTY_INPUTS = new ButterKnife.Action<EditText>() {
        @Override
        public void apply(EditText editText, int index) {
            if(TextUtils.isEmpty(editText.getText())){
                editText.setError(getString(R.string.error_input));
            }
        }
    };

    public boolean isInputEmpty() {
        for (EditText inputs : etInputs)
        {
            if (inputs.getText().toString().isEmpty())
                return true;
        }
        return false;
    }

    // check if both input's are empty
    private boolean isValidInputDetails() {
        if (isInputEmpty())
        {
            ButterKnife.apply(etInputs, FOR_EMPTY_INPUTS);
            return false;
        }
        return true;
    }

    /*
    * Same Event for Multiple Views
     */
    @OnClick({R.id.btnEnter, R.id.btnShowList})
    public void onButtonClick(View view) {

        // Validate the input fields
        if (isValidInputDetails())
            startActivity(new Intent(this, PhoneList.class));
    }
}