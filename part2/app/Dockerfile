FROM node:slim

RUN npm install
COPY ./ /usr/src/app
WORKDIR /usr/src/app


CMD ["node", "app.js"]