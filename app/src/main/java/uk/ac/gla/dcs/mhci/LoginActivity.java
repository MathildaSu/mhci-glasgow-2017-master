package uk.ac.gla.dcs.mhci;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int RC_SIGN_IN = 123;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;

    public Button barcodestart;
    public Button nfcstart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        barcodestart = (Button) findViewById(R.id.barcodestart);
        nfcstart = (Button) findViewById(R.id.nfcstart);
        barcodestart.setOnClickListener(LoginActivity.this);
        nfcstart.setOnClickListener(LoginActivity.this);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    // do nothing for now
                } else {
                    startActivityForResult(
                            // Get an instance of AuthUI based on the default app
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                                    .setTosUrl("https://superapp.example.com/terms-of-service.html")
                                    .setTheme(R.style.AppTheme)
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
    }
    public void onClick(View v) {
        if (v.getId() == R.id.barcodestart) {
            // launch BarcodeActivity activity.
            Intent intent = new Intent(LoginActivity.this, BarcodeActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.nfcstart) {
            // launch BeaconActivity activity.
            Intent intent = new Intent(LoginActivity.this, BeaconActivity.class);
            startActivity(intent);
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
