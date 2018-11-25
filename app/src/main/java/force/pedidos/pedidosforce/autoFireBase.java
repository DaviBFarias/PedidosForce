package force.pedidos.pedidosforce;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.*;

public class autoFireBase {
    private static FirebaseAuth firebaseAuth;
    private static FirebaseAuth.AuthStateListener authStateListener;
    private static FirebaseUser firebaseUser;
    private static boolean isLoged;

    private autoFireBase() {
    }

    public static FirebaseAuth getFirebaseAuth(FirebaseApp FirebaseApp) {
        if (firebaseAuth == null) {
            iniciarFirebase(FirebaseApp);
        }
        return firebaseAuth;
    }

    public static void iniciarFirebase(FirebaseApp FirebaseApp) {
        firebaseAuth = new FirebaseAuth(FirebaseApp);
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    firebaseUser = user;
                    Log.d("AUTH", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    Log.d("AUTH", "onAuthStateChanged:signed_out");
                }
            }
        };
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    public static FirebaseUser getFirebaseUser() {
        return firebaseUser;
    }

    public static void logOut() {
        firebaseAuth.signOut();
    }

}
