# Conecta Local 🤝

Desenvolvido por: 
Sophia Machado Silva RA:24087451-2 |
Gabriel de Oliveira Gnoatto RA:23298801-2 |
Maria Eduarda Pereira  Ribeiro RA: 24224683-2

> Marketplace local de serviços que conecta trabalhadores informais a clientes da região.

**ODS 10 — Redução das Desigualdades** | AEP — Programação Orientada a Objetos

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
├── Main.java         # Ponto de entrada e menu interativo
├── Sistema.java      # Gerenciamento central (CRUD + protocolo)
├── Usuario.java      # Classe abstrata base
├── Prestador.java    # Herda Usuario — dados profissionais
├── Cliente.java      # Herda Usuario — contratação de serviços
├── Servico.java      # Serviço oferecido por um prestador
├── Solicitacao.java  # Pedido com ciclo de vida completo
└── Status.java       # Enum de estados da solicitação
```

## Como rodar

**Pré-requisito:** Java 17 ou superior instalado.

```bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/conecta-local.git
cd conecta-local/src

# 2. Compile todos os arquivos
javac *.java

# 3. Execute o sistema
java Main
```

## Conceitos de POO aplicados

| Conceito | Onde |
|---|---|
| Herança | `Prestador` e `Cliente` herdam de `Usuario` |
| Polimorfismo | `exibirPerfil()` sobrescrito em cada subclasse |
| Encapsulamento | Atributos privados com getters/setters |
| Abstração | Classe abstrata `Usuario` |
| Enum | `Status` para estados da solicitação |

## Clean Code — funções analisadas

### `cadastrarSolicitacao()`
Responsabilidade única: cria o objeto, gera protocolo e registra na lista. Nome descritivo e retorno claro.

### `listarServicos()`
Separa lógica (iteração) de exibição (delegada a `Servico.exibirDetalhes()`). Método pequeno e reutilizável.

### `atualizarStatus()`
Usa enum para evitar strings mágicas. Centraliza validação, garantindo consistência em todo o sistema.

---

**Desenvolvido como projeto AEP — Alinhado ao ODS 10 da ONU**
