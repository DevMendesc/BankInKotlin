package model


class ContaCorrente(numeroDaConta: Int, saldo: Double = 0.0, val taxaDeOperacao: Double = 1.5/100) :
    ContaBancaria(numeroDaConta, saldo) {

    val menu = Menu()


    override fun sacar(valor: Double) {
        val taxa = valor * taxaDeOperacao
        if (valor > saldo) {
            println("Operação invalida!" +
                    "\nSaldo insuficiente " +
                    "\nSeu saldo atual é: $saldo")

            menu.menuContaCorrente(conta = this)
        }
        else if (valor <= 0){
            println("Operação invalida!" +
                    "\nValores negativos nao sao permitidos! " +
                    "\nSeu saldo atual é: $saldo")

            menu.menuContaCorrente(conta = this)

        } else{

            saldo -= valor + valor * taxaDeOperacao
            println("Operação realizada com sucesso! \nValor de saque:R$ $valor" +
                    "\nTaxa de operação:R$ $taxa" +
                    "\nSeu saldo atual é:R$ $saldo\n")

            menu.menuContaCorrente(conta = this)
        }
    }


   override fun depositar(valor: Double) {
        val taxa = valor * taxaDeOperacao
        if (valor <= 0) {
            println("Operação invalida! \nDigite um valor de deposito valido!")

            menu.menuContaCorrente(conta = this)
        }else {
            saldo += valor - taxa
            println("Operação realizada com sucesso! \nValor de deposito:R$ $valor" +
                    "\nTaxa de operação:R$ $taxa" +
                    "\nSeu saldo atual é:R$ $saldo\n")

            menu.menuContaCorrente(conta = this)
        }
    }

    override fun toString(): String {
        return "\n[Conta: $numeroDaConta \nSaldo: $saldo \nTaxa da conta: $taxaDeOperacao]\n"
    }

}