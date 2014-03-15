package com.gertherb.login;

import android.os.Bundle;

import com.gertherb.R;
import com.gertherb.base.GertHerbActivity;
import com.novoda.notils.caster.Views;
import com.novoda.notils.logger.toast.Toaster;

import rx.Observer;

public class LoginActivity extends GertHerbActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginView loginView = Views.findById(this, R.id.login_view);
        loginView.newLoginObservable().subscribe(loginObserver());
    }

    private Observer<UserCredentials> loginObserver() {
        return new Observer<UserCredentials>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserCredentials userCredentials) {
                new Toaster(LoginActivity.this).popToast("W0oo0h0o0OOoo");
            }
        };
    }

}
