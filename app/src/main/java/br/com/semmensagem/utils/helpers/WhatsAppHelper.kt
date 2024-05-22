package br.com.semmensagem.utils.helpers

import android.content.Context
import br.com.semmensagem.utils.to.WhatsAppMessageTO

class WhatsAppHelper(context: Context) {
    fun sendMessage(app: String, to: WhatsAppMessageTO) {
        if (app == "whatsapp") {
            sendMessageWhatsApp(to);
        }

        if (app == "business") {
            sendMessageWhatsAppBusiness(to);
    }
    }

    private fun sendMessageWhatsApp(to: WhatsAppMessageTO) {}

    private fun sendMessageWhatsAppBusiness(to: WhatsAppMessageTO) {}
}