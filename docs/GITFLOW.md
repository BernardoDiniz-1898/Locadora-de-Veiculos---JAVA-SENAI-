# Git Flow

Este projeto adota o modelo **Git Flow** para organizar o desenvolvimento.

## Branches

| Branch | Finalidade |
| --- | --- |
| `main` | Código estável, pronto para entrega. Cada commit é uma versão publicada. |
| `develop` | Integração das funcionalidades em desenvolvimento. Base para novas features. |
| `feature/*` | Desenvolvimento de funcionalidades ou refatorações. Sai da `develop`. |
| `release/*` | Preparação de uma versão (ajustes finais, testes). Sai da `develop`. |
| `hotfix/*` | Correções urgentes em produção. Sai da `main`. |

## Fluxo de trabalho

### Nova funcionalidade

```bash
git checkout develop
git pull origin develop
git checkout -b feature/nome-da-feature

# ... desenvolve e commita ...

git checkout develop
git merge --no-ff feature/nome-da-feature
git push origin develop
git branch -d feature/nome-da-feature
git push origin --delete feature/nome-da-feature
```

### Publicar uma versão (release)

```bash
git checkout develop
git checkout -b release/1.0.0

# ... ajustes finais ...

git checkout main
git merge --no-ff release/1.0.0
git tag -a v1.0.0 -m "Versão 1.0.0"
git push origin main --tags

git checkout develop
git merge --no-ff release/1.0.0
git push origin develop
git branch -d release/1.0.0
```

### Correção urgente (hotfix)

```bash
git checkout main
git checkout -b hotfix/1.0.1

# ... corrige ...

git checkout main
git merge --no-ff hotfix/1.0.1
git tag -a v1.0.1 -m "Versão 1.0.1"
git push origin main --tags

git checkout develop
git merge --no-ff hotfix/1.0.1
git push origin develop
git branch -d hotfix/1.0.1
```

## Convenção de commits

Sugestão de padrão (Conventional Commits):

- `feat:` nova funcionalidade
- `fix:` correção de bug
- `refactor:` refatoração sem mudança de comportamento
- `docs:` alterações na documentação
- `chore:` tarefas de manutenção/build
- `test:` testes

Exemplo:

```text
feat: separa projeto em camadas model/repository/service/view
```
