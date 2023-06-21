def call(Map creds) {
    withCredentials([string(credentialsId: 'aws_account_id', variable: 'aws_account_id')]) {
        sh """
        
        trivy image ${aws_account_id}.dkr.ecr.${creds.region}.amazonaws.com/${creds.private_repo_name}:latest
        """
    }
}