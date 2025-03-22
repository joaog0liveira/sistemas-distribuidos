# Aplicação Cliente-Servidor com TCP

Este projeto implementa uma aplicação cliente-servidor onde o cliente envia uma região geográfica (ex: `America/Sao_Paulo`) e o servidor responde com a hora local correspondente a essa região.

A comunicação é feita via **protocolo TCP**, com duas versões disponíveis:

- **Versão 1 - TCP Simples:** O servidor trata uma conexão por vez.
- **Versão 2 - TCP Multithread:** O servidor pode atender múltiplos clientes simultaneamente, utilizando threads.

---

##  Estrutura dos Arquivos

- `tcp.Servidor.java` — Servidor TCP (conexão única)
- `tcp.Cliente.java` — Cliente TCP (conexão única)
- `tcpthreads.Cliente.java` — Cliente TCP múltiplas conexões
- `tcpthreads.Servidor.java` — Servidor TCP com suporte a múltiplas conexões

---

##  Como Executar e Testar

### Pré-requisitos

- Java instalado (Utilizado 21 no projeto)
- Terminal ou prompt de comando

---

##  Compilação

No terminal, vá até a pasta onde estão os arquivos `.java` e execute, como todos os arquivos das diferentes versões
possuem o mesmo nome é necessário estar dentro da package exata para teste:

```bash
javac Cliente.java Servidor.java
```

##  Exemplos de regiões válidas:
```bash
America/Sao_Paulo
Europe/London
Asia/Tokyo
America/New_York
```