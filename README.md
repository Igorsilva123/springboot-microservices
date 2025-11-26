# Microserviço de Pagamentos - Delivery

Microserviço responsável pelo gerenciamento de pagamentos no sistema de delivery, integrando pedidos, gateways de pagamento e comunicação com outros microserviços via Eureka e OpenFeign.

---

## Tecnologias Utilizadas

- Java 17
- Spring Boot 2.6.7
- Spring Data JPA
- Spring Web
- Spring Validation
- Spring Boot Starter AOP
- MySQL
- Flyway (migrações de banco)
- Lombok
- MapStruct (mapeamento de DTOs e entidades)
- Spring Cloud Netflix Eureka Client (descoberta de serviços)
- Spring Cloud OpenFeign (chamadas entre microserviços)
- Resilience4j (tolerância a falhas)
- Maven

---

## Funcionalidades

### Pagamentos
- Criação e gerenciamento de pagamentos vinculados a pedidos.
- Suporte a diferentes gateways de pagamento.
- Registro de status de pagamento: PENDENTE, APROVADO, CANCELADO.

### Integração com Microserviços
- Comunicação com microserviço de pedidos via Feign Client.
- Descoberta de serviços com Eureka.
- Circuit breaker e retry configurados via Resilience4j.

### Segurança e Validação
- Validação de DTOs via Hibernate Validator.
- Registro de logs e monitoramento de falhas com AOP.

---

## Estrutura do Projeto

├── br.com.alurafood.pagamentos
│ ├── controller # Endpoints REST para pagamento
│ ├── dto # Data Transfer Objects
│ ├── entities # Entidades JPA (Payment, OrderReference)
│ ├── repository # Repositórios JPA
│ ├── service # Lógica de negócio
│ ├── client # Feign clients para comunicação com outros microserviços
│ └── PagamentosApplication.java # Classe principal Spring Boot



---

## Configuração do Banco de Dados

- O projeto utiliza MySQL.
- Configuração no `application.properties` ou `application.yml`:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/pagamentos_db
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
