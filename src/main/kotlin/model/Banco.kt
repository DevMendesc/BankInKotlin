package model

class Banco {

    val lista = mutableListOf<ContaBancaria>()



    fun inserirConta(conta: ContaBancaria) {
        lista.add(conta)
        lista.sortBy {
            it.numeroDaConta
        }

    }

        fun removerConta(conta: ContaBancaria) {
            lista.remove(conta)
            lista.sortBy {
                it.numeroDaConta
            }
        }

        fun procurarConta(conta: Int) {
            var achouConta = false
            for (acharConta in lista) {
                if (acharConta.numeroDaConta == conta) {
                    achouConta = true
            }
        }
            if (achouConta == true) {
                print("Conta $conta encontrada\n\n")
            }
            else{
                print("Conta $conta não encontrada\n\n")
            }
        }
}
