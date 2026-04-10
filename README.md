# Conecta Local 🤝

Desenvolvido por: 
Sophia Machado Silva RA:24087451-2 |
Gabriel de Oliveira Gnoatto RA:23298801-2 |
Maria Eduarda Pereira  Ribeiro RA: 24224683-2

> Marketplace local de serviços que conecta trabalhadores informais a clientes da região.

**ODS 10 — Redução das Desigualdades**

---

## Sobre o projeto

Muitos trabalhadores informais possuem habilidades mas não têm acesso a meios eficazes de divulgação. O **Conecta Local** resolve isso criando uma ponte digital entre prestadores de serviço e clientes locais, promovendo inclusão econômica e digital.

## Funcionalidades

- Cadastro de prestadores de serviço e clientes
- Listagem e filtragem de serviços por categoria
- Criação de solicitações com geração automática de protocolo
- Consulta de solicitação por protocolo
- Atualização de status via enum (`ABERTA`, `EM_ANDAMENTO`, `FINALIZADA`, `CANCELADA`)

## Estrutura do projeto

```
src/
├── ui.Main.java         # Ponto de entrada e menu interativo
├── services.Sistema.java      # Gerenciamento central (CRUD + protocolo)
├── models.Usuario.java      # Classe abstrata base
├── models.Prestador.java    # Herda models.Usuario — dados profissionais
├── models.Cliente.java      # Herda models.Usuario — contratação de serviços
├── services.Servico.java      # Serviço oferecido por um prestador
├── services.Solicitacao.java  # Pedido com ciclo de vida completo
└── models.Status.java       # Enum de estados da solicitação
```

## Como rodar

**Pré-requisito:** Java 17 ou superior instalado.

```bash
# 1. Clone o repositório
git clone https://github.com/GnoattoGabriel/AEP-5S-p1
cd conecta-local/src

# 2. Compile todos os arquivos
javac *.java

# 3. Execute o sistema
java ui.Main
```


---

**Desenvolvido como projeto AEP — Alinhado ao ODS 10 da ONU**
