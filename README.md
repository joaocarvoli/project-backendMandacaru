# Olá somos o Squad01👋, (Quem são vocês mah?)

    Nosso squad é formado por Daniel, João, Brizamar, Lídia e Jorge.

​

# E esse é o nosso Projeto Demoday 👨‍💻 

    Sistema de compra e venda de imóveis, integrado com API de validação(PDSing) sedida pela empresa Portal de documentos. 

​

# Objetivo do Projeto🌱

    Desenvolver um produto(MVP) com tecnologias atualmente utilizadas no mercado de desenvolvimento de software, 
    somando criatividade, inovação, metodologias ágeis com compromisso e respossabilidade. 

​

# Mas, e ai? Quais foram as tecnologias utilizadas? 📝

       -Fale-me mais? 💬 

    De forma geral 
    

- FrontEnd: Thymeleaf

- BackEnd: Java(Spring) e Keycloak 

- Banco de Dados: Postgres

- Infraestrutura: Docker e AWS

- Versionamento: Git e GitHub

- Gerenciamento: Jira

​
<p align="left"> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a>  <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> <a href="https://www.thymeleaf.org" target="_blank" rel="noreferrer"> <img src="https://www.thymeleaf.org/images/thymeleaf.png" alt="postgresql" width="40" height="40"/>  <a href="https://www.keycloak.org" target="_blank" rel="noreferrer"> <img src="https://www.marcus-povey.co.uk/wp-content/avatar.png" alt="postgresql" width="40" height="40"/>  <a href="https://www.postgresql.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="40" height="40"/> <a href="https://www.docker.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original-wordmark.svg" alt="docker" width="40" height="40"/> </a><a href="https://aws.amazon.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/amazonwebservices/amazonwebservices-original-wordmark.svg" alt="aws" width="40" height="40"/> </a> <a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a> 
<a href="/imgres?imgurl=https%3A%2F%2Fwac-cdn.atlassian.com%2Fdam%2Fjcr%3A5cae308d-24a4-40d0-8fe2-ce7f46cd7a02%2FJSW%2520sign-responsive.png%3FcdnVersion%3D505&amp;imgrefurl=https%3A%2F%2Fwww.atlassian.com%2Fbr%2Fsoftware%2Fjira&amp;tbnid=Ztumkcapvem6CM&amp;vet=12ahUKEwjlqIyyxPf5AhUXNrkGHZ6pCSkQMyg1egQIARBq..i&amp;docid=7VnjCR0uh72VwM&amp;w=200&amp;h=200&amp;q=jira&amp;ved=2ahUKEwjlqIyyxPf5AhUXNrkGHZ6pCSkQMyg1egQIARBq" data-navigation="server" target="_blank" rel="noreferrer"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRX28bys6e50wdjOWRT-qv0IkfxgYavh38eag&amp;usqp=CAU" style=width="40" height="40" alt="Jira></a>  
 <a href="https://github.com/logos" target="_blank" rel="noreferrer"><img src="https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png" style="width: 40px; height: 40px;"></a>   
    </p>
    


​


   
   # Falando um pouco sobre segurança🤝
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
    
    
# Título do Projeto👯
    
Demoday-App

# Se liga na Api mah ⚡
   Primeiramente o uh fluxo - [Se despe!!](/docs/README.md)
   
# Oia a documentação mah 📄
    
#### Index de acesso ao login keycloak
    
```http
  GET /index
``` 
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



#### Retorna todos os Imóveis cadastrados

```http
  GET /api/immobile
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `()` | `()` | Chamada direta  ao procedimento para listagem de todos os imóveis. |

#### Retorna um imóvel

```http
  GET /api/immobile/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `immobileId`      | `int` | **Obrigatório**. O ID do imóvel para busca. |

```http
  POST /api/immobile/${id}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `immobileId`      | `int` | **Obrigatório**. O ID do imóvel para salvar. |
| `immobile`      | `Immobile` | **Obrigatório**. O 'immobile' a ser salvo.  |

Para salvar um Imóvel o idImmobile tem que ser igual a zero.

```http
  PUT /api/immobile/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `immobileId`      | `int` | **Obrigatório**. O ID do imóvel para atualização. |
| `immobile`      | `Immobile` | **Obrigatório**. Objeto 'immobile' a ser salvo.  |


```http
  DELET /api/immobile/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `immobileId`      | `int` | **Obrigatório**. O ID do imóvel que será deletado. |

    
#### Retorna todos os idAd

```http
  GET "/{idAd}"
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `AdController` | `()` | `Chamada direta` |

#### Retorna um idAd

```http
  GET/{idAd}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `()` | `**Obrigatório**. http Status`|

```http
  GET/{idAd}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `idAd`      | `()` | `**Obrigatório**. retorna ad`|

