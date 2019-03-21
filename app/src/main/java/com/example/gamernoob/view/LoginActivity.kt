package  com.exemples.gamernoob.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.gamernoob.R
import com.example.gamernoob.view.PlaylistActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import kotlinx.android.synthetic.main.activity_login.*
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import java.util.*
import javax.security.auth.AuthPermission


class LoginActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener {
    override fun onConnectionFailed(connectionResult : ConnectionResult) {
    Log.d("bett", "onConnectionFailed:" + connectionResult)
    }

    private val RC_SIGN_IN = 9001
    private var mGoogleApiCliente: GoogleApiClient? = null
    var callbackMAnager: CallbackManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        FacebookSdk.sdkInitialize(applicationContext)
        AppEventsLogger.activateApp(this)

        btnLoginFacebook.setOnClickListener(View.OnClickListener {
            callbackMAnager = CallbackManager.Factory.create()
            LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public profile", "email"))
            LoginManager.getInstance().registerCallback(callbackMAnager,
                object  : FacebookCallback<LoginResult>{
                    override fun onSuccess(loginResult: LoginResult?) {
                            Log.d("LoginActivity", "Facebook token: " +  loginResult?.accessToken?.token)
                            startActivity(Intent(applicationContext, PlaylistActivity::class.java))
                    }

                    override fun onCancel() {
                        Log.d("LoginActivity", "Facebook cancel.")
                    }

                    override fun onError(error: FacebookException?) {
                        Log.d("LoginActivity", "Facebook cancel.")
                    }
                }
        })








        updateUI(false)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        mGoogleApiCliente = GoogleApiClient.Builder(this)
            .enableAutoManage(this, this)
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            .build()

        loginGoogle?.setOnClickListener(View.OnClickListener {
            var googleIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiCliente)
            startActivityForResult(googleIntent, RC_SIGN_IN)

            loginGoogle.setOnClickListener(){
                val intent = Intent(this@LoginActivity, PlaylistActivity::class.java)
                startActivity(intent)
            }
        })
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN){
            var result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            updateUI(result.isSuccess)
        }

    }

    private fun updateUI(isLogin: Boolean) {
        if (isLogin){
        }
    }

}

