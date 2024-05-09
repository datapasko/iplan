package com.tapascodev.iplan.employee.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.tapascodev.iplan.databinding.ItemEmployeeBinding
import com.tapascodev.iplan.employee.domain.Employee


class EmployeeViewHolder(
    view:View
): RecyclerView.ViewHolder(view) {

    private  val binding = ItemEmployeeBinding.bind(view)

    fun render (employee: Employee) {
        binding.apply {
            tvName.text = employee.name
            tvEmail.text = employee.email
            tvNumber.text = employee.number
            tvExtension.text = employee.extension

            ivPhone.setOnClickListener {
                shareCall(it.context, employee.number)
            }

            ivEmail.setOnClickListener {
                sendEmail(it.context, employee.email)
            }
        }
    }
    private fun shareCall(context: Context, number: String) {
        val call = Uri.parse("tel:$number")
        val intent2 = Intent(Intent.ACTION_DIAL, call)
        context.startActivity(intent2)
    }

    private fun sendEmail(context: Context, email: String) {

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            type = "message/rfc822"
        }

        val shareIntent = Intent.createChooser(sendIntent, "Send email")
        context.startActivity(shareIntent)
    }


}