# base image
FROM node:12.2.0-alpine

# set working directory
WORKDIR /app

COPY . ./

RUN npm install --silent

# start app
CMD ["npm", "start"]

EXPOSE 3000
