def call(Map creds) {
    sh """
    aws configure set aws_access_key_id "$AWS_ACCESS_KEY"
    aws configure set aws_secret_access_key "$SECRET_KEY"
    aws configure set region "${params.Region}"
    aws eks --region ${params.Region} update-kubeconfig --name ${params.cluster}
    """
}