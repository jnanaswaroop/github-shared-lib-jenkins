def call(String imageName) {
    stage('Docker Build & Push') {
        withCredentials([usernamePassword(credentialsId: 'DOCKERHUB-LOGIN-CREDS',
                                           usernameVariable: 'DOCKERHUB_USERNAME',
                                           passwordVariable: 'DOCKERHUB_PASSWORD')]) {
            sh """
               echo "$DOCKERHUB_PASSWORD" | docker login -u "$DOCKERHUB_USERNAME" --password-stdin
               docker build -t ${imageName} .
               docker push ${imageName}
            """
        }
    }
}

// dockerBuildPush("theshubhamgour/demo-app")
