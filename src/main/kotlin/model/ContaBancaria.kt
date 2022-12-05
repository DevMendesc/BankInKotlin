package model

import java.util.*

abstract class ContaBancaria(val numeroDaConta: Int, var saldo: Double) {

    abstract fun sacar(valor: Double)

    abstract fun depositar(valor: Double)

    fun mostrarDados(): String {
        return "Numero da conta: $numeroDaConta " +
                "\nSaldo: $saldo\n\n"
    }

    fun transferir(contaBancaria : ContaBancaria, valor: Double) {

        sacar(valor)
        if (valor < saldo) {
            contaBancaria.depositar(valor)
        }
    }
}