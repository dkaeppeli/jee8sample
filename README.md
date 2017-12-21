# Build
mvn clean package && docker build -t li.kaeppe.jee/jee8sample .

# RUN

docker rm -f jee8sample || true && docker run -d -p 8080:8080 -p 4848:4848 --name jee8sample li.kaeppe.jee/jee8sample 