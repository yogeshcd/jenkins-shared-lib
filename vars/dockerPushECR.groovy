def call(Map creds) {
    withCredentials([string(credentialsId: 'aws_account_id', variable: 'aws_account_id')]) {
        // aws ecr get-login-password --region ${creds.region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${creds.region}.amazonaws.com
        // docker push ${aws_account_id}.dkr.ecr.${creds.region}.amazonaws.com/${creds.private_repo_name}:latest
        sh """
        aws ecr get-login-password --region ${creds.region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${creds.region}.amazonaws.com
        docker push ${aws_account_id}.dkr.ecr.${creds.region}.amazonaws.com/${creds.private_repo_name}:latest

        """
    }
}

