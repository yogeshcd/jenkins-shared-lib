def call(Map creds){
    sh """
        terraform init
        terraform validate
        terraform plann -var "AWS_ACCESS_KEY=${creds.access_key}" -var "AWS_SECRET_ACCESS_KEY=${creds.AWS_SECRECT_ACCESS_KEY}" --var-file=terraform.tfvars
        terraform apply --var-file=terraform.tfvars --auto-approve
    """
}