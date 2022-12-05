package model

import java.util.*

class Menu {

    fun menuInicial() {

        val entrada = Scanner(System.`in`)
        val contaCorrente = ContaCorrente(1)
        val contaPoupanca = ContaPoupanca(2)

        do {
            println("Bem-vindo!! \n\nSelecione a conta desejada: \n[1] - Conta Corrente: " +
                    "\n[2] - Conta Poupanca \n[3] - Encerrar")

            val valor = entrada.nextInt()

            when (valor) {
                1 -> menuContaCorrente(contaCorrente)
                2 -> menuContaPoupanca(contaPoupanca)
                3 -> println("Final do programa!!")
                else -> println("Digite uma opcao valida!!")
            }
        }while (valor != 3)
      System.exit(0)
    }

    fun menuDepositar(conta: ContaBancaria) {
        val entrada = Scanner(System.`in`)

        println("Informe o valor desejado para o deposito ou aperte [0] para cancelar a operacao: ")
        val valor = entrada.nextDouble()

        if(valor == 0.0) {
            menuInicial()
        }else {
            conta.depositar(valor)
        }


    }

    fun menuSacar(conta: ContaBancaria) {
        val entrada = Scanner(System.`in`)

        println("Informe o valor desejado para o saque ou aperte [0] para cancelar a operacao: ")
        val valor = entrada.nextDouble()

        if(valor == 0.0) {
            menuInicial()
        }else {
            conta.sacar(valor)
        }


    }

    fun menuContaCorrente(conta: ContaCorrente) {

        val entrada = Scanner(System.`in`)
        val relatorio = Relatorio()


        println("Bem vindo a Conta Corrente N. ${conta.numeroDaConta}! \n\nSelecione a transacao desejada: " +
                "\n[1] - Depositar \n[2] - Sacar \n[3] - Mostrar informacoes" +
                " \n[4] - Voltar ao menu inicial")

        val valor = entrada.nextInt()
        do {
            when (valor) {
                1 -> menuDepositar(conta)
                2 -> menuSacar(conta)
                3 -> {
                    relatorio.gerarRelatorio(conta)
                    menuContaCorrente(conta = conta)
                }
                4 -> menuInicial()
                else -> println("Opcao invalida!!")
            }
        }while (valor != 0)
    }

    fun menuContaPoupanca(conta: ContaPoupanca) {

        val entrada = Scanner(System.`in`)
        val relatorio = Relatorio()


        println("Bem vindo a Conta Poupanca N. ${conta.numeroDaConta}! \n\nSelecione a transacao desejada: " +
                "\n[1] - Depositar \n[2] - Sacar \n[3] - Mostrar informacoes" +
                " \n[4] - Voltar ao menu inicial")

        val valor = entrada.nextInt()

        do {
            when (valor) {
                1 -> menuDepositar(conta)
                2 -> menuSacar(conta)
                3 -> {
                    relatorio.gerarRelatorio(conta)
                    menuContaPoupanca(conta = conta)
                }
                4 -> menuInicial()
                else -> println("Opcao invalida!!")
            }
        }while (valor != 0)
    }

}