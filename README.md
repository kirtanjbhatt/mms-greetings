# mms-greetings
Demo springboot app to get the greetings message from encrypted secrets.

# Features: 
Github workflow - /.github/workflows/pipelines.yaml

Github secrets and environments 

Build code using maven

Build docker image

Push image to GCR

Promote to dev - Update the image tag in kustomize file under /deploy/dev location. Argocd will identify the change and deploy the yaml files to dev env

Promote to prod - Update the image tag in kustomize file under /deploy/prod location. Argocd will identify the change and deploy the yaml files to prod env. Additional approval is needed to deploy the image to productions


# Additional features that can be added:
Argocd installation worlflow

Google cloud resource workflow

Test coverage

Sonar check

Automation test



# How to run app

## Set greeting message as env 
export MMS_GREETING_MSG=hello world

## Clean and compile
mvn clean & compile

## Create jar file
mvn clean package spring-boot:repackage

## Run
mvn spring-boot:run

## Test

Read message from env variable
http://localhost:8089/

Read message from volume mount:
http://localhost:8089/greet
