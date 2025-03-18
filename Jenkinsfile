pipeline {
    agent any

    environment {
        MAVEN_HOME = "/usr/share/maven"
        PATH = "$PATH:$MAVEN_HOME/bin"
        DOCKER_IMAGE ="sushmadande/scientific-calculator"
        DOCKER_USERNAME = "sushmadande"
        DOCKER_PASSWORD = "123456789"
        SERVER_IP = "172.16.144.201"
        SSH_KEY_PATH = "/var/lib/jenkins/.ssh/id_rsa"
    }

    stages {
        stage('Setup Permissions') {
            steps {
                script {
                    sh '''
                    echo "Granting permissions to Jenkins user."
                    sudo usermod -aG docker jenkins
                    sudo mkdir -p /var/lib/jenkins/.ssh
                    sudo chown -R jenkins:jenkins /var/lib/jenkins/.ssh
                    sudo chmod 700 /var/lib/jenkins/.ssh
                    '''
                }
            }
        }

        stage('GitHub Cloning') {
            steps {
                git branch: 'main', url: "https://github.com/sushmaDandeboyina/SPE_calculator.git"
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Containerizing Application') {
            steps {
                sh 'sudo docker build -t ${DOCKER_IMAGE} .'
            }
        }

        stage('Pushing to Docker Hub') {
            steps {
                script {
                    sh '''
                    echo "Logging in to Docker Hub..."
                    echo "${DOCKER_PASSWORD}" | sudo docker login -u "${DOCKER_USERNAME}" --password-stdin
                    sudo docker push ${DOCKER_IMAGE}
                    '''
                }
            }
        }

        stage('Run Ansible Deployment') {
            steps {
                script {
                    sh '''
                    echo "Creating Ansible hosts.ini file..."
                    # echo "[servers]" > hosts.ini
                    # echo "${SERVER_IP} ansible_user=sushma ansible_ssh_private_key_file=${SSH_KEY_PATH}" >> hosts.ini

                    echo "Started Ansible Playbook..."
                    ansible-playbook -i hosts.ini deploy.yml
                    '''
                }
            }
        }
    }

    post {
        success {
            echo "ALL stages executed successfully! The Scientific Calculator is deployed."
        }
        failure {
            echo "Error! Check the logs for errors."
        }
    }
}
