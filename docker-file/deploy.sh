#!/bin/bash

REPOSITORY=/home/app
PROJECT_NAME=md_homework
cp $REPOSITORY/$PROJECT_NAME/build/libs/*.jar $REPOSITORY/

JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

echo "> $JAR_NAME 에 실행권한 추가"

chmod +x $JAR_NAME

echo "> $JAR_NAME 실행"

java -jar \
   -Dspring.config.location=/home/app/application.properties \
   $JAR_NAME 
