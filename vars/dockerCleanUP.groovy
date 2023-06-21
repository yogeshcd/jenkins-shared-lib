def call(Map creds){
    sh """
    docker rmi ${creds.private_repo_name}
    docker rmi ${aws_account_id}.dkr.ecr.${creds.region}.amazonaws.com/${creds.private_repo_name}:latest
    """
}