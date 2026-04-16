# 🏎️ F1 Manager (Telemetry & Stats API)

Um sistema de extração, processamento e gamificação de dados da Fórmula 1. 

Este projeto nasceu como uma aplicação console em **Java puro** focado em consolidar fundamentos de Arquitetura de Software e Clean Code, e está em processo de evolução para se tornar uma API RESTful completa com **Spring Boot**.

## 📌 Status Atual: Versão 1.0 (Console ETL)

Atualmente, o projeto atua como um pipeline de dados (ETL - Extract, Transform, Load) rodando via terminal. Ele consome a API externa [Jolpica F1](https://jolpi.ca/), processa os dados complexos (JSON) e os salva localmente de forma estruturada.

### 🛠️ Tecnologias e Padrões Aplicados (V1.0)
* **Java 17+:** Base sólida da linguagem.
* **HttpClient (Nativo):** Consumo dinâmico de endpoints externos.
* **Gson:** Desserialização de estruturas JSON complexas, mapeamento de nulos e formatação.
* **Java NIO2 (Files):** Persistência de dados em arquivos `.json` locais.
* **Arquitetura em Camadas:** Código rigorosamente separado em `Client`, `Service`, `Model`, `DTO` e `Repository`.
* **Generics & Polimorfismo:** Uso de `List<?>` para criar um repositório agnóstico e reutilizável.
* **Tratamento de Exceções:** Blocos `try/catch` para garantir a resiliência em falhas de rede ou I/O.

## 🚀 Roadmap: A Caminho da Versão 2.0 (Spring Boot)

A base do código foi desenhada de forma totalmente desacoplada para facilitar a transição para um framework web. Os próximos passos incluem:

- [ ] **Migração para Spring Boot:** Transformar o projeto em uma Web API.
- [ ] **Persistência Relacional (MySQL & Spring Data JPA):** Substituir a geração de arquivos por um banco de dados real, modelando entidades e seus relacionamentos (`@Entity`, `@ManyToOne`).
- [ ] **Sistema de Ligas e Palpites:** Criação de lógica de negócio onde usuários poderão dar palpites nos pódios das corridas e acumular pontos ao longo da temporada.
- [ ] **Motor de Estatísticas (Head-to-Head):** Endpoints analíticos comparando o desempenho histórico de companheiros de equipe para auxiliar nos palpites.
- [ ] **Integração com Dashboards:** Fornecer dados limpos e mastigados para futuras análises visuais em Python (ex: integração com Streamlit) ou ferramentas de BI.

## ⚙️ Como executar a Versão 1.0

**1. Clone este repositório:**
```bash
git clone [https://github.com/anterosuehtam/f1-manager.git](https://github.com/anterosuehtam/f1-manager.git)
```

**2. Abra o projeto:**
Abra o diretório na sua IDE de preferência (IntelliJ, Eclipse, etc).

**3. Configure as dependências:**
Certifique-se de que a biblioteca Gson está devidamente baixada pelo Maven (pom.xml).

**4. Execute a aplicação:**
Rode a classe Main.java.

**5. Verifique o resultado:**
Observe o console e a raiz do projeto para visualizar os arquivos .json gerados automaticamente com os dados atualizados do grid e das equipes!

Desenvolvido por [Matheus Antero](https://www.linkedin.com/in/matheus-antero-/) - Consolidando conhecimentos práticos em Back-end.
