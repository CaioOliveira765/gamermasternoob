package com.example.gamernoob.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import com.example.gamernoob.R
import com.example.gamernoob.Retrofit.RetrofitConfig
import com.example.gamernoob.model.Usuario
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.Callback
import okhttp3.ResponseBody

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val call = RetrofitConfig().loginService().buscarLogin()


        btnLogin.setOnClickListener() {

            val emailDigitado = email.getText().toString()
            val senhadigitada = senha.getText().toString()
            val usuarioLista = Usuario(emailDigitado, senhadigitada)

            var intent = Intent(this@LoginActivity, PlaylistActivity::class.java )
            startActivity(intent)

        }

    }

    private fun Usuario(senha: String, nome: String): Usuario {

    }
}
