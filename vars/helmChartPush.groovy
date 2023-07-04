def call(Map creds) {
        withCredentials([string(credentialsId: 'aws_account_id', variable: 'aws_account_id')]) {
        // some block
                    // /bin/bash HELM_CHART_VERSION=$(helm inspect chart . | grep version: | awk '{print $2}')
            sh """
            helm package ${creds.package_name}
            aws ecr get-login-password --region ${creds.region} | helm registry login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${creds.region}.amazonaws.com

            """


    }
}