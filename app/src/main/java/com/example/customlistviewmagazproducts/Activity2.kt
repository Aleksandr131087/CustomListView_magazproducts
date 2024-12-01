package com.example.customlistviewmagazproducts

import android.app.ComponentCaller
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.IOException

class Activity2 : AppCompatActivity() {

    val GALERRY_REQUEST = 1
    private lateinit var toolbar: Toolbar
    var bitmap: Bitmap? = null
    val products: MutableList<Product> = mutableListOf()
    private lateinit var imageViewTV: ImageView
    private lateinit var ProductsNameET: EditText
    private lateinit var priceET: EditText
    private lateinit var addBTN: Button
    private lateinit var ListVewTV: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_2)

toolbar = findViewById(R.id.toolbar)
        title = "Корзина с продуктами"
        setSupportActionBar(toolbar)

        imageViewTV = findViewById(R.id.imageViewTV)
        ProductsNameET = findViewById(R.id.ProductsNameET)
        priceET = findViewById(R.id.priceET)
        addBTN = findViewById(R.id.addBTN)
        ListVewTV = findViewById(R.id.ListVewTV)
       imageViewTV.setOnClickListener {
val photo = Intent(Intent.ACTION_PICK)
           photo.type = "image/*"
           startActivityForResult(photo, GALERRY_REQUEST)
        }
        addBTN.setOnClickListener {
            val productname = ProductsNameET.text.toString()
            val priceproduct = priceET.text.toString()
            val imageproduct = bitmap
            val product = Product(productname, priceproduct, imageproduct)
            products.add(product)

            val ListAdapter = ListAdapter(this@Activity2, products)
            ListVewTV.adapter = ListAdapter
            ListAdapter.notifyDataSetChanged()
            ProductsNameET.text.clear()
            priceET.text.clear()
            imageViewTV.setImageResource(R.drawable.ic_launcher_foreground)

        }

    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        imageViewTV = findViewById(R.id.imageViewTV)
        when(requestCode){
            GALERRY_REQUEST->
            if (resultCode== RESULT_OK){
                val selectImage: Uri? = data?.data
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectImage)
                }catch (e: IOException){
                    e.printStackTrace()
                }
                imageViewTV.setImageBitmap(bitmap)

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_exit, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_exit -> finishAffinity()
        }
        return super.onOptionsItemSelected(item)
    }


}