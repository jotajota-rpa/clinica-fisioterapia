FROM node:lts-slim
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
EXPOSE 5173
# Esto permite que Vite sea accesible desde fuera del contenedor
CMD ["npm", "run", "dev", "--", "--host"]