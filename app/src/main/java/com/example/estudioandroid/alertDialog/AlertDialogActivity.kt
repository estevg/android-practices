package com.example.estudioandroid.alertDialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.estudioandroid.R
import com.example.estudioandroid.databinding.ActivityAlertDialogBinding

class AlertDialogActivity : AppCompatActivity() {

    lateinit var binding: ActivityAlertDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlertDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val simpleDialog = AlertDialog.Builder(this)
            .setTitle("Eliminar articulo")
            .setMessage("¿ Desea eliminar del carrito de compras el articulo seleccionado ?")
            .setIcon(R.drawable.ic_baseline_library_books_24)
            .setPositiveButton("ACEPTAR") { _, _ ->
                Toast.makeText(this, "Articulo eliminado", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("CANCELAR") { _, _ ->
                Toast.makeText(this, "Selecciono Cancelar", Toast.LENGTH_SHORT).show()
            }.create()


        binding.btnOne.setOnClickListener { simpleDialog.show() }

        val marcas = arrayOf("Xiaomi", "Samsung", "Pixel", "Nokia", "Iphone")

        val sigleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Seleccionar Marca")
            .setSingleChoiceItems(marcas, 0) { _, position ->
                Toast.makeText(this, "Marca seleccionada ${marcas[position]}", Toast.LENGTH_SHORT)
                    .show()
            }
            .setPositiveButton("ACEPTAR") { _, _ ->
                Toast.makeText(this, "Ha seleccionado aceptar", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("CANCELAR") { _, _ ->
                Toast.makeText(this, "Selecciono Cancelar", Toast.LENGTH_SHORT).show()
            }.create()

        binding.btnTwo.setOnClickListener { sigleChoiceDialog.show() }


        val lugares = arrayOf("Centro Comercial", "Cines", "Farmacias", "Gasolinas")

        val multipleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Seleccionar un lugar")
            .setMultiChoiceItems(
                lugares,
                booleanArrayOf(false, false, false, false)
            ) { _, position, select ->
                if (select) {
                    Toast.makeText(this, "Ha seleccionado ${lugares[position]}", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(this, "Ha deseseleccionada ${lugares[position]}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            .setPositiveButton("ACEPTAR") { _, _ ->
                Toast.makeText(this, "Ha seleccionado aceptar", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("CANCELAR") { _, _ ->
                Toast.makeText(this, "Selecciono Cancelar", Toast.LENGTH_SHORT).show()
            }.create()

        binding.btnThree.setOnClickListener { multipleChoiceDialog.show() }

    }
}