def call(Map creds){
    // terraform plan -var "AWS_ACCESS_KEY=${creds.access_key}" -var "AWS_SECRET_ACCESS_KEY=${creds.AWS_SECRECT_ACCESS_KEY}" --var-file=terraform.tfvars
        // terraform init -migrate-state -backend-config="access_key=$AWS_ACCESS_KEY" -backend-config="secret_key=$AWS_SECRECT_ACCESS_KEY"
    sh """
        terraform init -force-copy
        terraform validate
        
        terraform plan -var "AWS_ACCESS_KEY=$AWS_ACCESS_KEY" -var "AWS_SECRET_ACCESS_KEY=$AWS_SECRECT_ACCESS_KEY" --var-file=terraform.tfvars
        
        terraform apply -var "AWS_ACCESS_KEY=$AWS_ACCESS_KEY" -var "AWS_SECRET_ACCESS_KEY=$AWS_SECRECT_ACCESS_KEY" --var-file=terraform.tfvars --auto-approve
    """
}