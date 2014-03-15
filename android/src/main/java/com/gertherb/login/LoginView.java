package com.gertherb.login;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.gertherb.R;
import com.novoda.notils.caster.Views;

import rx.Observable;
import rx.android.observables.ViewObservable;
import rx.functions.Func1;

public class LoginView extends LinearLayout {

    private EditText username;
    private EditText password;
    private Button login;

    public LoginView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate();
    }

    public LoginView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        inflate();
    }

    private void inflate() {
        inflate(getContext(), R.layout.view_login, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        username = Views.findById(this, R.id.login_edit_username);
        password = Views.findById(this, R.id.login_edit_password);
        login = Views.findById(this, R.id.login_button);
    }

    public Observable<UserCredentials> newLoginObservable() {
        return ViewObservable.clicks(login, false).map(new Func1<View, UserCredentials>() {

            @Override
            public UserCredentials call(View view) {
                return new UserCredentials(username.getText().toString(), password.getText().toString());
            }

        });
    }

}
