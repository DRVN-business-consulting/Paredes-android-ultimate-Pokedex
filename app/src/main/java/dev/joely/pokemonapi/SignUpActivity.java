package dev.joely.pokemonapi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import dev.joely.pokemonapi.api.ApiClient;
import dev.joely.pokemonapi.api.UserApi;
import dev.joely.pokemonapi.dto.SignUpRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private EditText usernameEditText, nameEditText, passwordEditText, ageEditText, addressEditText;
    private Button signUpButton;
    private UserApi userApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        usernameEditText = findViewById(R.id.username);
        nameEditText = findViewById(R.id.name);
        passwordEditText = findViewById(R.id.password);
        ageEditText = findViewById(R.id.age);
        addressEditText = findViewById(R.id.address);
        signUpButton = findViewById(R.id.sign_up_button);

        userApi = ApiClient.getClient(this).create(UserApi.class);

        signUpButton.setOnClickListener(v -> signUp());
    }

    private void signUp() {
        String username = usernameEditText.getText().toString();
        String name = nameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String address = addressEditText.getText().toString();

        SignUpRequest signUpRequest = new SignUpRequest(username, name, password, Integer.parseInt(age), address);

        userApi.signUp(signUpRequest).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(SignUpActivity.this, "Sign up successful!", Toast.LENGTH_SHORT).show();
                    finish(); // Close the sign-up activity and return to the login activity
                } else {
                    Toast.makeText(SignUpActivity.this, "Sign up failed!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
