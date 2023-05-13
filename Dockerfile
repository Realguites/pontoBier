# Use a imagem oficial do PostgreSQL como base
FROM postgres:latest

# Variáveis de ambiente para configurar o usuário, senha e porta
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD 1234
ENV POSTGRES_DB mydatabase

# Exponha a porta 5432 para que possa ser acessada externamente
EXPOSE 5432