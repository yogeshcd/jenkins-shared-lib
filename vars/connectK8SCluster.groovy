def call(Map creds) {
    sh """
    aws configure set aws_access_key_id "$AWS_ACCESS_KEY"
    aws configure set aws_secret_access_key "$AWS_SECRECT_ACCESS_KEY"
    aws configure set region "${creds.region}"
    aws eks --region ${creds.region} update-kubeconfig --name ${creds.cluster}
    """
}