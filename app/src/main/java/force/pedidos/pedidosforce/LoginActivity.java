package force.pedidos.pedidosforce;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity  {

    private FirebaseAuth firebaseAuth;
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseApp firebaseApp = FirebaseApp.initializeApp(this);
        firebaseAuth = autoFireBase.getFirebaseAuth(firebaseApp);
        final Context context = this;
        // ativar botao que chama a class autentica.
        Button botao = (Button) findViewById(R.id.login);
        botao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText usuario;
                EditText senha;
                usuario = (EditText) findViewById(R.id.usuario);
                senha = (EditText) findViewById(R.id.senha);
                String usuarioUsado = usuario.getText().toString();
                String senhaUsada = criptografarSenha(senha.getText().toString().trim());
                login(usuarioUsado, senhaUsada);

            }
        });
     }

    private String criptografarSenha(String senha) {
        return senha;
    }

    private void login(String usuarioUsado, String senhaUsada) {
        if(usuarioUsado.isEmpty() || usuarioUsado == null || senhaUsada.isEmpty() || senhaUsada == null){
            alertaEmailSenha();
        }else {
            firebaseAuth.signInWithEmailAndPassword(usuarioUsado, senhaUsada)
                    .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent menu = new Intent(LoginActivity.this, MenuActivity.class);
                                startActivity(menu);
                            } else {
                                alertaEmailSenha();
                            }
                        }
                    });
        }

    }

    private void alertaEmailSenha() {
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(LoginActivity.this, "Email ou senha inválidos!", duration);
        toast.show();
    }
}