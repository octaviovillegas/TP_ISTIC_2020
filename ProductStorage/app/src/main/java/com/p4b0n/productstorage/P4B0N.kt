package com.p4b0n.productstorage

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_p4_b0_n.*

class P4B0N : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p4_b0_n)


                btnContinuar.setOnClickListener {
                    val unIntento = Intent(this,LoginActivity::class.java)
                    startActivity(unIntento)

                }
                IbtnFacebook.setOnClickListener{
                    val uri = Uri.parse("http://www.facebook.com/")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                }

                IbtnGit.setOnClickListener{
                    val uri = Uri.parse("http://www.github.com/")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                }

                IbtnGmail.setOnClickListener{
                    val uri = Uri.parse("http://www.gmail.com/")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                }

                IbtnInstagram.setOnClickListener{
                    val uri = Uri.parse("http://www.instagram.com/")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                }

                IbtnLinkedin.setOnClickListener{
                    val uri = Uri.parse("http://www.linkedin.com/")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                }

                IbtnTwitter.setOnClickListener{
                    val uri = Uri.parse("http://www.twitter.com/")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                }

                IbtnYoutube.setOnClickListener{
                    val uri = Uri.parse("http://www.youtube.com/")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                }
            }
        }
