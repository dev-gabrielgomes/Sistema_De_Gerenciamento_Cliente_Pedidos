### 🚀 Começando (Fluxo Git Básico)

Aqui está o passo a passo para **clonar o repositório** e configurar seu ambiente de desenvolvimento.

#### 1) Clonar o repositório e criar uma *branch* de desenvolvimento

Abra o terminal (Git Bash, PowerShell, Terminal do macOS/Linux) e execute os comandos:


bash
# 1. Clonar o repositório para a máquina local
```bash
git clone https://github.com/Ntzsbiel/Projeto-Spring-Boot.git
``` 


# 2. Entrar na pasta do projeto
```
cd Projeto-Spring-Boot
```
# 3. Garantir que estamos na branch principal (main)
```
git checkout main 
```

# 4. Baixar atualizações do remoto (se houver)
```bash
git pull origin main
```

# 5. Criar uma nova branch para desenvolver sua funcionalidade/correção

```bash
# Substitua 'feature/minha-feature' por um nome descritivo (ex: feature/cadastro-usuario)

git checkout -b feature/minha-feature
```
---


# 🗑️ Integrando e Finalizando a Contribuição

Após o desenvolvimento da nova funcionalidade estar completo e testado na sua branch de desenvolvimento (`feature/minha-feature`), o próximo passo é integrá-la à branch principal (`main`) do seu ambiente local, e depois enviar as mudanças para o repositório remoto.

---

## 🔀 1) Unir as Mudanças (Merge Local)

Primeiro, iremos sair da branch de funcionalidade e entrar na `main` para realizar a união do código.

### Trocar para a branch principal (`main`)

```bash
# Usamos 'switch' que é a sintaxe moderna para trocar de branch
git switch main
```

### Garantir que a main local está atualizada

```bash
# Puxa qualquer alteração nova do remoto antes de fazer o merge
git pull origin main
```

### Juntar a branch de funcionalidade à main

```bash
# Este comando incorpora todas as alterações da sua branch na main
# Substitua (nome da branch) pelo nome correto, ex: feature/cadastro-usuario
git merge (nome da branch)
```

📘 **Resultado:** O código foi adicionado à sua `main` local.

---

## 🚀 2) Enviar e Limpar

Com o código integrado localmente, enviamos para o repositório remoto e deletamos a branch antiga.

### Subir o código para o repositório remoto

```bash
# Envia a main local, que agora contém as novas funcionalidades, para o GitHub
git push origin main
```

### Deletar a branch antiga

A branch de desenvolvimento não terá mais utilidade, então podemos deletá-la para manter o repositório limpo.

```bash
# Deleta a branch localmente
# O -d é a flag "safe" para delete (só funciona se o merge foi completo)
git branch -d (nome da branch)
```



---

✅ Desta forma, sua contribuição foi **integrada com sucesso** e seu ambiente local está limpo.


## 🔖 Padrões de Commit (Conventional Commits)

Adotamos a especificação **Conventional Commits** para padronizar as mensagens de *commit* em nosso projeto. Essa convenção torna o histórico do Git mais claro, permite a geração automatizada de *changelogs* (registros de mudanças) e facilita a identificação da natureza de cada alteração.

### Formato Básico

A estrutura de uma mensagem de *commit* deve ser:

| Elemento | Descrição | Exemplo |
| :--- | :--- | :--- |
| **`<tipo>`** | Define a natureza da alteração (obrigatório). | `feat`, `fix`, `docs` |
| **`(<escopo>)`**| Opcional, fornece um contexto (ex: `api`, `ui`, `auth`). | `feat(auth)` |
| **`<descrição>`**| Uma descrição curta e imperativa do que o *commit* faz (máx. 70 caracteres). | `adiciona endpoint de login` |

### Tipos Mais Comuns

Abaixo estão os tipos de *commit* mais utilizados e seus propósitos:

| Tipo | Descrição | Exemplo de Uso |
| :--- | :--- | :--- |
| **`feat`** | Adiciona uma **nova funcionalidade** ao sistema. | `feat: adiciona campo de telefone ao cadastro de usuário` |
| **`fix`** | **Corrige um *bug*** (um problema que afetava a funcionalidade). | `fix: corrige erro 500 ao salvar dados no banco` |
| **`docs`** | Alterações na **documentação** do projeto (README, guias, Javadoc, etc.). | `docs: atualiza seção de pré-requisitos no README` |
| **`style`** | Mudanças relacionadas à **formatação** (espaços, ponto e vírgula, indentação), que não alteram o código. | `style: corrige indentação em controllers` |
| **`refactor`** | Reestruturação ou alteração de código que **não adiciona funcionalidade** nem corrige *bug*. | `refactor: move classes de serviço para pacote 'service'` |
| **`test`** | Adiciona, altera ou remove **testes** unitários, de integração ou e2e. | `test: adiciona testes de unidade para serviço de cálculo` |
| **`chore`** | Tarefas de **manutenção** que não afetam o código-fonte ou testes (ex: configuração de build, atualização de dependências menores). | `chore: atualiza versão do plugin maven` |
| **`build`** | Mudanças que afetam o **sistema de *build*** ou dependências externas (ex: Maven, Gradle, npm). | `build: atualiza dependência do Spring Security` |
| **`ci`** | Alterações nos arquivos de configuração de **Integração Contínua** (CI). | `ci: adiciona novo passo de lint no pipeline` |
| **`perf`** | Alterações de código que visam **melhorar a performance** do sistema. | `perf: otimiza query de busca por usuário` |


### Exemplos de commits:
```bash
git commit -m "feat (usuario): adiciona verificação de token JWT"
```

```bash
git commit -m "fix(database): corrige erro ao conectar com MySQL"
```
