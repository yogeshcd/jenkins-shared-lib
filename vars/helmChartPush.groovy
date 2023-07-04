def call(Map creds) {
        withCredentials([string(credentialsId: 'aws_account_id', variable: 'aws_account_id')]) {
        // some block
            sh """
            helm package ${creds.package_name}
            aws ecr get-login-password --region ${creds.region} | helm registry login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${creds.region}.amazonaws.com
            """
    }
}