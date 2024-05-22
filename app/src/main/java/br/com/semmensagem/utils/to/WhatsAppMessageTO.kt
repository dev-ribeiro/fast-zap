package br.com.semmensagem.utils.to

data class WhatsAppMessageTO(
    var ddd: String, var phone: String, var message: String?
) {
    constructor(ddd: String, phone: String) : this(ddd, phone, null)
}

