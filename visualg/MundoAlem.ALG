Algoritmo "semnome"
const
  min_cliente=0
  min_destino=0
  max_cliente=3
  max_destino=3
Var
  achou: logico
  nome_cliente, destino_cliente, procurado: caracter
  vetor_cli: vetor[min_cliente..max_cliente] de caracter
  vetor_dest: vetor[min_destino..max_destino] de caracter
  res1, res2: caracter
  cont_cli, cont_dest,opcao, ind: inteiro
Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
  escreval("Selecione a opção: 1 - Cadastrar  2 - Pesquisar 3 - Cancelar")
  leia(opcao)
  enquanto opcao<>3  faca
    escolha(opcao)
    
   caso 1
   enquanto opcao=1 faca
    escreval()
    escreva("seu nome: ")
    leia(nome_cliente)
    escreva("seu destino: ")
    leia(destino_cliente)

     vetor_cli[cont_cli]<-nome_cliente
      res1<- vetor_cli[cont_cli]
     vetor_dest[cont_dest]<-destino_cliente
      res2<-vetor_dest[cont_dest]
    
    escreval()
    escreval("Nome: ",res1, " Destino: ",res2)
      cont_cli<-cont_cli+1
      cont_dest<-cont_dest+1
      
    escreval()
    escreval("Selecione a opção: 1 - Cadastrar  2 - Pesquisar 3 - Cancelar")
    leia(opcao)
    fimenquanto
    
   caso 2
        escreval()
        escreva("Digite o nome ou destino procurado: ")
        leia(procurado)
        
         ind<-0
         achou <- falso
         
        para ind de min_cliente ate max_cliente faca
         para ind de min_destino ate max_destino faca
         
          se((vetor_cli[ind] = procurado) ou (vetor_dest[ind] = procurado)) entao
               achou<-verdadeiro
               res1 <- vetor_cli[ind]
               res2 <- vetor_dest[ind]
          fimse
          
          ind <- ind+1
          
         fimpara
        fimpara
        
        se achou = verdadeiro entao
            escreval(" Nome: ", res1, " Destino: ", res2)
          senao
            escreval("Não encontrado.")
        fimse
        
        escreval()
        escreval("Selecione a opção: 1 - Cadastrar  2 - Pesquisar 3 - Cancelar")
        leia(opcao)
        
    caso 3
         opcao <- 3
    outrocaso
         escreval("Opção Inválida!")
         
         escreval()
         escreval("Selecione a opção: 1 - Cadastrar  2 - Pesquisar 3 - Cancelar")
         leia(opcao)
         
  fimescolha
  fimenquanto
Fimalgoritmo