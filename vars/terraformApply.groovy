def call(Map creds){
    sh """
        terraform init
        terraform validate
        terraform plan --var-file=terraform.tfvars
        terraform apply --var-file=terraform.tfvars --auto-approve
    """
}