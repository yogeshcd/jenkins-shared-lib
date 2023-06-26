def call(Map creds){
    // terraform plan -var "AWS_ACCESS_KEY=${creds.access_key}" -var "AWS_SECRET_ACCESS_KEY=${creds.AWS_SECRECT_ACCESS_KEY}" --var-file=terraform.tfvars
        
    sh """
        terraform init
        terraform validate
        terraform plan --var-file=terraform.tfvars
        terraform plan -var "AWS_ACCESS_KEY=$AWS_ACCESS_KEY" -var "AWS_SECRET_ACCESS_KEY=$AWS_SECRECT_ACCESS_KEY" --var-file=terraform.tfvars
        
        terraform apply --var-file=terraform.tfvars --auto-approve
    """
}