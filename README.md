# 

## Model
www.msaez.io/#/storming/memp

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --isolation-level read_committed --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- emp


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- emp
```
 http :8088/users uxid="uxid" tenant_id="tenant_id" use_status="use_status" id="id" pass="pass" user_name="user_name" created_by="created_by" create_tm="create_tm" last_modi_by="last_modi_by" last_modi_tm="last_modi_tm" phoneNo="phoneNo" enterDt="enterDt" managerId="managerId" rankId="rankId" departmentId="departmentId" 
 http :8088/departments id="id" name="name" 
 http :8088/ranks id="id" name="name" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

