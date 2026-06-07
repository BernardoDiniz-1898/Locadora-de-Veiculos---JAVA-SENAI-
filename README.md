# Sistema de Gerenciamento de Concessionaria

Projeto Java de console para simular o gerenciamento de uma concessionaria de veiculos. O sistema permite cadastrar, listar, editar e vender veiculos, alem de gerenciar usuarios em memoria.

## Funcionalidades

- Cadastro inicial de usuario e senha.
- Menu principal com gerenciamento de veiculos e usuarios.
- Listagem, cadastro, venda e edicao de veiculos.
- Listagem, cadastro, inativacao e edicao de usuarios.
- Dados armazenados em memoria com `ArrayList`.

## Estrutura

```text
.
├── src/              # Codigo-fonte Java
├── docs/             # Documentacao e materiais do projeto
├── build/classes/    # Arquivos compilados gerados localmente
├── README.md         # Visao geral do projeto
└── .gitignore        # Arquivos ignorados pelo Git
```

## Classes Principais

| Classe | Responsabilidade |
| --- | --- |
| `Concessioanaria` | Classe principal, menu e fluxo do sistema |
| `Veiculos` | Operacoes de estoque, cadastro, venda e edicao de veiculos |
| `Usuarios` | Operacoes de cadastro, edicao e inativacao de usuarios |

## Requisitos

- JDK 17 ou superior

## Como Executar

Compile o projeto:

```bash
javac -d build/classes src/*.java
```

Execute a aplicacao:

```bash
java -cp build/classes Concessioanaria
```

## Documentacao

- `docs/DESCRICAO.txt`: descricao curta do projeto.
- `docs/SETUP.txt`: comandos rapidos de instalacao e execucao.
- `docs/Fluxograma.pdf`: fluxograma do sistema.
