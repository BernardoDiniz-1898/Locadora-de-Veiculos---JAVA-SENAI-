# Sistema de Gerenciamento de Concessionária

Projeto Java de console para simular o gerenciamento de uma concessionária de veículos. O sistema permite cadastrar, listar, editar e vender veículos, além de gerenciar usuários em memória.

## Funcionalidades

- Cadastro inicial de usuário e senha.
- Menu principal com gerenciamento de veículos e usuários.
- Listagem, cadastro, venda e edição de veículos.
- Listagem, cadastro, inativação e edição de usuários.
- Dados armazenados em memória com `ArrayList`.

## Estrutura

```text
.
├── src/
│   └── br/com/senai/concessionaria/
│       ├── Main.java              # Ponto de entrada
│       ├── model/                 # Entidades (Veiculo, Usuario, StatusVeiculo)
│       ├── repository/            # Acesso aos dados em memória
│       ├── service/               # Regras de negócio
│       ├── view/                  # Menus e interação com o usuário
│       └── util/                  # Utilitários (leitura de input)
├── docs/                          # Documentação e materiais do projeto
├── build/classes/                 # Arquivos compilados gerados localmente
├── README.md
└── .gitignore
```

## Arquitetura em Camadas

| Camada | Responsabilidade |
| --- | --- |
| `model` | Entidades do domínio (`Veiculo`, `Usuario`, `StatusVeiculo`) |
| `repository` | Armazenamento e busca dos dados em memória |
| `service` | Regras de negócio (cadastrar, vender, editar, inativar) |
| `view` | Menus e leitura/exibição de dados no console |
| `util` | Utilitários de apoio (entrada de dados) |

## Requisitos

- JDK 17 ou superior

## Como Executar

Compile o projeto:

```bash
javac -d build/classes $(find src -name "*.java")
```

Execute a aplicação:

```bash
java -cp build/classes br.com.senai.concessionaria.Main
```

## Git Flow

O projeto segue o fluxo de branches descrito em [`docs/GITFLOW.md`](docs/GITFLOW.md):

- `main`: versões estáveis (releases).
- `develop`: integração contínua do desenvolvimento.
- `feature/*`: novas funcionalidades e refatorações.
- `release/*`: preparação de versões.
- `hotfix/*`: correções urgentes a partir da `main`.

## Documentação

- `docs/DESCRICAO.txt`: descrição curta do projeto.
- `docs/SETUP.txt`: comandos rápidos de instalação e execução.
- `docs/GITFLOW.md`: fluxo de branches e comandos Git.
- `docs/Fluxograma.pdf`: fluxograma do sistema.
