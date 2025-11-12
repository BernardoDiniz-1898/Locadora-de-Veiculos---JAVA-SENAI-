# 🚗 Sistema de Gerenciamento de Concessionária

Este projeto é um sistema simples de **gerenciamento de veículos e usuários** feito em **Java (console)**.  
O objetivo é simular as operações básicas de uma concessionária, permitindo o **cadastro, listagem, edição e venda de veículos**, além do **cadastro e gerenciamento de usuários**.

---

## 🧠 Funcionalidades

### 🔹 Módulo de Veículos
- Listar veículos disponíveis e vendidos.  
- Cadastrar novos veículos.  
- Vender veículos (atualizando o status).  
- Editar informações do veículo (modelo, marca, ano, preço).  
- Exibir veículos pré-cadastrados no estoque.

### 🔹 Módulo de Usuários
- Listar usuários (pré-cadastrados e novos).  
- Cadastrar novos usuários.  
- Inativar usuários existentes.  
- Editar informações de usuários (nome, telefone, CPF, data da última compra).

### 🔹 Acesso ao Sistema
- Criação de **usuário e senha** com validação:
  - Nome de usuário com **mínimo de 7 caracteres**.  
  - Senha com **mínimo de 8 caracteres**.  
- Após o login, o usuário é direcionado ao **Menu Principal** com todas as opções do sistema.

---

## 🏗️ Estrutura do Projeto

O projeto é dividido em três classes principais:

| Classe | Responsabilidade |
|--------|------------------|
| `Concessioanaria` | Classe principal, responsável pelo menu e fluxo do sistema |
| `Veiculos` | Gerencia as operações de veículos (estoque, cadastro, venda e edição) |
| `Usuarios` | Gerencia as operações de usuários (cadastro, edição e inativação) |

---

## 💻 Tecnologias Utilizadas

- **Java SE 17+**
- **Scanner** (entrada de dados via console)
- **ArrayList** (armazenamento em memória dos veículos e usuários)

---

## ⚙️ Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/NomeDoRepositorio.git
