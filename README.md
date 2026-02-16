# Conversor de moedas - Challenger Oracle Next Education

Aplicação para conversão de moedas em tempo real utilizando API externa, desenvolvida com foco em consumo de APIs REST e manipulação de JSON com Java.

---

## 🚀 Demonstração

O usuário inicia a aplicação e tem acesso a um menu com as opções de ir para a conversão de moedas, atualizar as taxas ou sair da aplicação.

<img width="359" height="257" alt="image" src="https://github.com/user-attachments/assets/82e5379e-7b16-42c0-9f0c-da553299777b" />

Caso o usuário escolha atualizar as taxas, o sistema fará uma nova chamada para a API para trazer as taxas mais atuais e informará se a ação foi bem sucedida.

<img width="330" height="33" alt="image" src="https://github.com/user-attachments/assets/753c2170-7939-46f6-b8f3-8a937d01d10b" />

Caso o usuário opte por efetuar a conversão, será chamado um novo menu para que ele escolha para qual moeda quer converter o valor base em reais.

<img width="390" height="354" alt="image" src="https://github.com/user-attachments/assets/542f9d92-3cfc-4272-9a82-114ab9c46550" />

Ao selecionar uma opção, o usuário poderá informar o valor que deseja converter e o sistema exibirá o valor na moeda destino. No exemplo abaixo foi usado o valor 10.

<img width="324" height="56" alt="image" src="https://github.com/user-attachments/assets/583bc4a9-b72e-4fcd-a568-3769ab4f7a88" />

---

## 🧠 Objetivo do Projeto

- Este projeto foi criado com o intuito de colocar em prática todos os conhecimentos adquiridos nos cursos base da fase Tech Foundation da ONE.  
- Demonstra a capacidade de trabalhar com bibliotecas externas, como Gson, tratar dados retornados em JSON, efetuar consumo de API e implementar lógica complexa em Java.  
- Esse desafio faz parte do curso Tech Foundation da Oracle Next Education (ONE).  

---

## ⚙️ Funcionalidades

- ✔️ Conversão entre moedas  
- ✔️ Consumo de API externa  
- ✔️ Exibição de taxas atualizadas  
- ✔️ Interface textual via terminal  

---

## 🛠️ Tecnologias Utilizadas

- Java  
- HttpClient  
- Gson  
- ExchangeRate API  

---

## 🔌 Como Executar o Projeto

1. Clone o repositório
git clone https://github.com/paulodiegosantos/Oracle-Next-Education---Challenge-conversor-de-moedas.git

2. Entre na pasta do projeto
cd conversor_de_moedas

3. Compile e execute o projeto Java
javac src/Main.java
java src/Main

Opcional:
Caso queira utilizar uma API Key própria, crie sua chave no site da Exchange Rate API e adicione diretamente na variável **ApiKey** no começo do código.

## 📖 Aprendizados

Durante o desenvolvimento do projeto, foram aplicados e reforçados diversos conhecimentos:

Consumo de APIs REST e interpretação de respostas JSON

Manipulação de dados com Gson

Estruturação de código em Java com boas práticas

Implementação de menus interativos via terminal

Tratamento de exceções e validação de entradas do usuário

Esses pontos demonstram a capacidade de lidar com dados externos e lógica de negócios de forma organizada.

## 👨‍💻 Autor

Paulo Diego Dos Santos

LinkedIn: [https://www.linkedin.com/in/paulodiegosantos/](https://www.linkedin.com/in/paulodiegosantos/)

GitHub: [https://github.com/paulodiegosantos](https://github.com/paulodiegosantos)
