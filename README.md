# Olá somos o Sqaud01👋, (Quem é vocês mah?)

    Nosso squad é formado por Daniel, João, Brizamar, lidia e jorge.

​

# E esse é o nosso Projeto Demoday 👨‍💻 

    Desenvolvevemos um sistema de compra e venda de imóveis. 

​

# Objetivo do Projeto🌱

    Ser inovador como um produto autonomo e resposável. 

​

# Mas, eai qual foram as tecnologias utilizadas 📝

       -Fale-me mais? 💬 

    De forma geral 
    

- FrontEnd: Thymeleaf

- BackEnd: Java(Spring) e Keycloak 

- Banco de Dados: Postgres

- Infraestrutura: Docker e AWS

- Versionamento: Git

​
<p align="left"> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a>  <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> <a href="https://www.thymeleaf.org" target="_blank" rel="noreferrer"> <img src="https://www.thymeleaf.org/images/thymeleaf.png" alt="postgresql" width="40" height="40"/>  <a href="https://www.keycloak.org" target="_blank" rel="noreferrer"> <img src="https://www.marcus-povey.co.uk/wp-content/avatar.png" alt="postgresql" width="40" height="40"/>  <a href="https://www.postgresql.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="40" height="40"/> <a href="https://www.docker.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original-wordmark.svg" alt="docker" width="40" height="40"/> </a><a href="https://aws.amazon.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/amazonwebservices/amazonwebservices-original-wordmark.svg" alt="aws" width="40" height="40"/> </a> <a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a> </p>

​


   
   # Falando um pouco sobre segurança!
   
   No projeto utilizamos um servidor de autorização e autenticação keyclock! O keyclock é uma ferramenta <i>Open-Source</i> que permite a gerencia de perfis de usuários com configurações e customizações de forma a adequar o funcionamento do sistema a diferentes perfis de permissões e autenticação facilitando a gerência de usuários e politicas de acesso a recursos da aplicação.
   
   Dentre as funcionalidades ofertadas pelo keyclock podemos destacar:
        
    Criação de usuário (podendo ser criados pelo administrador do sistema e habilitado ou não para o próprio usuário se cadastrar)
    Login, “esqueci minha senha” e login com plataformas externas como redes sociais;
    Ativação de usuários por confirmação de e-mail;
    Necessidade de aceitação de termos de uso antes de logar;
    Customização das páginas que o usuário acessa (como a própria tela de login);
    Serviços para que outras aplicações busquem dados de usuários;
    Criação de permissões que o sistema vai usar;
    Criação de grupos de usuário.
    
    
# Título do Projeto

Uma breve descrição sobre o que esse projeto faz e para quem ele é

# Se liga na Api mah ⚡
   Primeiramente o uh fluxo - [Se despe!!](/docs/README.md)
   
# Oia a documentação mah 📄
#### Retorna todos os usuários cadastrados

```http
  GET /api/users
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `()` | `()` | Chamada direta  ao procedimento para listagem de todos os usuários. |

#### Retorna um usuário

```http
  GET /api/users/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `userId`      | `int` | **Obrigatório**. O ID do usuário para busca. |

```http
  POST /api/users/${id}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `userId`      | `int` | **Obrigatório**. O ID do usuário para salvar. |
| `user`      | `User` | **Obrigatório**. O 'user' a ser salvo.  |

Para salvar um usuário o idUser tem que ser igual a zero.

```http
  PUT /api/users/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `userId`      | `int` | **Obrigatório**. O ID do usuário para atualização. |
| `user`      | `User` | **Obrigatório**. Objeto 'user' a ser salvo.  |


```http
  DELET /api/users/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `userId`      | `int` | **Obrigatório**. O ID do usuário que será deletado. |

