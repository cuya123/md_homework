FROM fabric8/java-centos-openjdk8-jdk

USER root

RUN yum install -y git

WORKDIR /home/app
ADD application.properties /home/app/application.properties

RUN git clone https://github.com/cuya123/md_homework.git

WORKDIR /home/app/md_homework

RUN chmod +x gradlew
RUN ./gradlew build --exclude-task test

ADD deploy.sh /home/app/deploy.sh
RUN sed -i 's/\r$//' /home/app/deploy.sh
RUN chmod +x /home/app/deploy.sh

CMD ["/home/app/deploy.sh"]