package com.example.firebasept

import android.app.Activity
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.firebasept.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class MainActivity : AppCompatActivity() {

    private val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    public override fun onStart() {
        super.onStart()
        val account=FirebaseAuth.getInstance().currentUser
        if(account !== null)
        {
            supportFragmentManager.beginTransaction().add(R.id.frame,LogoutFragment()).commit()
            //어플 처음 실행시에 로그인 되어있는지 확인 (자동 로그인)
        }
        else if(account == null)
        {
            supportFragmentManager.beginTransaction().add(R.id.frame,LoginFragment()).commit()
        }
    }
}