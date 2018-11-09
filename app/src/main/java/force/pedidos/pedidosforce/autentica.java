package force.pedidos.pedidosforce;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;
import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

class autentica extends Activity {
    private String usuario, senha;

    public autentica(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;

    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }



    public boolean validaLogin() {

        //arrays que simulam o banco de usuarios.
        ArrayList<String> busuario = new ArrayList<String>();
        ArrayList<String> bsenha = new ArrayList<String>();
        busuario.add("andreilson");
        bsenha.add("andreilson");
        busuario.add("alyson");
        bsenha.add("alyson");
        busuario.add("davi");
        bsenha.add("davi");
        busuario.add("felipe");
        bsenha.add("felipe");
        busuario.add("dinah");
        bsenha.add("dinah");

        for (int i = 0; i < busuario.size(); i++) {
            if (busuario.get(i).equals(usuario) && bsenha.get(i).equals(senha)) {

              return true;
              }

            }

        return false;
       }

   }






