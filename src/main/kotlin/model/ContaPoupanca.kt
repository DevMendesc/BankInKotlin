package model

class ContaPoupanca(numeroDaConta: Int, saldo: Double = 0.0, var creditoAtual: Double = 250.0, var creditoTotal: Double = 250.0) :
    ContaBancaria(numeroDaConta,saldo) {

    val menu = Menu()


    override fun sacar(valor: Double) {

        if(valor > saldo + creditoAtual) {
            println("Operação invalida!" +
                    "\nSaldo insuficiente " +
                    "\nSeu saldo atual é: $saldo" +
                    "\nSeu credito disponivel é:R$ $creditoAtual\n")

            menu.menuContaPoupanca(conta = this)

        }
        else if(valor > saldo && valor < saldo + creditoAtual) {
            saldo -= valor
            creditoAtual += saldo
            saldo = 0.0

            println("Operação realizada com sucesso! " +
                    "\nValor de saque:R$ $valor" +
                    "\nSeu saldo atual é: $saldo" +
                    "\nSeu credito disponivel é:R$ $creditoAtual\n")

            menu.menuContaPoupanca(conta = this)
        }else {

            saldo -= valor

            println("Operação realizada com sucesso! " +
                    "\nValor de saque:R$ $valor" +
                    "\nSeu saldo atual é: $saldo" +
                    "\nSeu credito disponivel é:R$ $creditoAtual\n")

            menu.menuContaPoupanca(conta = this)
        }
    }

    override fun depositar(valor: Double) {
        if (valor <= 0) {
            println("Operação invalida! " +
                    "\nDigite um valor de deposito valido!\n")

            menu.menuContaPoupanca(conta = this)
        }
        else if (creditoAtual < creditoTotal) {
            val valorDesconto = creditoTotal - creditoAtual
            val valorDescontoPago = valor - valorDesconto

            if (valorDescontoPago <= 0) {
                creditoAtual += valor
            }else {
                creditoAtual = creditoTotal
                saldo += valorDescontoPago
            }

            println("Operação realizada com sucesso! " +
                    "\nValor de deposito:R$ $valor" +
                    "\nSeu saldo atual é: $saldo" +
                    "\nSeu credito disponivel é:R$ $creditoAtual\n")

            menu.menuContaPoupanca(conta = this)
        }
        else {
            saldo += valor

            println("Operação realizada com sucesso! " +
                    "\nValor de deposito:R$ $valor" +
                    "\nSeu saldo atual é: $saldo" +
                    "\nSeu credito disponivel é:R$ $creditoAtual\n")

            menu.menuContaPoupanca(conta = this)

        }

    }

    override fun toString(): String {
        return "\n[Conta: $numeroDaConta \nSaldo: $saldo \nLimite total: $creditoTotal]\n"
    }
}