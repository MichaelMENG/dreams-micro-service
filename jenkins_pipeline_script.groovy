#!groovy
pipeline {
    agent any

    environment {
        REPOSITORY="ssh://git@gitlab.dreams.com:2222/michael/dreams-micro-service.git"
        MODULE="user-edge-service"
        SCRIPT_PATH="/var/jenkins_home/scripts"
    }

    stages {

        stage('获取代码') {
            steps {
                echo "start fetch code from git:${REPOSITORY}"
                deleteDir()
                git "${REPOSITORY}"
            }
        }

        stage('代码检查') {
            steps {
                echo "start code check"
            }
        }

        stage('编译+单元测试') {
            steps {
                echo "start compile"
                sh "mvn -U -pl ${MODULE} -am clean package -DskipTests"
            }
        }

        stage('构建镜像') {
            steps {
                echo "start build image"
                sh "chmod 755 jenkins-build.sh"
                sh "sh jenkins-build.sh user-edge-service"
            }
        }

        stage('发布系统') {
            steps {
                echo "start deploy"
                sh "chmod 755 k8s-deploy.sh"
                sh "sh k8s-deploy.sh user-service-deployment user-edge-service"
            }
        }

    }
}