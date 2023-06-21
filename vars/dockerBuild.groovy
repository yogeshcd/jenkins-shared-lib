def call(Map creds){
    withCredentials([string(credentialsId: 'aws_account_id', variable: 'aws_account_id')]) {
        // some block
        sh """
        docker build -t ${creds.private_repo_name}/${creds.project_name} .
        docker tag ${creds.private_repo_name}/${creds.project_name}:latest ${aws_account_id}.dkr.ecr.${creds.region}.amazonaws.com/${creds.private_repo_name}/${creds.project_name}:latest
        """
    }
}

