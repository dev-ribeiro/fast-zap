package br.com.semmensagem.utils.helpers

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import br.com.semmensagem.utils.to.WhatsAppMessageTO

class WhatsAppHelper(context: Context) {
    private val ctx = context;
    private val BASE_API_WHATSAPP_URL = "https://wa.me"
    fun sendMessage(app: String, to: WhatsAppMessageTO): Boolean {
        if (app == "whatsapp") {
            val whatsAppPackageName = "com.whatsapp"
            val notFoundWhatsAppPackageMessage = "WhatsApp não instalado."
            return handlerSendMessage(
                whatsAppPackageName, to, notFoundWhatsAppPackageMessage
            );
        }

        if (app == "business") {
            val businessPackageName = "com.whatsapp.w4b"
            val notFoundBusinessPackageMessage = "WhatsApp Business não instalado."
            return handlerSendMessage(
                businessPackageName, to, notFoundBusinessPackageMessage
            );
        }

        return false
    }

    private fun isAppInstalled(packageName: String): Boolean {
        return try {
            ctx.packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    private fun handlerSendMessage(
        packageName: String,
        to: WhatsAppMessageTO,
        notFoundMessage: String
    ): Boolean {
        val phone = "+55${to.ddd}${to.phone}"
        var uri = "$BASE_API_WHATSAPP_URL/$phone"
        if (!to.message.isNullOrEmpty()) {
            uri += "?text=${to.message}"
        }

        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(uri))
        intent.setPackage(packageName)

        if (isAppInstalled(packageName)) {
            ctx.startActivity(intent);
            return true
        } else {
            Toast.makeText(
                ctx, notFoundMessage, Toast.LENGTH_LONG
            ).show()
            return false
        }
    }
}