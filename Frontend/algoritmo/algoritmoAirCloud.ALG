algoritmo "cadastro_clientes_air_cloud"
// Disciplina   : Iniciação ao Mundo da Computação,
//Programação de Computadores e Front-end Fundamentos

var

   nomes: vetor[0..4] de caractere
   cpf: vetor[0..4] de inteiro
   destino: vetor[0..4] de caractere
   op, nome: caractere
   i, j, s: inteiro

// Tela inicial
procedimento inicializa()

inicio

   enquanto op <> "3" faca

      escreval("____________Cadastro de Clientes____________")
      escreval()
      escreval("____________________________________________")
      escreval("------------------- MENU -------------------")
      escreval("____________________________________________")
      escreval()
      escreval("(1) Cadastrar cliente")
      escreval("(2) Buscar cliente")
      escreval("(3) Sair")
      escreval()

      escreva("Digite o número da opção desejada para prosseguir: ")
      leia(op)

      se op="1" entao
         limpatela

         se s=10 entao
            escreval("Limite de cadastros atingido!")

         senao
            cadastrar_cliente()
         fimse
      fimse


      se op="2" entao
         limpatela
         buscar_cliente()
      fimse



      se op="3" entao
         para i de 0 ate 4 faca
            nomes[i] <- "x"
         fimpara
         limpatela

         escreval("-- Obrigado pela preferência! --")
      fimse
      
   fimenquanto

fimprocedimento

// Tela de cadastro de clientes
procedimento cadastrar_cliente()

inicio

   para i de 0 ate 4 faca

      se (nomes[i]="") entao
         escreval("Cadastro de Cliente")
         escreval()
         
         escreva("Nome: ")
         leia(nomes[i])

         escreva("CPF (apenas números): ")
         leia(cpf[i])

         escreva("Destino: ")
         leia(destino[i])

         escreval()

         voltar_menu()

         s <- s + 1

         limpatela
      fimse
   fimpara

   escreval(" -> Limite de cadastros atingido! <-")
   escreval()

fimprocedimento

procedimento voltar_menu()

inicio

   escreva("Voltar para a tela inicial? (s/n)? ")
   leia(op)

   se op="s" entao

      i <- i + 1

      limpatela

      inicializa()

   senao
      limpatela

      cadastrar_cliente()
   fimse
fimprocedimento


procedimento buscar_cliente()

// Tela de consulta de cadastros
inicio

   j <- 0

   escreval("Consultar cadastro")
   escreval()

   escreva("Informe o nome do(a) cliente: ")
   leia(nome)
   escreval()

   para i de 0 ate 4 faca

      se (nome=nomes[i]) entao

         escreval("-> Nome: ", nomes[i])
         escreval("-> CPF: ", cpf[i])
         escreval("-> Destino: ", destino[i])
         escreval()

         j <- j + 1

      fimse
   fimpara

   se (j = 0) entao

      escreval("Cliente não cadastrado!")
      escreval()

   fimse

   Voltar_menu2()

   limpatela

fimprocedimento

procedimento voltar_menu2()

inicio

   Escreva("Voltar para a tela inicial? (s/n)? ")
   leia(op)


   se op="s" entao
      limpatela

      inicializa()

   senao
      limpatela
      buscar_cliente()
   fimse
fimprocedimento

inicio

   inicializa()

fimalgoritmo