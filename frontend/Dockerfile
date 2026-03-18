FROM node:18-alpine
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
EXPOSE 5173
# Esto permite que Vite sea accesible desde fuera del contenedor
CMD ["npm", "run", "dev", "--", "--host"]