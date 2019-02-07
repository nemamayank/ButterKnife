package com.mayank.butterknife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class TestFragment extends Fragment {
    Unbinder unbinder;

    @BindView(R.id.btnEnter)
    Button btnEnter;

    @BindView(R.id.etUserName)
    EditText inputName;

    public TestFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.test_fragment, container, false);

        // bind view using ButterKnife
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // unbind the view to free some memory
        unbinder.unbind();
    }

    @OnClick(R.id.btnEnter)
    public void onButtonClick(View view) {
        if (TextUtils.isEmpty(inputName.getText())) {
            Toast.makeText(getActivity(),
                    getString(R.string.toast_enter_input),
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(),
                    getString(R.string.toast_entered) + inputName.getText().toString(),
                    Toast.LENGTH_SHORT).show();
        }
    }

}
